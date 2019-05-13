import extensions.LinearReheshing;
import extensions.RandomReheshing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {


    private int tableSize = 1024;
    private ArrayList<String> table;

    public Application() {
        this.table = new ArrayList<>();
        for(int i = 0; i< this.tableSize; i++){
            this.table.add(null);
        }
        System.out.println("Table was initialized with "+this.tableSize + " elements");
    }

    public void compareReheshing(int percent){

        LinearReheshing linear = new LinearReheshing(tableSize, percent, table);
        linear.run();

        this.setAllElementsNull();
        RandomReheshing randomReheshing = new RandomReheshing(tableSize, percent, table);
        randomReheshing.run();
    }

    private void setAllElementsNull(){
        for(int i = 0; i< this.tableSize; i++){
            this.table.set(i,null);
        }
    }
}
