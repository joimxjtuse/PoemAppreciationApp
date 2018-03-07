package cn.example.joim.webtest;

import android.app.Application;
/**
 * Created by joim on 2018/3/3.
 */

public class PoemApplication extends Application {

    private static PoemApplication sInstance;

    public static PoemApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;


    }


}
