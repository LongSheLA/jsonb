package com.example.demo.controller;

import com.example.demo.Servcie.DeviceModelService;
import com.example.demo.entity.DeviceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DeviceModelController {

    @Autowired
    private DeviceModelService deviceModelService;

    @PostMapping(value = "/saveModel")
    public ResponseEntity<?> saveModel(@RequestBody Map<String,Object> modelParam){
        DeviceModel deviceModel = new DeviceModel();
        DeviceModel deviceModel1 = null;
        try{
            deviceModel.setModelInfo(modelParam);
            deviceModel1 = deviceModelService.saveModel(deviceModel);
        }catch (Exception e){
            e.printStackTrace();
        }
      return ResponseEntity.status(HttpStatus.OK).body(deviceModel1);
    }

    @GetMapping("/findModel")
    @ResponseBody
    public ResponseEntity<?> findModel(@RequestParam("modelID")Long modelId){
        String path = "{feature,monitor}";
        Map<String, Object> stringObjectMap = null;

        try{
            stringObjectMap = deviceModelService.selectMonitorByModelID(modelId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(stringObjectMap);
    }

}
