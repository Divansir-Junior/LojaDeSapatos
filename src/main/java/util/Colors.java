package util;

public class Colors {

    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static  final String WHITE = "\t\\u001B[37m";


    public static String getColor(String nome) {
        return switch (nome.toLowerCase()) {
            case "red" -> RED;
            case "green" -> GREEN;
            case "yellow" -> YELLOW;
            case "blue" -> BLUE;
            case "cyan" -> CYAN;
            case "white" -> WHITE;
            default -> RESET;
        };
    }


}
