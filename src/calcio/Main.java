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

}