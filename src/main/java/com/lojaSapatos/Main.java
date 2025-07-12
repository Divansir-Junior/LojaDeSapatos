package com.lojaSapatos;

import com.lojaSapatos.util.LoopManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class, args);
        LoopManager loopManager = context.getBean(LoopManager.class);
        loopManager.run();
    }
}
