package me.martinez.sergio.daggertwobasearchitecture.diprovider.modules;

import dagger.Module;
import dagger.Provides;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4Me;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4MeImpl;

@Module()
public class AppModule {

    @Provides
    Log4Me provLog4Me(Log4MeImpl log4Me) {
        return log4Me;
    }
}
