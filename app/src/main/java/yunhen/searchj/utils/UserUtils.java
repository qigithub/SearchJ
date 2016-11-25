package yunhen.searchj.utils;

import android.content.Context;

/**
 * Created by dongqi on 2016/11/25.
 */
public class UserUtils {
    public static String userId(Context ctx) {
        return SharedPreferencesUtil.getInstance(ctx).getString("uid");
    }
}
