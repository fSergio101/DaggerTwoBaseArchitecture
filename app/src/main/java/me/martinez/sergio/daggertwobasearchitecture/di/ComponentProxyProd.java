package me.martinez.sergio.daggertwobasearchitecture.di;

import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivity;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivityComponent;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivityComponentProd;
import me.martinez.sergio.daggertwobasearchitecture.activities.MainActivityModule;
import me.martinez.sergio.daggertwobasearchitecture.di.components.AppComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.components.AppComponentProd;
import me.martinez.sergio.daggertwobasearchitecture.di.components.DaggerAppComponentProd;
import me.martinez.sergio.daggertwobasearchitecture.di.components.SectionComponent;
import me.martinez.sergio.daggertwobasearchitecture.di.modules.ActivityModule;
import me.martinez.sergio.daggertwobasearchitecture.di.modules.FragmentModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.MainFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.MainFragmentComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.MainFragmentModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.TestSectionModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragmentComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragmentModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragment;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragmentComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragmentModule;

public class ComponentProxyProd implements ComponentProxy {
    private static ComponentProxy ourInstance = new ComponentProxyProd();

    public static ComponentProxy getInstance() {
        return ourInstance;
    }

    private AppComponentProd appComponent;

    private ComponentProxyProd() {
        appComponent = DaggerAppComponentProd.create();
    }

    @Override
    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public MainActivityComponent getMainActivityComponent(MainActivity mainActivity) {
        return appComponent.mainActivityComponentProdBuilderProvider().get()
                .mainActivityComponentProd(new MainActivityModule(mainActivity))
                .activityModule(new ActivityModule(mainActivity))
                .build();
    }

    @Override
    public MainFragmentComponent getMainFragmentComponent(MainActivity activity, MainFragment fragment) {
        MainActivityComponentProd component = (MainActivityComponentProd) activity.getActivityComponent();
        return component.mainFragmentComponentBuilderProvider().get()
                .mainFragmentComponent(new MainFragmentModule(fragment))
                .fragmentModule(new FragmentModule(fragment))
                .build();
    }

    @Override
    public FirstFragmentComponent getFirstFragmentComponent(MainActivity activity, FirstFragment fragment) {
        SectionComponent sectionComponent = activity.getSectionComponent();
        return sectionComponent.firstFragmentComponentBuilder().get()
                .firstFragmentComponent(new FirstFragmentModule(fragment))
                .fragmentModule(new FragmentModule(fragment))
                .build();
    }

    @Override
    public SecondFragmentComponent getSecondFragmentComponent(MainActivity activity, SecondFragment fragment) {
        SectionComponent sectionComponent = activity.getSectionComponent();
        return sectionComponent.secondFragmentComponentBuilder().get()
                .secondFragmentComponent(new SecondFragmentModule(fragment))
                .fragmentModule(new FragmentModule(fragment))
                .build();
    }

    @Override
    public SectionComponent getSectionComponent(MainActivity activity) {
        MainActivityComponentProd component = (MainActivityComponentProd) activity.getActivityComponent();
        return component.sectionComponentProdBuilderProvider().get()
                .sectionComponent(new TestSectionModule())
                .build();
    }
}
