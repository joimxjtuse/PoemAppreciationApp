package cn.example.joim.webtest.bridge;

import android.webkit.JavascriptInterface;

/**
 * Created by joim on 2018/3/3.
 */

public class UserLoginBridge {


    @JavascriptInterface
    public boolean verifyLogin(final String userAccount, final String password) {
        return false;
    }

}
