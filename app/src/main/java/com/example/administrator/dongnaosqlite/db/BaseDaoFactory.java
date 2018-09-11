package com.example.administrator.dongnaosqlite.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class BaseDaoFactory {
    private String sqliteDatabasePath;

    private SQLiteDatabase sqLiteDatabase;

    private static  BaseDaoFactory instance=new BaseDaoFactory();
    public BaseDaoFactory()
    {
        sqliteDatabasePath= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"teacher.db";
//        sqliteDatabasePath= "/data/data/com.example.administrator.dongnaosqlite/databases/"+"teacher.db";
        openDatabase();
    }
        public  synchronized  <T extends  BaseDao<M>,M> T
        getDao(Class<T> clazz, Class<M> entityClass)
        {
            BaseDao baseDao=null;
            try {
                baseDao=clazz.newInstance();
                baseDao.init(entityClass,sqLiteDatabase);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return (T) baseDao;
        }
    private void openDatabase() {
        this.sqLiteDatabase=SQLiteDatabase.openOrCreateDatabase(sqliteDatabasePath,null);
    }

    public  static  BaseDaoFactory getInstance()
    {
        return instance;
    }
}
