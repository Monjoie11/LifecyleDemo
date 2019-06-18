package com.ebookfrenzy.lifecyledemo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.support.annotation.NonNull;

public class DemoOwner implements LifecycleOwner {

  private LifecycleRegistry lifecycleRegistry;

  public DemoOwner(){
    lifecycleRegistry = new LifecycleRegistry(this);
    getLifecycle().addObserver(new DemoObserver());
  }

  public void startOwner(){
    lifecycleRegistry.handleLifecycleEvent(Event.ON_START);
  }

  public  void stopOwner(){
    lifecycleRegistry.handleLifecycleEvent(Event.ON_STOP);
  }

  @NonNull
  @Override
  public Lifecycle getLifecycle() {
    return lifecycleRegistry;
  }
}
