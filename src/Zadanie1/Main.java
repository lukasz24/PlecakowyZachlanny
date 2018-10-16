package Zadanie1;

public class Main {
	public static void main(String args[]) {
		Knapsack knapsack = new Knapsack(16);
		
		Item[] items = {new Item(3, 3, "Ceg³a"),
				new Item(1, 2, "Ketchup"), new Item(5, 4, "Wino"),
				new Item(9, 6, "Telefon"), new Item(2, 5, "Siatka Pomarañczy")
		};
		
		ProblemPlecakowyZachlanny zachlanny = new ProblemPlecakowyZachlanny(knapsack, items);
		System.out.println("===============ZACH£ANNY=============\n");
		zachlanny.prepareItems();
		zachlanny.packItems();
		zachlanny.summarize();
		
		ProblemPlecakowyDynamiczny dynamiczny = new ProblemPlecakowyDynamiczny(knapsack, items);
		System.out.println("\n\n===============DYNAMICZNY=============\n");
		dynamiczny.init();
		dynamiczny.completeKnapsack();
		dynamiczny.summarize();
	}
}
