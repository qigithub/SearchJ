package yunhen.searchj;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

import yunhen.searchj.base.BaseActivity;
import yunhen.searchj.utils.ToastUtil;
import yunhen.searchj.utils.ViewUtil;

public class MainActivity extends BaseActivity<IMain,MainPresenter> implements  IMain{


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToast(getApplicationContext(),msg);
    }

    @Override
    public void showProgress(boolean cancel) {
        ViewUtil.createLoadingDialog(this,"加载中...",cancel);
    }

    @Override
    public void hideProgress() {
        ViewUtil.cancelLoadingDialog();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                exit();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (isWaitingExit) {// 连续按两次返回键
            isWaitingExit = false;
            finish();
        } else {// 按一次返回键
            firstClickBackKey();
        }
    }
    boolean isWaitingExit;
    private void firstClickBackKey() {
        Snackbar.make(getRootView(),"再按退出",Snackbar.LENGTH_SHORT).show();
        isWaitingExit = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isWaitingExit = false;
            }
        }, 2000);
    }

    @Override
    protected String getTitleText() {
        return null;
    }
}
