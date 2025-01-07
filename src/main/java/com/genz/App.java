package com.genz;

import com.genz.model.ModelExample;
import com.genz.service.ServiceExample;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ModelExample model = new ModelExample("Hello from Model!");
        ServiceExample service = new ServiceExample();
        service.printMessage(model);
    }
}
