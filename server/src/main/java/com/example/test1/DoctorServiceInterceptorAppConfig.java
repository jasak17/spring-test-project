package com.example.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer ;

@Component
public class DoctorServiceInterceptorAppConfig implements WebMvcConfigurer {
    @Autowired
    DoctorServiceInterceptor doctorServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(doctorServiceInterceptor);
    }
}
