package yunhen.searchj.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import butterknife.BindView;
import yunhen.searchj.R;
import yunhen.searchj.base.BaseActivity;
import yunhen.searchj.register.RegisterAct;
import yunhen.searchj.utils.ToastUtil;
import yunhen.searchj.utils.ViewUtil;

/**
 * Created by dongqi on 2016/11/25.
 */
public class LoginAct extends BaseActivity<ILogin,LoginPresenter> implements ILogin {

    @BindView(R.id.etUsername)
    EditText etUsername;



    @BindView(R.id.etPwd)
    EditText etPwd;



    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    protected void onCreate_(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public String getUsernameText() {
        return etUsername.getText().toString() == null ? "":etUsername.getText().toString().trim();
    }

    @Override
    public String getPwdText() {
        return etPwd.getText().toString() == null ? "": etPwd.getText().toString().trim();
    }

    @Override
    public void showProgress() {
        ViewUtil.createLoadingDialog(this,"加载中...",false);
    }

    @Override
    public void hideProgress() {
        ViewUtil.cancelLoadingDialog();
    }

    @Override
    public void setUsernameErrorText(String s) {
        etUsername.setError(s);
    }

    @Override
    public void setPwdErrorText(String s) {
        etPwd.setError(s);
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToast(getApplicationContext(),msg);
    }

    @Override
    public void goActRegister() {
        BaseActivity.launchAct(this,RegisterAct.class);
    }
}
