package com.example.bighero.app;

import android.app.Application;

import com.example.bighero.realm.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by spf on 2017/7/27.
 */

public class AppApplication extends Application {

    private static Application instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        //初始化Realm数据库
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(RealmHelper.REALM_NAME)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }


    public static Application getContext() {
        return instance;
    }
}
