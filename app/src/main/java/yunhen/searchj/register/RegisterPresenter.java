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

}