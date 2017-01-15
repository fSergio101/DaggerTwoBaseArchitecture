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

package me.martinez.sergio.daggertwobasearchitecture.activities;

import javax.inject.Provider;

import dagger.Subcomponent;
import me.martinez.sergio.daggertwobasearchitecture.di.components.SectionComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.modules.ActivityModule;
import me.martinez.sergio.daggertwobasearchitecture.di.anotations.scopes.PerActivity;
import me.martinez.sergio.daggertwobasearchitecture.fragments.MainFragmentComponent;

@PerActivity
@Subcomponent(modules = {ActivityModule.class, MainActivityModule.class})
public interface MainActivityComponentProd extends MainActivityComponent {
    Provider<MainFragmentComponent.Builder> mainFragmentComponentBuilderProvider();
    Provider<SectionComponent.Builder> sectionComponentProdBuilderProvider();
    @Subcomponent.Builder
    interface Builder {
        Builder mainActivityComponentProd(MainActivityModule mainActivityModule);
        Builder activityModule(ActivityModule activityModule);
        MainActivityComponentProd build();
    }
}
