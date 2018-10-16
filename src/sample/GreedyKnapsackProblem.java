package sample;
import java.util.ArrayList;

public class GreedyKnapsackProblem {
    private Knapsack knapsack = new Knapsack(0);
    private double time = 0;

    private void prepareItems(ArrayList<Item> items) {

        items.sort((Item i1, Item i2) -> (Float.compare(i1.getRatio(), i2.getRatio() )));

        for(Item i : items) {
            System.out.println("Stosunek: " + i.getRatio());
        }
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
        time = System.currentTimeMillis();
        knapsack.setKnapsackCapacity(knapsackCapacity);
        prepareItems(items);
        time = System.currentTimeMillis() - time;
    }

    public String getTime(){
        return "" + time;
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
