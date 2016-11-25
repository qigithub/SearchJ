package yunhen.searchj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import yunhen.searchj.base.BaseActivity;
import yunhen.searchj.login.LoginAct;
import yunhen.searchj.utils.UserUtils;

/**
 * Created by dongqi on 2016/11/25.
 */
public class LauncherAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.timer(1000, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                if (UserUtils.userId(getApplicationContext()) == null || "".equals(UserUtils.userId(getApplicationContext()))) {
                    BaseActivity.launchAct(LauncherAct.this, MainActivity.class);
                } else {
                    BaseActivity.launchAct(LauncherAct.this, LoginAct.class);
                }
                finish();
            }
        });
    }
}
