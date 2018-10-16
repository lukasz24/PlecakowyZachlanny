package Zadanie1;

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

	public int getKnapsackCapacity() {
		return knapsackCapacity;
	}

	public void setKnapsackCapacity(int knapsackCapacity) {
		this.knapsackCapacity = knapsackCapacity;
	}
	
	public void  printContent() {
		System.out.println("####### CONTENT: #######");
		for(Item p : knapsackContent) {
			System.out.println(p.name + " Waga: " + p.getWeight() + " Wartoœæ: " + p.getValue());
		}
	}
	
	public LinkedList<Item> getKnapsackItems() {
		return knapsackContent;
	}
}
