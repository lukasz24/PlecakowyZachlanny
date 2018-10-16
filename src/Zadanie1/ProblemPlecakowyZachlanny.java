package Zadanie1;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemPlecakowyZachlanny {	
	
	private static Knapsack knapsack = new Knapsack(16);
	
	//Przyk³adowe dane:
	private static Item[] items = {new Item(3, 3, "Ceg³a"),
			new Item(1, 2, "Ketchup"), new Item(5, 4, "Wino"),
			new Item(9, 6, "Telefon"), new Item(2, 5, "Siatka Pomarañczy")
	};
	
	public static void prepareItems() {		
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item p1, Item p2) {
				return (int) (p1.getRatio()*10000 - p2.getRatio()*10000);
			}
		});		
	}
	
	public static void packItems() {
		
		for(int p = items.length - 1; p >= 0; p--) {			
			
			if(items[p].getWeight() <= knapsack.getFreeSpace()) {				
					knapsack.addItem(items[p]);									
			}						
		}				
	}
	
	public static void summarize() {
		System.out.println("#################");
		System.out.println("W Plecaku: " + knapsack.getItemsWeight() + "/" + knapsack.getItemsWeight() + " Wartoœæ: " + knapsack.getKnapsackValue());
		knapsack.printContent();
	}
}
