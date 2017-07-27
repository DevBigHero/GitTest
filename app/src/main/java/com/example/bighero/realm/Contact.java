package com.example.bighero.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Contact extends RealmObject {
    public String name;
    public RealmList<Email> emails;

    public class Email extends RealmObject {
        public String address;
        public boolean active;
    }
}

