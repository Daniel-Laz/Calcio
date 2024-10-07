package calcio;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Calciatore[] calciatori= new Calciatore[100];
    public static int contatore;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int selezione;
        do{
            System.out.println("menu:\n" +
                    "1. ");



        }while(selezione!=0);

    }

    public static boolean addCalciatore(String name, int goal, boolean capitano){
        if (capitano){
            for (int i = 0; i< calciatori.length; i++){
                if (calciatori[i].isCapitano()){
                    return false;
                }
            }
        }
        calciatori[contatore]=new Calciatore(name, goal, capitano);
        contatore++;
        return true;
    }
    public static String printSquadra(){
        String out="";
        for (int i = 0; i < contatore ; i++){
            out+= calciatori[i]+"\n";
        }
        return out;
    }
    public static boolean editGiocatore(String name, String newName, int newGoal, boolean newCapitano){
        for (int i= 0; i< contatore; i++){
            if (name.equalsIgnoreCase(calciatori[i].getName())){
                calciatori[i] = new Calciatore(newName,newGoal,newCapitano);
                return true;
            }
        }
        return false;
    }
    public static boolean delGiocatore(String name){
        for (int i= 0; i< contatore; i++){
            if (name.equalsIgnoreCase(calciatori[i].getName())){
                for (int j=i; j<contatore-1; j++) {
                    calciatori[j] = calciatori[j + 1];
                    contatore--;
                    return true;
                }
            }
        }
        return false;
    }
    public static String goal5(){
        String out="";
        for (int i = 0; i < contatore ; i++){
            if(calciatori[i].getGoal()>5){
                out+= calciatori[i]+"\n";
            }
        }
        return out;
    }
    public static String getCapitano(){
        for (int i = 0; i < contatore; i++){
            if (calciatori[i].isCapitano()){
                return calciatori[i].getName();
            }
        }
        //se non ci sono capitani chiama il metodo che assegna il ruolo capitano casualmente e ritorna il suo nome
        return calciatori[setCapitanoRandom()].getName();
    }
    public static int setCapitanoRandom(){
        Random random = new Random();
        int casuale = random.nextInt(contatore);
        calciatori[casuale].setCapitano(true);
        return casuale;
    }
}