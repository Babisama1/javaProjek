package com.genz.service;

import com.genz.model.ModelExample;

public class ServiceExample {
    public void printMessage(ModelExample model) {
        System.out.println("Pesan dari model: " + model.getMessage());
    }
}