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

package me.martinez.sergio.daggertwobasearchitecture.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import javax.inject.Inject;
import me.martinez.sergio.daggertwobasearchitecture.R;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivityComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.injectableelements.base.BaseFragment;
import me.martinez.sergio.daggertwobasearchitecture.di.modules.FragmentModule;
import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.test.B;
import me.martinez.sergio.daggertwobasearchitecture.test.C;
import me.martinez.sergio.daggertwobasearchitecture.test.D;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */
public class MainFragment extends BaseFragment<MainFragmentComponent> {

  @Inject B b;
  @Inject A a;
  @Inject C c;
  @Inject List<String> diInjectioHistoric;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override public void onStart() {
    super.onStart();
    testDI();
  }

  private void testDI() {
    diInjectioHistoric.add(MainFragment.class.getName());
    diInjectioHistoric.add(b.toString());
    diInjectioHistoric.add(a.toString());
    diInjectioHistoric.add(c.toString());
  }

  //region dependency injection Methods
  @Override protected void initDIComponent() {
    fragmentComponent = (getParentComponent(MainActivityComponent.class)).plus(
        new FragmentModule(this), new MainFragmentModule(this));
    fragmentComponent.injectFragment(this);
  }

  public interface Pluser{
    MainFragmentComponent plus(FragmentModule secondFragmentModule, MainFragmentModule baseFragmentModule);
  }
  //endregion
}
