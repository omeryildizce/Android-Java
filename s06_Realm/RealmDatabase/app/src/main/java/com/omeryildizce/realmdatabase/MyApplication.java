package com.omeryildizce.realmdatabase;


import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate( ) {
        super.onCreate( );
        Realm.init(this); // context, usually an Activity or Application
        String realmName = "My Projectq";
        RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();
        Realm.setDefaultConfiguration(config);

    }


}
