package com.example.demo.dao;

import com.example.demo.entity.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface DeviceModelRepository extends JpaRepository<DeviceModel,Long> {

    @Query(value = "select model_info #>> '{feature,monitor}'as monitor from device_model as d where d.id = ?1",nativeQuery = true)
    Map<String,Object> selectMonitorByModelID(Long modelId);

    @Query(value = "select model_info #>> '{feature,monitor}'as monitor from device_model as d where d.deviceId = ?1",nativeQuery = true)
    Map<String,Object> selectMonitorByDeviceID(Long DeviceID);

    @Query(value = "select model_info #>> '{attribute}'as monitor from device_model as d where d.id = ?1",nativeQuery = true)
    Map<String,Object> selectAttributeByModelID(Long modelId);

    @Query(value = "select model_info #>> '{attribute}'as monitor from device_model as d where d.deviceId = ?1",nativeQuery = true)
    Map<String,Object> selectAttributeByDeviceID(Long DeviceID);

    @Query(value = "select model_info  from device_model as d where d.deviceId = ?1",nativeQuery = true)
    Map<String,Object> selectModelByDeviceID(Long DeviceID);

    @Query(value = "select model_info  from device_model as d where d.id = ?1",nativeQuery = true)
    Map<String,Object> selectModelBymodelID(Long model);

}
