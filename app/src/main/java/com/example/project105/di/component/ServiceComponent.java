package com.example.project105.di.component;

import com.example.project105.di.module.ServiceModule;
import com.example.project105.di.scope.PerService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
}
