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

package me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import me.martinez.sergio.daggertwobasearchitecture.R;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivity;
import me.martinez.sergio.daggertwobasearchitecture.activities.Section;
import me.martinez.sergio.daggertwobasearchitecture.di.injectableelements.base.App;
import me.martinez.sergio.daggertwobasearchitecture.di.injectableelements.base.BaseFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.presentation.FirstFragmentPresenter;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.presentation.FirstFragmentView;
import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.test.D;
import me.martinez.sergio.daggertwobasearchitecture.test.E;
import me.martinez.sergio.daggertwobasearchitecture.test.NotScopedProperty;
import me.martinez.sergio.daggertwobasearchitecture.test.SectionProperty;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */
public class FirstFragment extends BaseFragment<FirstFragmentComponent> implements
    FirstFragmentView {

    @Inject A a;
    @Inject E e;
    @Inject D d;
    @Inject List<String> diInjectionHistory;
    @Inject FirstFragmentPresenter firstFragmentPresenter;
    @Inject SectionProperty sectionProperty;
    @Inject NotScopedProperty notScopedProperty;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override public void onStart() {
    super.onStart();
    testDI();
  }

  //region Test DI stuff
  private void testDI() {

    diInjectionHistory.add(FirstFragment.class.getName());
    diInjectionHistory.add(firstFragmentPresenter.toString());
    diInjectionHistory.add(notScopedProperty.toString());
    diInjectionHistory.add(sectionProperty.toString());
    diInjectionHistory.add(a.toString());
    diInjectionHistory.add(e.toString());
    diInjectionHistory.add(d.toString());

  }

  @Override protected void initDIComponent() {
    fragmentComponent = ((App) getActivity().getApplication()).getComponentProxy().getFirstFragmentComponent((MainActivity) getActivity(), this);
    fragmentComponent.injectFragment(this);
  }

}
