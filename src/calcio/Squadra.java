package calcio;

import java.util.Random;

public class Squadra {
    private Calciatore[] calciatori= new Calciatore[100];
    private int contatore;

    public boolean addCalciatore(String name, int goal, boolean capitano){
        if (capitano){
            for (int i = 0; i< contatore; i++){
                if (calciatori[i].isCapitano()){
                    return false;
                }
            }
        }
        calciatori[contatore]=new Calciatore(name, goal, capitano);
        contatore++;
        return true;
    }
    public String printSquadra(){
        String out="";
        for (int i = 0; i < contatore ; i++){
            out+= calciatori[i].getName()+" goal:"+calciatori[i].getGoal()+" capitano:"+calciatori[i].isCapitano()+"\n";
        }
        return out;
    }
    public boolean editGiocatore(String name, String newName, int newGoal, boolean newCapitano){
        for (int i= 0; i< contatore; i++){
            if (name.equalsIgnoreCase(calciatori[i].getName())){
                calciatori[i] = new Calciatore(newName,newGoal,newCapitano);
                return true;
            }
        }
        return false;
    }
    public boolean delGiocatore(String name){
        for (int i= 0; i< contatore; i++){
            if (name.equalsIgnoreCase(calciatori[i].getName())){
                for (int j=i; j<contatore-1; j++) {
                    calciatori[j] = calciatori[j + 1];
                }
                calciatori[contatore]=null;
                contatore--;
                return true;
            }
        }
        return false;
    }
    public String goal5(){
        String out="";
        for (int i = 0; i < contatore ; i++){
            if(calciatori[i].getGoal()>5){
                out+= calciatori[i].getName()+" goal:"+calciatori[i].getGoal()+" capitano:"+calciatori[i].isCapitano()+"\n";
            }
        }
        return out;
    }
    public String getCapitano(){
        for (int i = 0; i < contatore; i++){
            if (calciatori[i].isCapitano()){
                return calciatori[i].getName();
            }
        }
        //se non ci sono capitani chiama il metodo che assegna il ruolo capitano casualmente e ritorna il suo nome
        return calciatori[setCapitanoRandom()].getName();
    }
    public int setCapitanoRandom(){
        Random random = new Random();
        int casuale = random.nextInt(contatore);
        calciatori[casuale].setCapitano(true);
        return casuale;
    }

    public Squadra(){
        contatore = 0;
    }
}
