package cn.abtion.neuqercc.account.models;

import cn.abtion.neuqercc.base.models.BaseModel;

/**
 * @author abtion.
 * @since 17/9/22 23:59.
 * email caiheng@hrsoft.net
 */


public class LoginRequest extends BaseModel {

    private String registeName;
    private String registePassword;
    private String passwordConfirm;
    private String registeMail;
    private String registePhone;
    private String registeSchool;
    private String registeCaptch;

    public String getRegisteName() {
        return registeName;
    }

    public void setRegisteName(String registeName) {
        this.registeName = registeName;
    }

    public String getRegistePassword() {
        return registePassword;
    }

    public void setRegistePassword(String registePassword) {
        this.registePassword = registePassword;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getRegisteMail() {
        return registeMail;
    }

    public void setRegisteMail(String registeMail) {
        this.registeMail = registeMail;
    }

    public String getRegistePhone(String trim) {
        return registePhone;
    }

    public void setRegistePhone(String registePhone) {
        this.registePhone = registePhone;
    }

    public String getRegisteSchool(String trim) {
        return registeSchool;
    }

    public void setRegisteSchool(String registeSchool) {
        this.registeSchool = registeSchool;
    }

    public String getRegisteCaptch(String trim) {
        return registeCaptch;
    }

    public void setRegisteCaptch(String registeCaptch) {
        this.registeCaptch = registeCaptch;
    }

    public LoginRequest() {


    }


}
