package com.example.demo.Servcie;

import com.example.demo.dao.DeviceModelRepository;
import com.example.demo.entity.DeviceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeviceModelServiceImpl implements DeviceModelService{

    @Autowired
    private DeviceModelRepository deviceModelRepository;

    @Override
    public DeviceModel saveModel(DeviceModel deviceModel){
        return deviceModelRepository.save(deviceModel);
    }

    public DeviceModelServiceImpl() {
        super();
    }

    @Override
    public Map<String, Object> selectMonitorByModelID(Long modelID) {
        return deviceModelRepository.selectMonitorByModelID(modelID);
    }

    @Override
    public Map<String, Object> selectMonitorByDeviceID(Long deviceID) {
        return deviceModelRepository.selectMonitorByDeviceID(deviceID);
    }

    @Override
    public Map<String, Object> selectAttributeByModelID(Long modelId) {
        return deviceModelRepository.selectAttributeByModelID(modelId);
    }

    @Override
    public Map<String, Object> selectAttributeByDeviceID(Long deviceID) {
        return deviceModelRepository.selectAttributeByDeviceID(deviceID);
    }

    @Override
    public Map<String, Object> selectModelByDeviceID(Long DeviceID) {
        return deviceModelRepository.selectModelByDeviceID(DeviceID);
    }

    @Override
    public Map<String, Object> selectModelBymodelID(Long modelID) {
        return deviceModelRepository.selectModelByDeviceID(modelID);
    }
}
