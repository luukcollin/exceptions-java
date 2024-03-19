package org.example.missies;

import java.util.Random;

public class WoorzoekMissie extends Missie {
    Random rnd = new Random();
    static private int LENGTE_VAN_TROEP = 1_000;
    String troepStr = "bcdfghjklmnpqrsvwxyz";
    char[] troep = populateChars(troepStr);

    private void genereerWoordZoeker() throws WoordzoekException {
        String[] woorden = new String[]{"paraplu", "parkiet", "bezemwagen", "bananenpuree", "appelstroop"};
        String gekozenWoord = woorden[rnd.nextInt(0, woorden.length - 1)];
        String result = "";

        int magicRandomNumber = rnd.nextInt(0, LENGTE_VAN_TROEP);
        for (int i = 0; i < LENGTE_VAN_TROEP; i++) {
            result += troep[i % troep.length];
            if (i == magicRandomNumber) {
                result += gekozenWoord;
            }
        }
        System.out.println(result);
        System.out.println("Geef het verborgen woord op");
        String geradenWoord = GebruikerActies.leesInput();
        boolean geraden = gekozenWoord.equals(geradenWoord);
        setPunten(geraden);

        if (!geraden) throw new WoordzoekException();
    }

    private char[] populateChars(String str) {
        return str.toCharArray();
    }

    @Override
    int voerUit(boolean sloper) {
        try {
            genereerWoordZoeker();
        } catch (WoordzoekException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            behaaldePunten = DEVELOPER_STRAFPUNTEN;
        } finally {
            System.out.println("Behaalde punten: " + behaaldePunten);
        }
        return behaaldePunten;
    }
}
