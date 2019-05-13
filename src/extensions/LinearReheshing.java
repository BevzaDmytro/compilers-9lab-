package extensions;

import java.util.ArrayList;

public class LinearReheshing extends AbstractReheshing {

    public LinearReheshing(int tableSize, int percent, ArrayList<String> table) {
        super(tableSize, percent, table);
    }

    @Override
    public void run() {
        this.basicFillTable();
        this.countProbes();
        System.out.println("Count of probes by linear rehearsing from "+ this.fillPercentage +"% is " + this.probesCount );

    }




    protected int calculateHash(String identifier, int j) {
        return (h0(identifier) + j) % this.tableSize;
    }

}
