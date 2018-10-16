package sample;
import java.util.ArrayList;

public class GreedyKnapsackProblem {
    private Knapsack knapsack ;
    private void prepareItems(ArrayList<Item> items) {
        items.sort((Item i1, Item i2) -> (Float.compare(i1.getRatio(), i2.getRatio() )));
        packItems(items);
    }

    private void packItems(ArrayList<Item> items) {
        for(int p = items.size() - 1; p >= 0; p--) {
            if(items.get(p).getWeight() <= knapsack.getFreeSpace()) {
                knapsack.addItem(items.get(p));
            }
        }
    }

    private ArrayList<String> summarize() {
        return knapsack.printContent();
    }
    public void runAlgorithm(int knapsackCapacity, ArrayList items){
        knapsack = new Knapsack(knapsackCapacity);
        prepareItems(items);
    }

    public ArrayList<String> getPackItems(){
        return summarize();
    }
    public String getCurrentCapacity(){
        return "" + knapsack.getItemsWeight();
    }
    public String getKnapsacValue(){
        return "" + knapsack.getKnapsackValue();
    }
}
