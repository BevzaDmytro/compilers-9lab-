import extensions.LinearReheshing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {


    private int tableSize = 1100;
    private ArrayList<String> table;

    public Application() {
        this.table = new ArrayList<>();
        for(int i = 0; i< this.tableSize; i++){
            this.table.add(null);
        }
            

    }

    public void compareReheshing(int percent){

        LinearReheshing linear = new LinearReheshing(tableSize, percent, table);
        linear.run();
    }
}
