package com.shellcore.android.changeicon;

import android.app.Activity;
import android.app.Application;

import com.shellcore.android.changeicon.libs.di.LibsModule;
import com.shellcore.android.changeicon.ui.main.di.DaggerMainComponent;
import com.shellcore.android.changeicon.ui.main.di.MainComponent;
import com.shellcore.android.changeicon.ui.main.di.MainModule;

/**
 * Created by MOGC on 21/11/2017.
 */

public class ChangeIconApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public MainComponent getMainComponent(Activity activity) {
        return DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .libsModule(new LibsModule(activity))
                .build();
    }
}
