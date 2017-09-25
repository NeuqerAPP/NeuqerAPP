package cn.abtion.neuqercc.account.models;

import cn.abtion.neuqercc.base.models.BaseModel;

/**
 * @author abtion.
 * @since 17/9/22 23:59.
 * email caiheng@hrsoft.net
 */


public class LoginRequest extends BaseModel {
    private String identifier;
    private String password;
    private String client;

    public LoginRequest() {

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  String getClient(){
        return client;
    }
    public void setClient(String client){
        this.client=client;
    }


}
