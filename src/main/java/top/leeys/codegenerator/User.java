package top.leeys.codegenerator;

import java.util.Date;

public class User extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    private Long loginCount;
    private Date loginTime;
    private String countryCode;
    private String phone;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getLoginCount() {
        return loginCount;
    }
    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }
    public Date getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
