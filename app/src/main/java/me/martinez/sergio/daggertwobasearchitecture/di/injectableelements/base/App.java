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
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import me.martinez.sergio.daggertwobasearchitecture.di.components.AppComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.components.DaggerAppComponent;
import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4Me;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */
public class App extends Application {

  @Inject A a;
  @Inject Log4Me logger;
  @Inject List<String> diContainer;

  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    initDI();
    testDI();

  }

  private void initDI() {
    appComponent = DaggerAppComponent.create();

    /** DaggerAppComponent.create() is equivalent to :
     * DaggerAppComponent.builder().appModule(new AppModule()).build()
     * when module has not arguments
     **/

    appComponent.inject(this);
  }

  private void testDI() {

    diContainer.add(App.class.getName());

    if (logger != null ){
      diContainer.add(logger.toString());
    }

    if (a!=null){
      logger.log("Dependency Injection is working");
      diContainer.add(a.toString());

    }
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
