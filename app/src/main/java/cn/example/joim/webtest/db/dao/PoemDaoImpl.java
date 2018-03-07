package cn.example.joim.webtest.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.example.joim.webtest.PoemApplication;
import cn.example.joim.webtest.R;
import cn.example.joim.webtest.db.Constants;
import cn.example.joim.webtest.db.PoemDao;
import cn.example.joim.webtest.model.Poem;

/**
 * Created by joim on 2018/3/3.
 */

public class PoemDaoImpl implements PoemDao {

    private Context mContext;

    public PoemDaoImpl(Context context) {

        this.mContext = context.getApplicationContext();
    }

    private String initDbIfNecessary() throws Exception {

        File path = new File(Constants.DB_PATH);
        if (!path.exists()) {
            path.mkdirs();
        }
        String dbfile = path + "/" + Constants.POEM_DB;

        if (!(new File(dbfile).exists())) {
            InputStream is;
            is = this.mContext.getResources().openRawResource(R.raw.poem_all);
            FileOutputStream fos = new FileOutputStream(dbfile);
            byte[] buffer = new byte[2048];
            int count = 0;
            while ((count = is.read(buffer)) > 0) {
                fos.write(buffer, 0, count);
            }
            fos.close();
            is.close();
        }
        return dbfile;
    }

    private SQLiteDatabase openPoemDatabase() {
        try {
            String fileDIr = initDbIfNecessary();
            return SQLiteDatabase.openOrCreateDatabase(fileDIr, null);
        } catch (Exception exce) {
            exce.printStackTrace();
        }
        return null;
    }

    private String readStringValue(@NonNull Cursor cursor, @NonNull String keyName) {
        return cursor.getString(cursor.getColumnIndex(keyName));
    }

    @Override
    public List<Poem> findAllPoem() {

        List<Poem> result = null;

        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        try {

            sqLiteDatabase = openPoemDatabase();

            //sqLiteDatabase = mHelper.getReadableDatabase();
            sqLiteDatabase.beginTransaction();

            cursor = sqLiteDatabase.query(Constants.POEM.TABLE_NAME, null, "", null, null,
                    null, null);
            sqLiteDatabase.setTransactionSuccessful();
            result = new ArrayList<>();

            Poem poem = null;
            while (cursor.moveToNext()) {

                poem = new Poem();
                poem.setmAuthor(readStringValue(cursor, Constants.POEM.KEY_AUTHOR));
                poem.setmTitle(readStringValue(cursor, Constants.POEM.KEY_TITLE));
                //poem.setmBrief(readStringValue(cursor, PoemDBHelper.KEY_SHORT_BRIEF));
                //poem.setmContent(readStringValue(cursor, PoemDBHelper.KEY_CONTENT));
                poem.setmDynasty(readStringValue(cursor, Constants.POEM.KEY_DYNASTY));
                //poem.setmEvaluate(readStringValue(cursor, PoemDBHelper.KEY_EVALUATE));
                //poem.setmAnnotation(readStringValue(cursor, PoemDBHelper.KEY_ANNOTATION));
                //poem.setmTranslation(readStringValue(cursor, PoemDBHelper.KEY_TRANSLATION));
                //poem.setmAppreciateAnalyze(readStringValue(cursor, PoemDBHelper.KEY_APPRECIATE_ANALYZE));
                //poem.setmClassify(readStringValue(cursor, PoemDBHelper.KEY_CLASSIFY));
                //poem.setmExcerpt(readStringValue(cursor, PoemDBHelper.KEY_EXCERPT));

                result.add(poem);
            }
        } catch (Exception exce) {
            exce.printStackTrace();
        } finally {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.endTransaction();
                sqLiteDatabase.close();
            }
        }
        if (result == null) {
            result = Collections.emptyList();
        }
        return result;
    }

    public boolean insertPoem(Poem poem) {
        boolean inserted = false;
        if (poem != null) {

        }
        return inserted;
    }
}
