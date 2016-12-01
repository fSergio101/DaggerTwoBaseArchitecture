package me.martinez.sergio.daggertwobasearchitecture.diprovider.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4Me;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4MeImpl;

@Module()
public class AppModule {

    @Provides
    @Singleton
    Log4Me provLog4Me(Log4MeImpl log4Me) {
        return log4Me;
    }

    @Provides
    @Singleton
    A provideA() {
        return new A();
    }
}
