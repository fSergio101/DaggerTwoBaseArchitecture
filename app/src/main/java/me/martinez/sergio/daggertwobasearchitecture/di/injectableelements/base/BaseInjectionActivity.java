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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import me.martinez.sergio.daggertwobasearchitecture.di.components.AppComponent;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */
public abstract class BaseInjectionActivity<T> extends AppCompatActivity{

  protected T activityComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDI();
  }

  protected abstract void initDI();

  public AppComponent getAppComponent() {
    AppComponent appComponent = ((App) getApplication()).getAppComponent();
    return appComponent;
  }

  public Object getActivityComponent() {
      return activityComponent;
  }

}
