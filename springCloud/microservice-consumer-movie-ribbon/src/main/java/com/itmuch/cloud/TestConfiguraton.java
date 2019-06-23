package com.itmuch.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguraton {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
