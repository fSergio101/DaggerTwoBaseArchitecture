package me.martinez.sergio.daggertwobasearchitecture.di;

import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivity;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivityComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.components.AppComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.components.SectionComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.MainFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.MainFragmentComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragmentComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragmentComponent;

/**
 * This interface sits between the dagger component implementations and its usages. This way,
 * a certain injection is not coupled with the component-module hierarchy.
 */
public interface ComponentProxy {
    AppComponent getAppComponent();
    MainActivityComponent getMainActivityComponent(MainActivity mainActivity);
    MainFragmentComponent getMainFragmentComponent(MainActivity activity, MainFragment fragment);
    FirstFragmentComponent getFirstFragmentComponent(MainActivity mainActivity, FirstFragment fragment);
    SecondFragmentComponent getSecondFragmentComponent(MainActivity mainActivity, SecondFragment fragment);
    SectionComponent getSectionComponent(MainActivity mainActivity);
}
