package util;

public class ClearTerminal {

    public void clsTerminal () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
