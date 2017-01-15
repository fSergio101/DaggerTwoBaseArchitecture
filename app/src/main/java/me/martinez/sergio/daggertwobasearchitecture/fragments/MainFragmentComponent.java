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

/**
 * Created by Sergio Martinez Rodriguez
 * Date 15/7/15.
 */

import dagger.Subcomponent;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivityModule;
import me.martinez.sergio.daggertwobasearchitecture.di.anotations.scopes.PerFragment;
import me.martinez.sergio.daggertwobasearchitecture.di.modules.FragmentModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragmentModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragmentModule;

@PerFragment
@Subcomponent( modules = {FragmentModule.class, MainFragmentModule.class})
public interface MainFragmentComponent{
    void injectFragment(MainFragment mainFragment);
    @Subcomponent.Builder
    interface Builder {
        Builder mainFragmentComponent(MainFragmentModule mainFragmentModule);
        Builder fragmentModule(FragmentModule fragmentModule);
        MainFragmentComponent build();
    }
}
