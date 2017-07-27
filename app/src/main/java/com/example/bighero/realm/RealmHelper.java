package com.example.bighero.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by spf on 2017/7/27.
 */

public final class RealmHelper {

    public static String REALM_NAME = "bighero.realm";

    public static Realm getGlobalRealm(Context context) {
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(REALM_NAME)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm realm = Realm.getInstance(configuration);
        return realm;
    }
}
