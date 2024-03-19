package org.example.missies;

public class KarakterTelMissie extends Missie implements GebruikerActies{
    String[] mogelijkeWoorden = new String[]{"Appeltaartpuntje", "Slagroomijstaartpuntje", "Pistachetaartpuntje", "Appeltaart met slagroom"};

    @Override
    int voerUit(boolean sloper) {
       String randomWord = mogelijkeWoorden[(int) (Math.random() * mogelijkeWoorden.length)];
       System.out.printf("\ntel het aantal characters in de string:\n\t%s", randomWord);
       System.out.println();
       String antwoord = GebruikerActies.leesInput();
       try {
           Integer aantal = Integer.parseInt(antwoord);
           boolean antwoordCorrect = randomWord.length() == Integer.parseInt(antwoord);
           for (int i = 0; i < aantal; i++) {
               System.out.printf("\t%s\t", randomWord.charAt(i));
           }
           setPunten(!sloper);
       } catch(IndexOutOfBoundsException e) {
           setPunten(sloper);
           e.printStackTrace();
           System.out.println("hier is arithmetic exception opgetreden");
       } catch (Exception e){
           System.out.println(e.getMessage());
           e.printStackTrace();
           behaaldePunten = DEVELOPER_STRAFPUNTEN;
       }finally {
           System.out.printf("Behaalde punten %d\n", behaaldePunten);
       }
       return behaaldePunten;
    }

}
