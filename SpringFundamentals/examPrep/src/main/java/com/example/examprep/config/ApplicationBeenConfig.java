package com.example.examprep.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeenConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
