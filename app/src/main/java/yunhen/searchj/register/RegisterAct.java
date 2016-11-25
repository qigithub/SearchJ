package yunhen.searchj.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
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
public class RegisterAct extends BaseActivity<IRegister,RegisterPresenter> implements IRegister{

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
    protected void onCreate_(@Nullable Bundle savedInstanceState) {
        super.onCreate_(savedInstanceState);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.httpRegister();
            }
        });
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
    public void showProgress(boolean isCancel) {
        ViewUtil.createLoadingDialog(this,"加载中...",isCancel);
    }

    @Override
    public void hideProgress() {
        ViewUtil.cancelLoadingDialog();
    }

    @Override
    protected String getTitleText() {
        return "注册";
    }
}
