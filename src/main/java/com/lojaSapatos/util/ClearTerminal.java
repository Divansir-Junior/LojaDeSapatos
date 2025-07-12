package com.lojaSapatos.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClearTerminal {

    public void clsTerminal () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
