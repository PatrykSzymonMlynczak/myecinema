package com.wikingowie.myecinema.config;

import com.wikingowie.myecinema.services.impl.GenerateDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitializeDateConfig implements CommandLineRunner {

    private final GenerateDataService generateDataService;

    @Override
    public void run(String... args){
        generateDataService.generate();
    }
}
