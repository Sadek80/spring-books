package com.sadek.jpa.test;

import com.sadek.jpa.test.core.helpers.SecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAware")
public class AppConfiguration {

    @Bean
    public AuditorAware<String> getAuditorAware(){
        return new SecurityAuditorAware();
    }
}
