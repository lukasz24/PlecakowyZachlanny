package Zadanie1;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemPlecakowyZachlanny {	
	private Knapsack knapsack;
	private Item[] items;
	
	public ProblemPlecakowyZachlanny(Knapsack knapsack, Item[] items) {
		this.knapsack = knapsack;
		this.items = items;
	}
	
	public void prepareItems() {		
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item p1, Item p2) {
				return (int) (p1.getRatio()*10000 - p2.getRatio()*10000);
			}
		});		
	}
	
	public void packItems() {
		for(int p = items.length - 1; p >= 0; p--) {
			if(items[p].getWeight() <= knapsack.getFreeSpace()) {				
				knapsack.addItem(items[p]);									
			}						
		}				
	}
	
	public void summarize() {
		System.out.println("W Plecaku: " + knapsack.getItemsWeight() + "/" + knapsack.getKnapsackCapacity() + " kg. Wartoœæ: " + knapsack.getKnapsackValue() + "\n");
		knapsack.printContent();
	}
}
