package me.martinez.sergio.daggertwobasearchitecture.diprovider.components;

import javax.inject.Singleton;

import dagger.Component;
import me.martinez.sergio.daggertwobasearchitecture.di.injectableelements.base.App;
import me.martinez.sergio.daggertwobasearchitecture.diprovider.modules.AppModule;
import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4Me;

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    Log4Me provideLog4Me();

    A provideA();
}
