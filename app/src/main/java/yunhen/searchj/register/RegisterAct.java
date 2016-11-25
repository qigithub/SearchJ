package yunhen.searchj.register;

import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import yunhen.searchj.R;
import yunhen.searchj.base.BaseActivity;
import yunhen.searchj.utils.ToastUtil;
import yunhen.searchj.utils.ViewUtil;

/**
 * Created by dongqi on 2016/11/25.
 */
public class RegisterAct  extends BaseActivity<IRegister,RegisterPresenter> implements IRegister{

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPwd)
    EditText etPwd;

    @BindView(R.id.etPwd2)
    EditText etPwd2;

    @BindView(R.id.btnSub)
    Button btnSub;

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_register;
    }

    @Override
    public String getNameText() {
        return etUsername.getText().toString() == null ? "": etUsername.getText().toString().trim();
    }

    @Override
    public String getPwdText() {
        return etPwd.getText().toString() == null ? "": etPwd.getText().toString().trim();
    }

    @Override
    public String getPwdText2() {
        return etPwd2.getText().toString() == null ? "": etPwd2.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToast(getApplicationContext(),msg);
    }

    @Override
    public void showProgress() {
        ViewUtil.createLoadingDialog(this,"加载中...",false);
    }

    @Override
    public void hideProgress() {
        ViewUtil.cancelLoadingDialog();
    }
}
