package org.example.missies;

public class KarakterTelMissie extends Missie implements GebruikerActies{
    String[] mogelijkeWoorden = new String[]{"Appeltaartpuntje", "Slagroomijstaartpuntje", "Pistachetaartpuntje", "Appeltaart met slagroom"};

    @Override
    void voerUit() {
       String randomWord = mogelijkeWoorden[(int) (Math.random() * mogelijkeWoorden.length)];
       System.out.printf("\ntel het aantal characters in de string:\n\t%s", randomWord);
       String antwoord = GebruikerActies.leesInput();
       try {
           Integer aantal = Integer.parseInt(antwoord);
           boolean antwoordCorrect = randomWord.length() == Integer.parseInt(antwoord);
           for (int i = 0; i < aantal; i++) {
               System.out.printf("\t%s\t", randomWord.charAt(i));
           }

           if (!antwoordCorrect) justThrowException();

       } catch(IndexOutOfBoundsException e) {
           System.out.println("hier is arithmetic exception opgetreden");
       } catch (MyException e) {
           System.out.println("Poeslief");
//           throw new RuntimeException(e);
       }
//       } catch(Exception e){
//           System.out.println("Hier is iets mis gegaan");
//       }

    }

    public static void justThrowException() throws MyException{
        throw new MyException("Explain Exception Here");
    }
}
