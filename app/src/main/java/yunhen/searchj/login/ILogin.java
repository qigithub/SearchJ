package yunhen.searchj.login;

import yunhen.searchj.base.IBaseVIew;

public interface ILogin extends IBaseVIew {

    String getUsernameText();

    String getPwdText();

    void setUsernameErrorText(String s);

    void setPwdErrorText(String s);

    void goActRegister();

}