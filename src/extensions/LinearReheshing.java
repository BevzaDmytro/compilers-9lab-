package extensions;

import java.util.ArrayList;

public class LinearReheshing extends AbstractReheshing {

    public LinearReheshing(int tableSize, int percent, ArrayList<String> table) {
        super(tableSize, percent, table);
    }

    @Override
    public void run() {
        this.basicFillTable();
        this.calculateNotNullProbes();
        this.countProbes();
    }

    private void calculateNotNullProbes() {
    }

    private void countProbes() {
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

        System.out.println("Count of probes by linear rehearsing from "+ this.fillPercentage +"% is " + this.probesCount );
    }

    private void basicFillTable(){
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

    private int calculateHash(String identifier, int j) {
        return (h0(identifier) + j) % this.tableSize;
    }

}
