package com.example.codegenmavenpluginpetstoredemo;

import com.example.codegen_maven_plugin_petstore_demo.petstore.api.PetApi;
import com.example.codegen_maven_plugin_petstore_demo.petstore.api.StoreApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean
    @Scope("singleton")
    public PetApi petApi() { return new PetApi(); }

    @Bean
    @Scope("singleton")
    public StoreApi storeApi() { return new StoreApi(); }
}
