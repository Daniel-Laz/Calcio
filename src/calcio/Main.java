package calcio;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Squadra squadra = new Squadra();
        Scanner in = new Scanner(System.in);
        int selezione;
        do {
            System.out.println("menu:\n" +
                    "1. aggiunta giocatore\n" +
                    "2. visualizza squadra\n" +
                    "3. modifica giocatore\n" +
                    "4. cancella giocatore\n" +
                    "5. visualizza giocatori con > 5 goal\n" +
                    "6. visualizza capitano - se non ci sono capitani ne assegna uno casualmente");
            selezione = in.nextInt();

            switch (selezione) {
                case 1:
                    System.out.println("inserisci in ordine: nome INVIO goal INVIO capitano? (true o false)");
                    if (squadra.addCalciatore(in.next(), in.nextInt(), in.nextBoolean())) {
                        System.out.println("giocatore aggiunto");
                    } else {
                        System.out.println("giocatore non aggiunto - è già presente un capitano");
                    }
                    break;
                case 2:
                    System.out.println(squadra.printSquadra());
                    break;
                case 3:
                    System.out.println("inserisci in ordine: nome_precedente INVIO\nnome_nuvo INVIO goal_nuovi INVIO capitano? (true o false)");
                    if (squadra.editGiocatore(in.next(), in.next(), in.nextInt(), in.nextBoolean())) {
                        System.out.println("giocatore modificato");
                    } else {
                        System.out.println("giocatore non trovato");
                    }
                    break;
                case 4:
                    System.out.println("inserisci il nome del giocatore da eliminare");
                    if (squadra.delGiocatore(in.next())) {
                        System.out.println("giocatore eliminato");
                    } else {
                        System.out.println("giocatore non trovato");
                    }
                    break;
                case 5:
                    System.out.println(squadra.goal5());
                    break;
                case 6:
                    System.out.println(squadra.getCapitano());
                    break;
                default:
            }
        } while (selezione != 0);
    }
}