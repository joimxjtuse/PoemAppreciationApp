package cn.example.joim.webtest.db;

import android.os.Environment;

/**
 * Created by joim on 2018/3/3.
 */

public final class Constants {

    private Constants() {
    }

    public static final String PACKAGE_NAME = "cn.example.joim.webtest";

    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME + "/databases";

    public static final String POEM_DB = "poem_all.db";


    public static final class POEM {

        public static final String TABLE_NAME = "poem";

        public static final String KEY_TITLE = "mingcheng";

        public static final String KEY_AUTHOR = "zuozhe";

        public static final String KEY_DYNASTY = "chaodai";



    }
}
