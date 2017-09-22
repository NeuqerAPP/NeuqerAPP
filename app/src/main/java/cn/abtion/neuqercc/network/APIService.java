package cn.abtion.neuqercc.network;

import cn.abtion.neuqercc.account.models.LoginRequest;
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
    @POST("user/login")
    Call<APIResponse> login(@Body LoginRequest loginRequest);
}
