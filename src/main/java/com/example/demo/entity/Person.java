package com.example.demo.entity;

import com.example.demo.Servcie.JsonbType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
public class Person extends IdEntity{


    private Map<String,Object> info;

    @Column(name = "info",columnDefinition = "jsonb",length = 1024)
    @Type(type = "JsonbType")
    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
