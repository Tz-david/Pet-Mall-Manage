package com.example.server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.server.entity.*;
import com.example.server.response.ResponseData;
import com.example.server.response.ResponseDataUtil;
import com.example.server.service.impl.OrderinfoServiceImpl;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.server.UpLoadFile.BaseImageUrl;

@RestController
@CrossOrigin
public class OrderInfoController {

    @Autowired
    private OrderinfoServiceImpl service;
    //实体管理
    @Autowired
    private EntityManager entityManager;

    //查询工厂
    private JPAQueryFactory queryFactory;

    //初始化查询工厂
    @PostConstruct
    public void init()
    {
        queryFactory = new JPAQueryFactory(entityManager);
    }


    @RequestMapping(value = "/get_order", method = RequestMethod.POST)
    public ResponseData getOrder(@RequestBody int userId){

        //商品基本信息
        QGood _Q_good = QGood.good;
        //商品类型
        QOrderinfo _Q_Order = QOrderinfo.orderinfo;
        List<OrderGood> resultList = queryFactory
                .select(
                        Projections.bean(
                                OrderGood.class,//返回自定义实体的类型
                                _Q_Order.id,
                                _Q_Order.num,
                                _Q_Order.goodId,
                                _Q_Order.userId,
                                _Q_Order.time,
                                _Q_Order.state,
                                _Q_Order.orderId,
                                _Q_good.title,
                                _Q_good.price,
                                _Q_good.image

                        )
                )
                .from(_Q_Order,_Q_good)//构建两表笛卡尔集
                .where(_Q_Order.userId.eq(userId).and(_Q_good.id.eq(_Q_Order.goodId)) )//关联两表

                .fetch();

        for (int i = 0; i < resultList.size(); i++) {
            OrderGood OrderGood =  resultList.get(i);
            OrderGood.setImage(BaseImageUrl + OrderGood.getImage());
        }

        List<OrderLitItem> orderLitItemList = new ArrayList<>();
        for (int i = 0; i< resultList.size();i++){
            OrderGood OrderGood =  resultList.get(i);
            OrderLitItem item = new OrderLitItem();
            item.setTime(OrderGood.getTime());
            item.setState(OrderGood.getState());
            List<OrderGood> itemGoodsList =  new ArrayList<>();
            itemGoodsList.add(OrderGood);
            item.setGoodsList(itemGoodsList);
            item.setTotalPrice(Integer.parseInt(OrderGood.getPrice()));
            item.setId(OrderGood.getId());


            for (int j = i+1; j < resultList.size(); j++) {
                OrderGood OrderGood1 =  resultList.get(j);
                if (OrderGood.getOrderId().equals(OrderGood1.getOrderId())){
                    itemGoodsList.add(OrderGood1);
                }
                int totalPrice = item.getTotalPrice() + Integer.parseInt(OrderGood1.getPrice());
                item.setTotalPrice(totalPrice);
            }

            orderLitItemList.add(item);

        }


        return ResponseDataUtil.buildSuccess(orderLitItemList);

    }

    @RequestMapping(value = "/insert_order", method = RequestMethod.POST)
    public ResponseData insertOrder(@RequestBody Map map){
        String listJSON = (String) map.get("json");
        int userId = (int) map.get("user_id");
        String state = (String) map.get("state");
        List<GwcGood> gwcGoodList = JSON.parseArray(listJSON,GwcGood.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());


        String orderId = "DD" + Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < gwcGoodList.size(); i++) {
            GwcGood gwcGood =  gwcGoodList.get(i);
            Orderinfo order = new Orderinfo();

            order.setNum(Integer.parseInt(gwcGood.getNum()));
            order.setOrderId(orderId);
            order.setGoodId(gwcGood.getGoodid());
            order.setState(state);
            order.setUserId(userId);
            order.setTime(date);
            Orderinfo obj = service.save(order);
            if (obj != null){

            }
        }


        
        return ResponseDataUtil.buildSuccess();

    }

    @RequestMapping(value = "/update_order", method = RequestMethod.POST)
    public ResponseData updateOrder(@RequestBody Map map){


        String json = (String) map.get("json");
        int userId = (int) map.get("user_id");
        JSONObject object = JSONObject.parseObject(json);
        Orderinfo order = service.findById(object.getInteger("id"));
        order.setState(object.getString("state"));
        service.save(order);
//        order.setId(Integer.parseInt(gwcGood.getNum()));
//        order.setOrderId(orderId);
//        order.setGoodId(gwcGood.getGoodid());
//        order.setState(state);
//        order.setUserId(userId);
//        order.setTime(date);
//        Orderinfo obj = service.save(order);

//        List<GwcGood> gwcGoodList = JSON.parse(listJSON,GwcGood.class);




        return ResponseDataUtil.buildSuccess();

    }
//
//    public ResponseData update(Order Order){
//        Order obj = service.save(Order);
//        if (obj != null){
//            return ResponseDataUtil.buildSuccess(obj);
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }
//
//    public ResponseData delete(Order Order){
//        service.delete(Order);
//        return ResponseDataUtil.buildSuccess();
//
//    }
}
