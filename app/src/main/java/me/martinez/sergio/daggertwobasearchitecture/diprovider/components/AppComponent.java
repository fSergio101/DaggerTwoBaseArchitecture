package me.martinez.sergio.daggertwobasearchitecture.diprovider.components;

import dagger.Component;
import me.martinez.sergio.daggertwobasearchitecture.di.injectableelements.base.App;
import me.martinez.sergio.daggertwobasearchitecture.diprovider.modules.AppModule;

@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);
}
