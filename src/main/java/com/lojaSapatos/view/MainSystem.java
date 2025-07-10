package com.lojaSapatos.view;

import org.springframework.stereotype.Component;

@Component
public class MainSystem {

    public void showMainSystem () {
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════╗\n" +
                "║                                        NETSHOE                                             \n" +
                "╠═══════════════════════════════════════════════════════════════════════════════════╣\n" +
                "║   1 - CREATE SHOE                                                                 ║\n" +
                "║   2 - SEARCH SHOE                                                                 ║\n" +
                "║   3 - DELETE SHOE                                                                 ║\n" +
                "║   4 - LIST ALL                                                                    ║\n" +
                "║   5 - FILTER                                                                      ║\n" +
                "║   6 - IMPORT DOC                                                                  ║\n" +
                "║   7 - EXPORT DOC                                                                  ║\n" +
                "║   [ESC] - RETURN                                                                  ║\n" +
                "╚═══════════════════════════════════════════════════════════════════════════════════╝\n");
    }

}
