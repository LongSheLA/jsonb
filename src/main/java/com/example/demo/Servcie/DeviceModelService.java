package com.example.demo.Servcie;

import com.example.demo.entity.DeviceModel;

import java.util.Map;

public interface DeviceModelService {

    /**
     * 保存一个DEVICEMODEL 对象
     * @param deviceModel
     * @return
     */
    DeviceModel saveModel(DeviceModel deviceModel);

    /**
     * 根据指modelId查询monitor数据
     * @param modelID
     * @return
     */
     Map<String,Object> selectMonitorByModelID(Long modelID);

    /**
     * 根据指deviceID查询monitor数据
     * @param DeviceID
     * @return
     */
     Map<String,Object> selectMonitorByDeviceID(Long DeviceID);

    /**
     * 根据modelID查询Attribute
     * @param modelId
     * @return
     */
    Map<String,Object> selectAttributeByModelID(Long modelId);

    /**
     * 根据DeviceID查询Attribute
     * @param DeviceID
     * @return
     */
    Map<String,Object> selectAttributeByDeviceID(Long DeviceID);

    /***
     * 根据DeviceID查询model
     * @param DeviceID
     * @return
     */
    Map<String,Object> selectModelByDeviceID(Long DeviceID);

    /**
     * 根据deviceID 查询 model
     * @param model
     * @return
     */
    Map<String,Object> selectModelBymodelID(Long model);
}
