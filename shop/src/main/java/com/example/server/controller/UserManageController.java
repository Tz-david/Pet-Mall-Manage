package com.example.server.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.server.entity.UserManage;
import com.example.server.response.ResponseData;
import com.example.server.response.ResponseDataUtil;
import com.example.server.service.impl.UserManageServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserManageController {

    @Autowired
    private UserManageServiceImpl userService;

    private String appid ="wx2f92081b1ad98660";

    private String appsecret = "b5e7a85e6cc3affa28885b2b08fee851";


    private String accesstoken;
    private String openid;
    private String refreshtoken;
    private int expiresIn;
    private String unionid;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
//        return userService.findAll();
        return "hello";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseData login(@RequestParam(value = "username", required = true) String userName, @RequestParam(value = "password", required = true) String password){
//
//        List<UserManage> userManageList = userService.findAllByUserNameAndPassword(userName, password);
//        if (userManageList.size() > 0){
//            return ResponseDataUtil.buildSuccess(userManageList.get(0));
//        }else{
//            return ResponseDataUtil.buildError();
//        }
//    }

    @RequestMapping(value = "/login_wx", method = RequestMethod.POST)
    public ResponseData loginWx(@RequestBody String openid){

        List<UserManage> userManageList = userService.findAllByOpenid(openid);
        if (userManageList.size() > 0){
            return ResponseDataUtil.buildSuccess(userManageList.get(0));
        }else{
            return ResponseDataUtil.buildError();
        }

//        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody Map map){

        String username = (String) map.get("username");
        String password = (String) map.get("password");

        List<UserManage> userManageList = userService.findAllByUsernameAndPassword(username, password);
        if (userManageList.size() > 0){
            return ResponseDataUtil.buildSuccess(userManageList.get(0));
        }else{
            return ResponseDataUtil.buildError();
        }

//        return "hello";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseData getUsers(){

        List<UserManage> userManageList = userService.findAll();
        if (userManageList.size() > 0){
            return ResponseDataUtil.buildSuccess(userManageList);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData insert(@RequestBody UserManage user){
        //如果openid不为空且已有对应信息，则更新
        if (!TextUtils.isEmpty(user.getOpenid())){
            List<UserManage> userManageList = userService.findAllByOpenid(user.getOpenid());
            if (userManageList.size() > 0){

                user.setId(userManageList.get(0).getId());
            }
        }

        UserManage obj = userService.save(user);

        if (obj != null){
            return ResponseDataUtil.buildSuccess(obj);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    @RequestMapping(value = "/update_users", method = RequestMethod.POST)
    public ResponseData update(@RequestBody UserManage user){
        UserManage obj = userService.save(user);
        if (obj != null){
            return ResponseDataUtil.buildSuccess(obj);
        }else{
            return ResponseDataUtil.buildError();
        }
    }

    @RequestMapping(value = "/delete_users", method = RequestMethod.POST)
    public ResponseData delete(@RequestBody UserManage user){
        userService.delete(user);
        return ResponseDataUtil.buildSuccess();

    }

    @RequestMapping(value = "/get_openid", method = RequestMethod.POST)
    public ResponseData wxcallback(@RequestBody String code) throws IOException {
        // 第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid +
                "&secret=" + appsecret +
                "&js_code=" + code +
                "&grant_type=authorization_code";
//        https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        org.apache.http.client.HttpClient client = new DefaultHttpClient();
        URI uri = URI.create(url);
        HttpGet get = new HttpGet(uri);
        HttpResponse response;
        try {
            response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();

                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();

                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    sb.append(temp);
                }
                JSONObject object = JSONObject.parseObject(sb.toString().trim());
                System.out.println("object:"+object);
//                accesstoken = object.getString("access_token");
//                System.out.println("accesstoken:"+accesstoken);
                openid = object.getString("openid");
                System.out.println("openid:"+openid);
//                refreshtoken = object.getString("refresh_token");
//                System.out.println("refreshtoken:"+refreshtoken);
//                unionid = object.getString("unionid");
                return ResponseDataUtil.buildSuccess(object);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // 微信帐号做来一个关联，来关联我们的账号体系
        // 此处实现自己的保存用户信息逻辑
        return ResponseDataUtil.buildSuccess(openid);
    }
}
