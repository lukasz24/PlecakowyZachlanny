package sample;
import java.util.ArrayList;
import java.util.LinkedList;

public class Knapsack {
    private int knapsackCapacity;
    private LinkedList<Item> knapsackContent = new LinkedList<Item>();

    public Knapsack(int knapsackCapacity) {
        this.knapsackCapacity = knapsackCapacity;
    }

    public int getItemsWeight() {
        int itemsWeight = 0;
        for(Item p : knapsackContent) {
            itemsWeight += p.getWeight();
        }
        return itemsWeight;
    }

    public int getKnapsackValue() {
        int value = 0;
        for(Item p : knapsackContent) {
            value += p.getValue();
        }
        return value;
    }

    public int getFreeSpace() {
        return knapsackCapacity - getItemsWeight();
    }

    public void addItem(Item item) {
        knapsackContent.add(item);
    }
    public void clearItems(){
        knapsackContent.clear();
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public void setKnapsackCapacity(int knapsackCapacity) {
        this.knapsackCapacity = knapsackCapacity;
    }

    public ArrayList<String> printContent() {
        //System.out.println("\n####### CONTENT: #######\n");
        ArrayList<String> tabela = new ArrayList<>();
        for(int i = 0; i < knapsackContent.size(); i++) {
          tabela.add(knapsackContent.get(i).name + " " + knapsackContent.get(i).getValue() + "/"+ knapsackContent.get(i).getWeight() );
        }
        return tabela;
    }

}