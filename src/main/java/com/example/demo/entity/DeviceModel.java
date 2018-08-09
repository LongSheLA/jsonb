package com.example.demo.entity;

import com.example.demo.Servcie.JsonbType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
public class DeviceModel extends IdEntity{

    private long deviceID;

    private Map<String,Object> modelInfo;

    public long getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(long deviceID) {
        this.deviceID = deviceID;
    }

    @Column(name = "model_info",columnDefinition = "jsonb",length = 2000)
    @Type(type = "JsonbType")
    public Map<String, Object> getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(Map<String, Object> modelInfo) {
        this.modelInfo = modelInfo;
    }
}
