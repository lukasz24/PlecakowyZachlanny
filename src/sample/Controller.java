package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller extends VBox {
    ObservableList<String> items =FXCollections.observableArrayList ();

    ArrayList<Item> itemsList = new ArrayList<>();
    GreedyKnapsackProblem gkp = new GreedyKnapsackProblem();
    @FXML
    private ListView<String> itemList ;
    @FXML
    private ListView<String> itemsInKnapsack ;
    @FXML
    private Label currentCapacityLabel, currentValueLabel, timeLabel;
    @FXML
    private TextField maxCapacity;


    @FXML
    public void addItem(){
        itemsList.add(new Item(12, 13, "Bla"));
        System.out.println("Kliknięto");
        items.add("bla 12/3");
        itemList.setItems(items);
        //itemsList.add(new Item(12, 13, "Bla"));
    }

    @FXML
    public void removeAll(){
        System.out.println(items + "\n\n");
        items.removeAll();

        itemList.getItems().clear();
        itemsList.clear();
        System.out.println(items);
    }
    @FXML
    public void removeSelectedItem(){
        if(!itemList.getItems().isEmpty() && !itemList.getSelectionModel().isEmpty()){
            int number = itemList.getSelectionModel().getSelectedIndex();
            items.remove(number);
            itemList.getSelectionModel().clearSelection();
            itemsList.remove(number);
        }
    }
    //Wyświetlenie przedmiotów w plecaku
    public void prepareKnapsackContent(ArrayList names){
        ObservableList<String> itemsInKnap =FXCollections.observableArrayList ();

        itemsInKnap.addAll(names);
        itemsInKnapsack.setItems(itemsInKnap);
    }
    public void setResults(){

        currentCapacityLabel.setText(gkp.getCurrentCapacity());
        currentValueLabel.setText(gkp.getKnapsacValue());
        timeLabel.setText(gkp.getTime() + " s.");
        prepareKnapsackContent(gkp.getPackItems());
    }
    @FXML
    public void runGreedyKnapsackProblem(){
        gkp = new GreedyKnapsackProblem();
        gkp.runAlgorithm(Integer.parseInt(maxCapacity.getText()), itemsList);
        setResults();
        System.out.println("Klik");
        System.out.println("Lista przedmiotów: " + itemsList.size());
    }
}
