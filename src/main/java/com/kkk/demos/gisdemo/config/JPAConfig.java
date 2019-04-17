package com.kkk.demos.gisdemo.config;

import com.kkk.demos.gisdemo.GisDemoApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Configuration
@EntityScan(
    basePackageClasses = {GisDemoApplication.class, Jsr310JpaConverters.class}
)
public class JPAConfig {

}
