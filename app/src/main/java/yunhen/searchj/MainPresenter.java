package yunhen.searchj;

import yunhen.searchj.base.BasePresenter;
import yunhen.searchj.login.ILogin;
import yunhen.searchj.login.LoginPresenter;

/**
 * Created by dongqi on 2016/11/25.
 */
public class MainPresenter extends BasePresenter<IMain> {
    private final String TAG=LoginPresenter.class.getSimpleName();
    protected IMain iView;
    public MainPresenter(IMain iView){
        this.attchView(iView);
        this.iView = getIView();
    }
}
