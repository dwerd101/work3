package com.example.mvc.controller;

import com.example.mvc.converter.JsonConverter;
import com.example.mvc.model.Model;
import com.example.mvc.model.Source;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Controller
public class PageController {

    @SneakyThrows
    @GetMapping("/window")
    public String index(ModelMap map) throws JSONException {
        String url = "http://localhost:8090/source/all";
        String jsonArray = getJsonArray(url);
        List<Model> modelList = JsonConverter.returnList(jsonArray, new Source());
        map.addAttribute("list",modelList);
        return "index";
    }
    private static String getJsonArray(String urlText) {
       StringBuilder jsonArray = new StringBuilder();
        try {
            URL url = new URL(urlText);
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " +responsecode);

            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if(responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " +responsecode);
            else
            {
                //Scanner functionality will read the JSON data from the stream
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    jsonArray.append(sc.nextLine());
                }
                //Close the stream when reading the data has been finished
                sc.close();
            }

        } catch (Exception e) {e.printStackTrace();}
        return jsonArray.toString();
    }
}
