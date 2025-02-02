package com.learn.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.core.utils.SpringUtil;
import com.learn.system.bean.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Config config;

    @RequestMapping("/hello")
    public JSONObject hello(){
        JSONObject object = new JSONObject();
        Config newConfig = new Config();
        object.put("newName",newConfig.getName());
        object.put("autoName",config.getName());
        Config sConfig = (Config)SpringUtil.getBean("config");
        object.put("springName", sConfig.getName());
        System.out.println(object.toJSONString());
        return object;
    }

}
