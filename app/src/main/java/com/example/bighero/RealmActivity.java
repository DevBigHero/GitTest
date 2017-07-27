package com.example.bighero;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.bighero.realm.Dog;
import com.example.bighero.realm.RealmHelper;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by spf on 2017/7/27.
 */

public class RealmActivity extends Activity {
    RealmAsyncTask asyncTask;
    RealmResults<Dog> realms;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm realm = RealmHelper.getGlobalRealm(this);
        realm.beginTransaction();
        Dog dog = realm.createObject(Dog.class);
        dog.setAge(15);
        dog.setName("bighero");
        realm.commitTransaction();
        realm.close();


        Dog dog2 = new Dog();
        dog2.setName("small");
        dog2.setAge(16);

        Realm realm2 = RealmHelper.getGlobalRealm(this);
        realm2.beginTransaction();
        realm2.copyFromRealm(dog2);
        realm2.commitTransaction();
        realm2.close();

        final Dog dog3 = new Dog();
        dog3.setName("big2");
        dog3.setAge(16);
        Realm realm3 = RealmHelper.getGlobalRealm(this);
        realm3.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyFromRealm(dog3);
            }
        });

        Realm realm4 = Realm.getDefaultInstance();
        final RealmResults<Dog> dogs = realm4.where(Dog.class).findAll();
        realm4.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog = dogs.get(1);
                dog.deleteFromRealm();

                dogs.deleteAllFromRealm();
                dogs.deleteFirstFromRealm();
                dogs.deleteLastFromRealm();
                dogs.deleteFromRealm(1);
            }
        });

        List<Dog> dogList = getRealmDog();


        final Dog dog4 = new Dog();
        dog4.setName("big2");
        dog4.setAge(16);
        Realm realm5 = Realm.getDefaultInstance();
        asyncTask = realm5.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyFromRealm(dog4);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                //成功后的操作
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                //失败后的操作
            }
        });
        final Realm realm6 = Realm.getDefaultInstance();
        realms = realm6.where(Dog.class).findAllAsync();
        realms.addChangeListener(new RealmChangeListener<RealmResults<Dog>>() {
            @Override
            public void onChange(RealmResults<Dog> element) {
                element = element.sort("id");
                List<Dog> dogs = realm6.copyFromRealm(element);
                realms.removeChangeListener(this);
            }
        });


    }

    public List<Dog> getRealmDog() {
        Realm realm5 = Realm.getDefaultInstance();
        RealmResults<Dog> dogs2 = realm5.where(Dog.class).findAll();
        return realm5.copyFromRealm(dogs2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
