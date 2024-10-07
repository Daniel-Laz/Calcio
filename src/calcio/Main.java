package calcio;

public class Main {
    public static Calciatore[] calciatori= new Calciatore[100];
    public static int contatore;

    public static void main(String[] args) {

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

}