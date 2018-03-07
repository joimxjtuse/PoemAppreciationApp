package cn.example.joim.webtest.db;

import java.util.List;

import cn.example.joim.webtest.model.Poem;

/**
 * Created by joim on 2018/3/3.
 */

public interface PoemDao {

    public List<Poem> findAllPoem();
}
