package yunhen.searchj.http;

import android.content.Context;

import com.mrwater.worker.constant.GlobalParams;
import com.mrwater.worker.utils.UserUtil;
import com.mrwater.worker.utils.Utils;

/**
 * Created by dongqi on 2016/8/10.
 */
public class BaseRequest  {


    /**
     * uid : 173
     * token : b7fda1864d890db15ccfd763fd455f5ef0964923
     * ver : 1
     * time : 1477628049
     * sign : 00f79e29f405c0df7813aa23076d5e24
     * device : android
     * request : {"build":40000,"ver":"2.0.3","type":"2"}
     */
    String e = Long.valueOf(System.currentTimeMillis() / 1000L).toString();
//    req.uid = UserUtil.getUserUid(getApplicationContext());
//    req.token = UserUtil.getUserToken(getApplicationContext());
    public String uid="";
    public String token="";
    public String ver = "1";
    public String time=e;
    public String sign= getMd5AndReverse(e);
    public String device = GlobalParams.DEVICE;
    public static String getMd5AndReverse(String key) {
        return reverse(Utils.md5(reverse(key)));
    }
    private static String reverse(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
    public BaseRequest() {

    }

    public BaseRequest(Context ctx) {
        uid=UserUtil.getUserUid(ctx);
        token=UserUtil.getUserToken(ctx);
    }

}
