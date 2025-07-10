package com.lojaSapatos.enums;

public enum ShoeColor {
    BLACK("Preto"),
    BLUE("Azul"),
    RED("Vermelho"),
    ORANGE("Laranja"),
    PURPLE("Roxo"),
    YELLOW("Amarelo"),
    GREEN("Verde"),
    GOLD("Dourado"),
    BROWN("Marrom"),

    WHITE("Branco"),
    GRAY("Cinza"),
    BEIGE("Bege"),
    PINK("Rosa"),
    SILVER("Prata"),
    BURGUNDY("Bordô"),
    WINE("Vinho"),
    TURQUOISE("Turquesa"),
    LILAC("Lilás"),
    NAVY("Azul Marinho");

    private final String desc;

    ShoeColor(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }
}
