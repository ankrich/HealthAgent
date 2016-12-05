package au.com.securepay.ps.model;

import java.io.Serializable;

/**
 * Created by Ankit.Richharia on 5/12/2016.
 */

public class AppDetails implements Serializable {


    public String appType;
    public String dbUrl;
    public String userName;
    public String password;

    public AppDetails() {
    }

    public AppDetails(String appType, String dbUrl, String userName, String password) {
        this.appType = appType;
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.password = password;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }
}
