package org.example.missies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Missie[] missies = new Missie[]{new WoordOmdraaienMissie(), new WoorzoekMissie(), new QuizMissie(), new NullPointerMissie(), new ArithmeticExceptionMissie(),new KarakterTelMissie(),new BestandLezenMissie() };
//        Integer puntenOntmantelaars = voerMissiesUit(missies, false);
        Integer puntenSlopers = voerMissiesUit(missies, false);
//        Integer totaalPunten = puntenSlopers + puntenOntmantelaars;

//        System.out.printf("Punten behaald als ontmantelaars: %d\n", puntenOntmantelaars);
        System.out.printf("Punten behaald als slopers: %d\n", puntenSlopers);
//        System.out.printf("Totaal aantal punten: %d\n", totaalPunten);



//        System.out.println(puntenOntmantelaars);
//        System.out.println("Behaalde puntenOntmantelaarsPunten: " + puntenOntmantelaars);
    }

    static private int voerMissiesUit(Missie[] missies, boolean alsSloper){
        List<Missie> missiesLijst = new ArrayList<>();
        missiesLijst.addAll(Arrays.stream(missies).toList());
        return missiesLijst.stream().map(missie -> missie.voerUit(alsSloper)).reduce(Integer::sum).orElse(0);
    }
}