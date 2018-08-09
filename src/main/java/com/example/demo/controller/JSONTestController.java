package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Servcie.JSONTestServcie;
import com.example.demo.entity.JSONTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONTestController {

    @Autowired
    private JSONTestServcie jsonTestServcie;

    @ResponseBody
    @PostMapping("/save")
    public void saveJson(@RequestBody JSONTest jsonTest){
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",4);
            jsonObject.put("name","名字");
            jsonObject.put("age",56);
            jsonTest.setJson(jsonObject);
            jsonTestServcie.save(jsonObject.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @ResponseBody
    @RequestMapping("/find")
    public ResponseEntity<?> find(){
        JSONTest jsonTest =null;
        try{
             jsonTest = jsonTestServcie.find();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(jsonTest);
    }



}
