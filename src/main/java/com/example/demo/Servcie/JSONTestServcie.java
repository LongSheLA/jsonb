package com.example.demo.Servcie;

import com.example.demo.dao.JSONTestDao;
import com.example.demo.entity.JSONTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JSONTestServcie {

    @Autowired
    private JSONTestDao jsonTestDao;

    public void save(String json){
//        json.replaceAll('"',"\"");
//         System.out.println(json);
        jsonTestDao.insert(json);
    }

    public JSONTest find(){
        return jsonTestDao.findJsonBYid();
    }

}
