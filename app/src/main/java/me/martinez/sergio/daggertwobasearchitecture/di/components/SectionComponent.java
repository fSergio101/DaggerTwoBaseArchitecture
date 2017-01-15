package me.martinez.sergio.daggertwobasearchitecture.di.components;

import javax.inject.Provider;

import dagger.Provides;
import dagger.Subcomponent;
import me.martinez.sergio.daggertwobasearchitecture.di.anotations.scopes.PerSection;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.TestSectionModule;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.firststep.FirstFragmentComponent;
import me.martinez.sergio.daggertwobasearchitecture.fragments.sections.testsection.secondstep.SecondFragmentComponent;

@PerSection
@Subcomponent(modules = TestSectionModule.class)
public interface SectionComponent {
    Provider<FirstFragmentComponent.Builder> firstFragmentComponentBuilder();
    Provider<SecondFragmentComponent.Builder> secondFragmentComponentBuilder();

    @Subcomponent.Builder
    interface Builder {
        Builder sectionComponent(TestSectionModule module);
        SectionComponent build();
    }
}
