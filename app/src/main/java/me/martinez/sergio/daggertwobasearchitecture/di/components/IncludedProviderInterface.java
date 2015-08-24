package me.martinez.sergio.daggertwobasearchitecture.di.components;

import me.martinez.sergio.daggertwobasearchitecture.test.A;
import me.martinez.sergio.daggertwobasearchitecture.utils.Log4Me;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 25/8/15.
 */
public interface IncludedProviderInterface {
  A provideA();
  Log4Me provideLog4Me();
}
