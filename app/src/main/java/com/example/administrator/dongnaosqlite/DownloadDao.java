package com.example.administrator.dongnaosqlite;

import com.example.administrator.dongnaosqlite.db.BaseDao;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class DownloadDao extends BaseDao {
    @Override
    protected String createTable() {
        return "create table if not exists tb_down(tb_time varchar(20),tb_path varchar(10))";

    }
}
