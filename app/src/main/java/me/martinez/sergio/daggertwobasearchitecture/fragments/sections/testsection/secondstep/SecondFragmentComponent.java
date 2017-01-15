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

package me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep;

import dagger.Subcomponent;
import me.martinez.sergio.daggertwobasearchitecture.di.anotations.scopes.PerFragment;
import me.martinez.sergio.daggertwobasearchitecture.di.modules.FragmentModule;

@PerFragment
@Subcomponent( modules = {FragmentModule.class, SecondFragmentModule.class})
public interface SecondFragmentComponent {
    void injectFragment(SecondFragment secondFragment);
    @Subcomponent.Builder
    interface Builder {
        Builder secondFragmentComponent(SecondFragmentModule secondFragmentModule);
        Builder fragmentModule(FragmentModule fragmentModule);
        SecondFragmentComponent build();
    }
}
