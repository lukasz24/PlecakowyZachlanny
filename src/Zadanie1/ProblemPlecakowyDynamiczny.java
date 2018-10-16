package Zadanie1;

public class ProblemPlecakowyDynamiczny {
	private Knapsack knapsack;
	private Item[] items;
	private int[] result;
	private Knapsack[] knapsacks;
	
	public ProblemPlecakowyDynamiczny(Knapsack knapsack, Item[] items) {
		this.knapsack = knapsack;
		this.items = items;
		result = new int[knapsack.getKnapsackCapacity() + 1];
		knapsacks = new Knapsack[knapsack.getKnapsackCapacity() + 1];
	}
	
	public void init() {
		for (int i = 0; i <= knapsack.getKnapsackCapacity(); i++) {
			result[i] = 0;
		}
	}
	
	public void completeKnapsack() {
		for (int i = 0; i <= knapsack.getKnapsackCapacity(); i++) {
			if (i-1 >= 0) {
				knapsacks[i] = new Knapsack(knapsack.getKnapsackCapacity());
				knapsacks[i].getKnapsackItems().addAll(knapsacks[i-1].getKnapsackItems());
			} else {
				knapsacks[i] = new Knapsack(knapsack.getKnapsackCapacity());
			}
			for (Item item : items) {
				if (item.getWeight() <= i) {
					result[i] = getMaxValue(result[i], result[i-item.getWeight()] + item.getValue(), i, item);
				}
			}
		}
	}
	
	private int getMaxValue(int v1, int v2, int i, Item item) {
		if (v2 > v1) {
			if (knapsacks[i].getKnapsackItems().isEmpty()) {
				knapsacks[i].addItem(item);
			} else if (knapsacks[i].getItemsWeight() + item.getWeight() < i) {
				knapsacks[i].addItem(item);
			} else {
				knapsacks[i] = new Knapsack(knapsack.getKnapsackCapacity());
				knapsacks[i].getKnapsackItems().addAll(knapsacks[i-item.getWeight()].getKnapsackItems());
				knapsacks[i].addItem(item);
			}
			return v2;
		} else {
			return v1;
		}
	}
	
	public void summarize() {
		Knapsack finalKnapsack = knapsacks[knapsack.getKnapsackCapacity()];
		System.out.println("W Plecaku: " + finalKnapsack.getItemsWeight() + "/" + knapsack.getKnapsackCapacity() + " kg. Wartoœæ: " + finalKnapsack.getKnapsackValue() + "\n");
		finalKnapsack.printContent();
	}
}
