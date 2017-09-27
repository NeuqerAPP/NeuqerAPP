package cn.abtion.neuqercc.common;

/**
 * all of the configuration for this application
 * @author abtion.
 * @since 17/9/22 17:52.
 * email caiheng@hrsoft.net
 */

public class Config {
    /**
     * 验证手机号正则
     */
    public static final String MOBILE_REGEX = "[1][3,4,5,7,8][0-9]{9}$";

    /**
     * 验证邮箱正则
     */
    public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    /**
     * APP Server 网络请求BaseUrl
     */
    public static final String APP_SERVER_BASE_URL = "http://oj.marklux.cn/";

    /**
     * APP Server 网络请求连接超时时间，单位：s
     */
    public static final int APP_SERVER_CONNECT_TIME_OUT = 15;

    /**
     * 启动页面到首页启动延时，单位：毫秒
     */
    public static final int SPLASH_GO_MAIN_DELAY = 1500;
}
