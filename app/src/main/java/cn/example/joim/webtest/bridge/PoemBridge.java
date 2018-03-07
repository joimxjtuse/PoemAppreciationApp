package cn.example.joim.webtest.bridge;

import android.content.Context;
import android.webkit.JavascriptInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.example.joim.webtest.db.PoemDao;
import cn.example.joim.webtest.db.dao.PoemDaoImpl;
import cn.example.joim.webtest.model.Poem;

/**
 * Created by joim on 2018/3/3.
 */

public class PoemBridge {

    private PoemDao mPoemDao;

    public PoemBridge(Context context) {
        this.mPoemDao = new PoemDaoImpl(context.getApplicationContext());
    }

    @JavascriptInterface
    public List<Poem> selectAllPoem() {

        return mPoemDao.findAllPoem();
    }


}
