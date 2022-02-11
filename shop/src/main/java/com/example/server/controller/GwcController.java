package com.example.server.controller;

import com.alibaba.fastjson.JSON;
import com.example.server.entity.*;
import com.example.server.response.ResponseData;
import com.example.server.response.ResponseDataUtil;
import com.example.server.service.impl.GoodServiceImpl;
import com.example.server.service.impl.GwcServiceImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

import static com.example.server.UpLoadFile.BaseImageUrl;

@RestController
@CrossOrigin
public class GwcController {

    @Autowired
    private GwcServiceImpl service;
    @Autowired
    private GoodServiceImpl goodService;

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


    @RequestMapping(value = "/get_gwc", method = RequestMethod.POST)
    public ResponseData getGwc(@RequestBody int userId){

        //商品基本信息
        QGood _Q_good = QGood.good;
        //商品类型
        QGwc _Q_Gwc = QGwc.gwc;

        List<GwcGood> resultList = queryFactory
                .select(
                        Projections.bean(
                                GwcGood.class,//返回自定义实体的类型
                                _Q_Gwc.id,
                                _Q_Gwc.num,
                                _Q_Gwc.goodid,
                                _Q_Gwc.userId,
                                _Q_good.image,
                                _Q_good.title,
                                _Q_good.price

                        )
                )
                .from(_Q_Gwc,_Q_good)//构建两表笛卡尔集
                .where(_Q_Gwc.goodid.eq(_Q_good.id).and(_Q_Gwc.userId.eq(userId)))//关联两表
                .orderBy(_Q_Gwc.id.desc())//倒序
                .fetch();

        for (int i = 0; i < resultList.size(); i++) {
            GwcGood gwcGood =  resultList.get(i);
            gwcGood.setImage(BaseImageUrl + gwcGood.getImage());
        }

        if (resultList.size() > 0){
            return ResponseDataUtil.buildSuccess(resultList);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    @RequestMapping(value = "/update_gwc", method = RequestMethod.POST)
    public ResponseData updateGwc(@RequestBody String listJSON){
        //先删除所有的购物车数据
//        service.deleteAll(service.findAll());
        List<GwcGood> gwcGoodList = JSON.parseArray(listJSON,GwcGood.class);
        int userId;
        for (int i = 0; i < gwcGoodList.size(); i++) {
            GwcGood gwcGood =  gwcGoodList.get(i);
            Gwc gwc = new Gwc();
            gwc.setId(gwcGood.getId());
            gwc.setGoodid(gwcGood.getGoodid());
            gwc.setNum(gwcGood.getNum());
            gwc.setValue(gwcGood.getPrice());
            gwc.setUserId(gwcGood.getUserId());
            if (service.findById(gwc.getId())!=null){
               service.save(gwc);
            }else{
                service.delete(gwc);
            }

        }

        if (gwcGoodList.size() > 0){
            return getGwc(gwcGoodList.get(0).getUserId());
        }else{
            return ResponseDataUtil.buildError();
        }


    }

    public ResponseData update(Gwc gwc){
        Gwc obj = service.save(gwc);
        if (obj != null){
            return ResponseDataUtil.buildSuccess(obj);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    public ResponseData delete(Gwc gwc){
        service.delete(gwc);
        return ResponseDataUtil.buildSuccess();
    }

    @RequestMapping(value = "/insert_gwc", method = RequestMethod.POST)
    public ResponseData insertGwc(@RequestBody Map request){
        int goodId = (int) request.get("good_id");
        int userId = (int) request.get("user_id");
        Good good = goodService.findById(goodId);
        Gwc gwc;
        List<Gwc> gwcList = service.findAllByGoodIdAndUserId(goodId,userId);
        if (gwcList!= null && gwcList.size() > 0){
            gwc = gwcList.get(0);
            gwc.setNum((Integer.parseInt(gwc.getNum())+1)+"");
        }else{
            gwc = new Gwc();
            gwc.setGoodid(goodId);
            gwc.setNum("1");
            gwc.setValue(good.getPrice());
            gwc.setUserId(userId);
        }



        Gwc obj = service.save(gwc);

        if (obj != null){
            return ResponseDataUtil.buildSuccess(obj);
        }else{
            return ResponseDataUtil.buildError();
        }

    }

    @RequestMapping(value = "/delete_gwcs", method = RequestMethod.POST)
    public ResponseData deleteGwcs(@RequestBody String json){

        List<Gwc> gwcList = JSON.parseArray(json,Gwc.class);
        for (int i = 0; i < gwcList.size(); i++) {
            Gwc gwc =  gwcList.get(i);
            delete(gwc);
        }

        if (gwcList.size() > 0){
            return getGwc(gwcList.get(0).getUserId());
        }else{
            return ResponseDataUtil.buildError();
        }

    }
}
