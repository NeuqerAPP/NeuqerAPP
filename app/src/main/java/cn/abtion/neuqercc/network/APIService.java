package cn.abtion.neuqercc.network;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * retrofit service interface.
 * @author abtion.
 * @since 17/9/22 18:04.
 * email caiheng@hrsoft.net
 */

public interface APIService {
    /**
     * 登录
     */
    @POST("user/register")
    Call<APIResponse> login(@Body cn.abtion.neuqercc.newAccount.models.LoginRequest loginRequest);
}
