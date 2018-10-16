package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.Random;

public class Controller extends VBox {
    ObservableList<String> items =FXCollections.observableArrayList ();
    ArrayList<Item> itemsList = new ArrayList<>();
    GreedyKnapsackProblem gkp = new GreedyKnapsackProblem();
    DynamicKnapsackProblem dynamic;
    int licznik = 0;
    @FXML
    private ListView<String> itemList ;
    @FXML
    private ListView<String> itemsInKnapsack ;
    @FXML
    private Label currentCapacityLabel, currentValueLabel, timeLabel;
    @FXML
    private TextField maxCapacity, itemName, itemValue, itemWeight;


    @FXML
    public void addItem(){
        if(checkEmpty(itemName) && checkEmpty(itemValue) && checkEmpty(itemWeight)){
            String name = itemName.getText();
            int value = Integer.parseInt(itemValue.getText());
            int weight = Integer.parseInt(itemWeight.getText());
            itemsList.add(new Item(value, weight, name));
            items.add(name + "  (" + value + " / " + weight + ")");
            itemList.setItems(items);
        }
    }

    @FXML
    public void generateItem(){
        if(checkEmpty(maxCapacity)){
            int temp = licznik + 10;
            Random los = new Random();
            int pojemnosc = Integer.parseInt(maxCapacity.getText());
            while(licznik < temp){
                String name = "Item " + licznik;
                int value = los.nextInt(pojemnosc-1)+1;
                int weight = los.nextInt(pojemnosc-1)+1;
                itemsList.add(new Item(value, weight, name));
                items.add(name + "  (" + value + " / " + weight + ")");
                itemList.setItems(items);
                licznik++;
            }
        }
    }
    @FXML
    public void removeAll(){
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

    public void setResults(String capacity, String value, String time, ArrayList it){
        currentCapacityLabel.setText(capacity);
        currentValueLabel.setText(value);
        timeLabel.setText(time + " ms.");
        prepareKnapsackContent(it);
    }

    @FXML
    public void runGreedyKnapsackProblem(){
        if(itemsList.size() > 0){
            if(checkEmpty(maxCapacity)) {
                long time = System.currentTimeMillis();
                gkp = new GreedyKnapsackProblem();
                gkp.runAlgorithm(Integer.parseInt(maxCapacity.getText()), itemsList);
                time = System.currentTimeMillis() - time;
                setResults(gkp.getCurrentCapacity(), gkp.getKnapsacValue(), "" + time, gkp.getPackItems());
            }
        }
    }

    @FXML
    public void runDynamicKnapsackProblem(){
        if(itemsList.size() > 0){
            if(checkEmpty(maxCapacity)){
                long time = System.currentTimeMillis();
                dynamic = new DynamicKnapsackProblem(Integer.parseInt(maxCapacity.getText()), itemsList);
                dynamic.runAlgorithm();
                time = System.currentTimeMillis() - time;
                setResults(dynamic.getCurrentCapacity(), dynamic.getKnapsacValue(), "" + time, dynamic.summarize());
            }
        }
    }

    private boolean checkEmpty(TextField element){
        if(element.getText().isEmpty()){
            element.setStyle("-fx-background-color: #FA8072");
            return false;
        }else{
            element.setStyle("-fx-background-color: white");
            return true;
        }

    }
}
