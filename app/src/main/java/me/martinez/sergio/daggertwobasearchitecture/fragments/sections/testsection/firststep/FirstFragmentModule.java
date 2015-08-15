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

import dagger.Module;
import dagger.Provides;
import me.martinez.sergio.daggertwobasearchitecture.di.anotations.scopes.PerFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.presentation.FirstFragmentPresenter;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.presentation.FirstFragmentView;
import me.martinez.sergio.daggertwobasearchitecture.test.D;
import me.martinez.sergio.daggertwobasearchitecture.test.E;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */
@Module()
public class FirstFragmentModule{

  private FirstFragmentView firstFragmentView;

  public FirstFragmentModule(FirstFragmentView firstFragmentView) {
    this.firstFragmentView = firstFragmentView;
  }

  @PerFragment @Provides FirstFragmentPresenter provideFirstFragmentPresenter(D d){
    return new FirstFragmentPresenter(firstFragmentView, d);
  }

  @PerFragment @Provides E provideE(){
    return new E();
  }

}
