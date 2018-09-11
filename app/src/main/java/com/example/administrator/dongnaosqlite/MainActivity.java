package com.example.administrator.dongnaosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.dongnaosqlite.db.BaseDao;
import com.example.administrator.dongnaosqlite.db.BaseDaoFactory;
import com.example.administrator.dongnaosqlite.db.IBaseDao;

public class MainActivity extends com.lythonliu.LinkAppCompatActivity {

    @Override
    public String getAppName(){
        return BuildConfig.APP_NAME;
    }

    IBaseDao<User> baseDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseDao= BaseDaoFactory.getInstance().getDao(UserDao.class,User.class);
    }
    public void save(View view)
    {
        User user=new User("teacher","123456");
        baseDao.insert(user);

        BaseDao<DownLoadFile> downloadDao=BaseDaoFactory.getInstance().getDao(DownloadDao.class,DownLoadFile.class);
        downloadDao.insert(new DownLoadFile("2013.1.9","data/data/apth"));
    }
}
