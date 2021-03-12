package com.example.codegenmavenpluginpetstoredemo;

import com.example.codegen_maven_plugin_petstore_demo.petstore.api.PetApi;
import com.example.codegen_maven_plugin_petstore_demo.petstore.api.StoreApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class UseClient {

    @Autowired
    private PetApi clientPetApi;

    @Autowired
    private StoreApi clientStoreApi;

    @RequestMapping(value="/pets/available", method = RequestMethod.GET)
    public String findAvailablePets() {
        StringBuilder sb = new StringBuilder("<h1>Available pets:</h1>");
        sb.append("<ul>");
        clientPetApi.findPetsByStatus(Arrays.asList("available")).forEach(p -> sb.append("<li>" + p.getName() + "</li>"));
        sb.append("</ul>");
        return sb.toString();
    }

    @RequestMapping(value="/pets/pending", method = RequestMethod.GET)
    public String findPendingPets() {
        StringBuilder sb = new StringBuilder("<h1>Pending pets:</h1>");
        sb.append("<ul>");
        clientPetApi.findPetsByStatus(Arrays.asList("pending")).forEach(p -> sb.append("<li>" + p.getName() + "</li>"));
        sb.append("</ul>");
        return sb.toString();
    }

    @RequestMapping(value="/store/inventory", method = RequestMethod.GET)
    public String getStoreInventory() {
        StringBuilder sb = new StringBuilder("<h1>Inventory:</h1>");
        sb.append("<ul>");
        clientStoreApi.getInventory().forEach((key, value) -> System.out.println(key + ": " + value));
        sb.append("<ul>");
        return sb.toString();
    }
}
