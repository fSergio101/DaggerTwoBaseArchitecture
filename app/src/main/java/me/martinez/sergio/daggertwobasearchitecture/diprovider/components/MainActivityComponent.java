package me.martinez.sergio.daggertwobasearchitecture.diprovider.components;

import dagger.Component;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivity;
import me.martinez.sergio.daggertwobasearchitecture.diprovider.PerActivity;
import me.martinez.sergio.daggertwobasearchitecture.diprovider.modules.MainActivityModule;

@PerActivity @Component(modules = MainActivityModule.class, dependencies = AppComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity activity);
}
