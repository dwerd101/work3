package com.example.mvc.converter;

import com.example.mvc.model.Model;
import com.example.mvc.model.Source;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    @SneakyThrows
    public static List<Model> returnList(String jsonArray, Model model) {

        JSONArray geoData = new JSONArray(jsonArray);
        int n = geoData.length();
        List<Model> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            JSONObject jsonObject = geoData.getJSONObject(i);
            String jsonText = jsonObject.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            Model source = objectMapper.readValue(jsonText, model.getClass() );
            list.add(source);
        }
        return list;
    }
}
