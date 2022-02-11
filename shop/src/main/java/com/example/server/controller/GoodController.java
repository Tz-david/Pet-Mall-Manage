package com.example.server.controller;

import com.example.server.entity.Good;
import com.example.server.response.ResponseData;
import com.example.server.response.ResponseDataUtil;
import com.example.server.service.impl.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.server.UpLoadFile.BaseImageUrl;

@RestController
@CrossOrigin
public class GoodController {

    @Autowired
    private GoodServiceImpl service;
    

    @RequestMapping(value = "/get_good", method = RequestMethod.POST)
    public ResponseData getGood(){

        List<Good> GoodList = service.findAll();
        for (int i = 0; i < GoodList.size(); i++) {
            Good Good =  GoodList.get(i);
            Good.setImage(BaseImageUrl+Good.getImage());
            Good.setImage2(BaseImageUrl+Good.getImage2());
            Good.setImage3(BaseImageUrl+Good.getImage3());
        }
        if (GoodList.size() > 0){
            return ResponseDataUtil.buildSuccess(GoodList);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    @RequestMapping(value = "/get_recommend", method = RequestMethod.POST)
    public ResponseData getRecommend(){

        List<Good> GoodList = service.findAllRecommend("true");
        for (int i = 0; i < GoodList.size(); i++) {
            Good Good =  GoodList.get(i);
            Good.setImage(BaseImageUrl+Good.getImage());
            Good.setImage2(BaseImageUrl+Good.getImage2());
            Good.setImage3(BaseImageUrl+Good.getImage3());
        }
        if (GoodList.size() > 0){
            return ResponseDataUtil.buildSuccess(GoodList);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    @RequestMapping(value = "/get_good_by_id", method = RequestMethod.POST)
    public ResponseData getGoodById(@RequestBody int id){



        Good good = service.findById(id);


        if (good != null){
            good.setImage(BaseImageUrl+good.getImage());
            good.setImage2(BaseImageUrl+good.getImage2());
            good.setImage3(BaseImageUrl+good.getImage3());
            return ResponseDataUtil.buildSuccess(good);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ResponseData insert(@RequestBody Good user){
//        Good obj = service.save(user);
//
//        if (obj != null){
//            return ResponseDataUtil.buildSuccess(obj);
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }
//
//    @RequestMapping(value = "/update_users", method = RequestMethod.POST)
//    public ResponseData update(@RequestBody Good user){
//        Good obj = service.save(user);
//        if (obj != null){
//            return ResponseDataUtil.buildSuccess(obj);
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }
//
//    @RequestMapping(value = "/delete_users", method = RequestMethod.POST)
//    public ResponseData delete(@RequestBody Good user){
//        service.delete(user);
//        return ResponseDataUtil.buildSuccess();
//
//    }
}
