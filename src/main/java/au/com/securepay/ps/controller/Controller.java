package au.com.securepay.ps.controller;

import au.com.securepay.ps.model.AppRequest;
import au.com.securepay.ps.model.AppResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ankit.Richharia on 5/12/2016.
 */
@RestController
@RequestMapping(value = "/")
public class Controller {


    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.POST)
    public String health(@RequestBody AppRequest appRequest) {
        try {
        /*Class.forName(appRequest.getDbDriver());
        String serverName = appRequest.getServerName();
        String portNumber = appRequest.getPortNumber();
        String sid = appRequest.getSid();
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;*/
        Map<String , String > response = new HashMap<>();
        String driver = null;
        driver =  (appRequest.getAppType().equals("NT")) ?  "com.mysql.jdbc.Driver" :  "net.sourceforge.jtds.jdbc.Driver";
        Class.forName(driver);
        String url = appRequest.getDbUrl();
        String username = appRequest.getUserName();
        String password = appRequest.getPassword();
        Connection conn = DriverManager.getConnection(url, username, password);
            AppResponse appResponse = new AppResponse();
            appResponse.setAppType(appRequest.getAppType());
            appResponse.setDbUrl(appRequest.getDbUrl());
            if (conn!=null) {
                appResponse.setStatus("UP");
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(appResponse) ;
            }else
                appResponse.setStatus("DOWN");
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(appResponse);

        } catch (SQLException e) {
            e.printStackTrace();
            return "ERROR" ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "ERROR";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}

