package yunhen.searchj.base;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by dongqi on 2016/8/9.
 */
public interface IBaseVIew {
    Context getContext();
    void showToast(String msg);
    void showProgress(boolean isCancel);
    void hideProgress();
}
