package extensions;

import java.util.ArrayList;

public class RandomReheshing extends AbstractReheshing {

    private int R = 1;

    public RandomReheshing(int tableSize, int fillPercentage, ArrayList<String> table) {
        super(tableSize, fillPercentage, table);
    }

    @Override
    public void run() {
        this.basicFillTable();
        this.countProbes();
        System.out.println("Count of probes by random rehearsing from "+ this.fillPercentage +"% is " + this.probesCount );
    }

    @Override
    protected int calculateHash(String identifier, int j) {
        this.R = this.R * 5;
        this.R = this.R  % (4 * this.tableSize);
        int r = (int) (this.R / 4);
        return (h0(identifier) + r) % this.tableSize;
    }
}
