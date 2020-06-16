package com.example.mvc.controller;

import com.example.mvc.converter.JsonConverter;
import com.example.mvc.model.Model;
import com.example.mvc.model.ProfileResultView;
import com.example.mvc.model.Source;
import lombok.SneakyThrows;
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
    @GetMapping("source/all")
    public String sourceAll(ModelMap map) {
       final String url = "http://localhost:8090/source/all";
        String jsonArray = getJsonArray(url);
        List<Model> modelList = JsonConverter.returnList(jsonArray, new Source());
        map.addAttribute("list",modelList);
        return "source";
    }

    @SneakyThrows
    @GetMapping("profileResultView/findAll")
    public String getAllProfileResultView(ModelMap map) {
       final String url = "http://localhost:8090/profileResultView/findAll";
       String jsonArray = getJsonArray(url);
       List<Model> modelList = JsonConverter.returnList(jsonArray, new ProfileResultView());
       map.addAttribute("list", modelList);
       return "profileResultView";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    private static String getJsonArray(String urlAdress) {
       StringBuilder jsonArray = new StringBuilder();
        try {
            URL url = new URL(urlAdress);
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
         //   System.out.println("Response code is: " +responsecode);

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
