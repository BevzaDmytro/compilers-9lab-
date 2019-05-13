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
    protected abstract int calculateHash(String identifier, int j);

    protected void countProbes() {
        int count =  100;
        int j = 0;
        for(int i = 0; i < count; i++ ){
            boolean isFree = true;

            String identifier = this.generateRandomString();
            while (isFree){
                int hash = this.calculateHash(identifier, j);
                if(this.table.get(hash) != null){
                    if(!this.table.get(hash).equals(identifier)) {
                        j++;
                        this.probesCount++;
                        if(j > this.tableSize-1) try {
                            throw new Exception("Conflict: can't calculate hash for "+ identifier);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    else break;
                }
                this.table.set(hash, identifier);
                isFree = false;
                j = 0;
            }

        }

    }

    protected void basicFillTable(){
        int count = this.tableSize * this.fillPercentage / 100;
        int j = 0;
        for(int i = 0; i < count; i++ ){
            boolean isFree = true;

            String identifier = this.generateRandomString();
            while (isFree){
                int hash = this.calculateHash(identifier, j);
                if(this.table.get(hash) != null){
                    if(!this.table.get(hash).equals(identifier)) {
                        j++;
                        if(j > this.tableSize-1) try {
                            throw new Exception("Conflict: can't calculate hash for "+ identifier);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    else {
                        break;
                    }
                }
                this.table.set(hash, identifier);
                isFree = false;
                j = 0;
            }

        }
    }



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
