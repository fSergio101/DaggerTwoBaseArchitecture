/*
 *  Copyright (C) 2015 Sergio Martinez Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package me.martinez.sergio.daggertwobasearchitecture.di.injectableelements.base;

import android.app.Application;

import javax.inject.Inject;

import me.martinez.sergio.daggertwobasearchitecture.diprovider.components.AppComponent;
import me.martinez.sergio.daggertwobasearchitecture.diprovider.components.DaggerAppComponent;
import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4Me;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */
public class App extends Application {

    @Inject A a;
    @Inject Log4Me logger;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDI();
        testDI();
    }

    private void initDI() {
        appComponent = DaggerAppComponent
                .create();
        appComponent.inject(this);
    }

    private void testDI() {
        logger.log("Hola Dagger 2, tengo una implementación de A: " + a);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
