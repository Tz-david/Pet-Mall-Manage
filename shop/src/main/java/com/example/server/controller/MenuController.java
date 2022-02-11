package com.example.server.controller;

import com.example.server.entity.Menu;
import com.example.server.response.ResponseData;
import com.example.server.response.ResponseDataUtil;
import com.example.server.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.server.UpLoadFile.BaseImageUrl;

@RestController
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuServiceImpl service;
    

    @RequestMapping(value = "/get_menu", method = RequestMethod.POST)
    public ResponseData getMenu(){

        List<Menu> MenuList = service.findAll();
        for (int i = 0; i < MenuList.size(); i++) {
            Menu Menu =  MenuList.get(i);

            if (Menu.getPicture() != null)
                Menu.setPicture(BaseImageUrl+Menu.getPicture());
        }
        if (MenuList.size() > 0){
            return ResponseDataUtil.buildSuccess(MenuList);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

}
