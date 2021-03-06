package yunhen.searchj.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;

import java.io.File;

import butterknife.internal.Utils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yunhen.searchj.base.BaseActivity;
import yunhen.searchj.base.BasePresenter;
import yunhen.searchj.register.RegisterAct;

public class LoginPresenter extends BasePresenter<ILogin> {
    private final String TAG=LoginPresenter.class.getSimpleName();
    protected ILogin iView;
    public LoginPresenter(ILogin iView){
        this.attchView(iView);
        this.iView = getIView();
    }

    public void toRegisterAct(){
        BaseActivity.launchAct(iView.getContext(), RegisterAct.class);
    }


    public void startLogin() {
        if (TextUtils.isEmpty(iView.getUsernameText())) {
            iView.setUsernameErrorText("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(iView.getPwdText())) {
            iView.setPwdErrorText("请输入密码");
            return;
        }

    }

}