package com.murillo.alex.resignatorservice.Dependency;

import com.murillo.alex.resignatorservice.Activity.EmailGenerationActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component
public interface ServiceComponent {

    EmailGenerationActivity provideEmailGenerationActivity();
}
