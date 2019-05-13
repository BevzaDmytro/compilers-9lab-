package extensions;

import java.util.ArrayList;

public abstract class AbstractReheshing {

    protected int tableSize;
    protected int fillPercentage;
    protected ArrayList<String> table;
    protected int probesCount;



    public AbstractReheshing(int tableSize, int fillPercentage, ArrayList<String> table) {
        this.tableSize = tableSize;
        this.fillPercentage = fillPercentage;
        this.table = table;
    }

    protected abstract void run();

    protected int h0(String string){
        int code = -1;

        code = string.hashCode() / tableSize;
        return code;
    }

    protected String generateRandomString(){
        String symbols = "qwertyuiopasdfghjklzxcvbnm";
        String random = "";

        int randomLenght = (int) (Math.random() * 6);
        char [] chars = symbols.toCharArray();
        for(int i = 0;i<randomLenght;i++){
            random += chars[(int) (Math.random() * 26)];
        }
        return random;
    }
}
