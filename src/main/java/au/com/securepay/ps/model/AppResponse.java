package au.com.securepay.ps.model;

/**
 * Created by Ankit.Richharia on 6/12/2016.
 */
public class AppResponse {
    public AppResponse() {
    }

    public AppResponse(String status, String appType, String dbUrl) {
        this.status = status;
        this.appType = appType;
        this.dbUrl = dbUrl;
    }

    public String status;
    public String appType;
    public String dbUrl;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }
}
