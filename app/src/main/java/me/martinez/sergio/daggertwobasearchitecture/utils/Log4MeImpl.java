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

package me.martinez.sergio.daggertwobasearchitecture.utils;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/8/15.
 */
public class Log4MeImpl implements Log4Me {

  private int defaultLoglevel;
  private static final String LOGS_PREFIX = "DI TESTS :: ";

  @Inject
  public Log4MeImpl() {
    defaultLoglevel = Log.DEBUG;
  }

  @Override public void log(String message, int logLevel, Object clazz) {
    if (logLevel == Log.DEBUG){
      Log.d(clazz.getClass().getName(), LOGS_PREFIX + message);
    }
  }

  @Override public void log(String message, int logLevel) {
    log(message, defaultLoglevel, Log4MeImpl.class.getName()) ;
  }

  @Override public void log(String message) {
    log(message, defaultLoglevel);
  }
}
