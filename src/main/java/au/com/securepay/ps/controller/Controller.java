package au.com.securepay.ps.controller;

import au.com.securepay.ps.model.AppDetails;
import org.springframework.boot.json.JacksonJsonParser;
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

    @RequestMapping(method = RequestMethod.POST)
    public String health(@RequestBody AppDetails appDetails) {
        try {
        /*Class.forName(appDetails.getDbDriver());
        String serverName = appDetails.getServerName();
        String portNumber = appDetails.getPortNumber();
        String sid = appDetails.getSid();
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;*/
            Map<String , String > response = new HashMap<>();

        String driver = null;
        driver =  (appDetails.getAppType().equals("NT")) ?  "com.mysql.jdbc.Driver" :  "net.sourceforge.jtds.jdbc.Driver";
        Class.forName(driver);
        String url = appDetails.getDbUrl();
        String username = appDetails.getUserName();
        String password = appDetails.getPassword();
        Connection conn = DriverManager.getConnection(url, username, password);
            if (conn!=null) {
                JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
              //  jacksonJsonParser.parseMap()
                return "UP";
            }else
                return "DOWN";
        } catch (SQLException e) {
            e.printStackTrace();
            return "ERROR";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }
}

