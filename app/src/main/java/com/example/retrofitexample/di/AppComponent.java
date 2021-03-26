package com.example.retrofitexample.di;

import android.app.Application;

import com.example.retrofitexample.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, //this is standard in all dagger android applications
        ActivityBuilderModule.class, //this is standard in all dagger android applications
        RepoModule.class})
public interface AppComponent extends AndroidInjector<App> {

    /**
     * Build this object using a custom builder.
     */
    @Component.Builder
    interface Builder {
        // Pass my app ... it will be available to the modules
        @BindsInstance
        Builder application(Application application);

        // Override the regular builder
        AppComponent build();
    }
}
