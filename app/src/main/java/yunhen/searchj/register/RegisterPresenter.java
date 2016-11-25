package yunhen.searchj.register;

import android.text.TextUtils;

import yunhen.searchj.base.BasePresenter;
import yunhen.searchj.login.ILogin;

public class RegisterPresenter extends BasePresenter<IRegister> {
    private final String TAG=RegisterPresenter.class.getSimpleName();
    protected IRegister iView;
    public RegisterPresenter(IRegister iView){
        this.attchView(iView);
        this.iView = getIView();
    }

    public void httpRegister() {

        if (TextUtils.isEmpty(iView.getNameText())) {
            iView.showToast("请输入账号");
            return;
        }
        if (iView.getNameText().length() < 6) {
            iView.showToast("账号需大于6位");
            return;
        }
        if (TextUtils.isEmpty(iView.getPwdText())) {
            iView.showToast("请输入密码");
            return;
        }

        if (iView.getPwdText().length() < 6 ) {
            iView.showToast("密码需大于6位");
            return;
        }

        if (TextUtils.isEmpty(iView.getPwdText2())) {
            iView.showToast("请输入确认密码");
            return;
        }

        if (!iView.getPwdText().equals(iView.getPwdText2())) {
            iView.showToast("2次密码输入不相同");
            return;
        }

//        iView.showProgress(false);





    }
}