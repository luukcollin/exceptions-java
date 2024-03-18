package org.example.missies;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welkom bij de Karakter Tel Missie");
        Missie missie2 = new KarakterTelMissie();
        missie2.voerUit();

        System.out.println("Welkom bij Exception Quest!");
        Missie missie = new BestandLezenMissie();
        missie.voerUit();
    }
}