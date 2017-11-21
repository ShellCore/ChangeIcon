package com.shellcore.android.changeicon.ui.main.di;

import com.shellcore.android.changeicon.libs.di.LibsModule;
import com.shellcore.android.changeicon.ui.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by MOGC on 21/11/2017.
 */

@Singleton
@Component(modules = {LibsModule.class, MainModule.class})
public interface MainComponent {

    void inject(MainActivity activity);
}
