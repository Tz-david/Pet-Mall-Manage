package com.example.server.controller;

import com.example.server.entity.Suggest;
import com.example.server.response.ResponseData;
import com.example.server.response.ResponseDataUtil;
import com.example.server.service.impl.SuggestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.server.UpLoadFile.BaseImageUrl;

@RestController
@CrossOrigin
public class SuggestController {

    @Autowired
    private SuggestServiceImpl service;
    

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseData login(@RequestParam(value = "username", required = true) String userName, @RequestParam(value = "password", required = true) String password){
//
//        List<Suggest> SuggestList = service.findAllByUserNameAndPassword(userName, password);
//        if (SuggestList.size() > 0){
//            return ResponseDataUtil.buildSuccess(SuggestList.get(0));
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseData login(@RequestBody Map map){
//
//        String username = (String) map.get("username");
//        String password = (String) map.get("password");
//
//        List<Suggest> SuggestList = service.findAllByUsernameAndPassword(username, password);
//        if (SuggestList.size() > 0){
//            return ResponseDataUtil.buildSuccess(SuggestList.get(0));
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//
//    }

    @RequestMapping(value = "/get_suggest", method = RequestMethod.POST)
    public ResponseData getSuggest(){

        List<Suggest> SuggestList = service.findAll();
        for (int i = 0; i < SuggestList.size(); i++) {
            Suggest suggest =  SuggestList.get(i);
            suggest.setImage(BaseImageUrl+suggest.getImage());
        }
        if (SuggestList.size() > 0){
            return ResponseDataUtil.buildSuccess(SuggestList);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ResponseData insert(@RequestBody Suggest user){
//        Suggest obj = service.save(user);
//get_recommend
//        if (obj != null){
//            return ResponseDataUtil.buildSuccess(obj);
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }
//
//    @RequestMapping(value = "/update_users", method = RequestMethod.POST)
//    public ResponseData update(@RequestBody Suggest user){
//        Suggest obj = service.save(user);
//        if (obj != null){
//            return ResponseDataUtil.buildSuccess(obj);
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }
//
//    @RequestMapping(value = "/delete_users", method = RequestMethod.POST)
//    public ResponseData delete(@RequestBody Suggest user){
//        service.delete(user);
//        return ResponseDataUtil.buildSuccess();
//
//    }
}
