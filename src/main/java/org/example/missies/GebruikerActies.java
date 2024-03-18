package org.example.missies;

import java.util.Scanner;

interface GebruikerActies {
    static void toonBericht(String bericht, boolean sloper) {
        String optieA = "Jij bent de sloper! Probeer de code de volgende error te laten creeeren: ";
        String optieB = "Jij bent de ontmantelaar! Probeer de missie op te lossen: ";
        String message = sloper ? optieA : optieB;
        toonBericht(message);
        toonBericht(bericht);
    }

    static void toonBericht(String bericht) {
        System.out.println(bericht);
    }

    static String leesInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
