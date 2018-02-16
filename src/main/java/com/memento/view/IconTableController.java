package com.memento.view;

import com.memento.model.Icon;
import com.memento.services.MementoSearchService;
import com.memento.services.MementoSearchServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ImageGridCell;

// https://docs.oracle.com/javafx/2/ui_controls/pagination.htm
public class IconTableController {

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private VBox iconContainer;

    private ObservableList<Image> masterData = FXCollections.observableArrayList();

    private MementoSearchService mementoSearchService;

    public IconTableController() {
        mementoSearchService = new MementoSearchServiceImpl();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     *
     * Initializes the table columns and sets up sorting and filtering.
     */
    @FXML
    private void initialize() {

//        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
//        FilteredList<Icon> filteredData = new FilteredList<>(masterData, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
//        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(icon -> {
//                // If filter text is empty, display all persons.
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every Icon with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (icon.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches first name.
//                } else if (icon.getUrl().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches last name.
//                }
//                return false; // Does not match.
//            });
//        });

        // 3. search panel
        searchButton.setText("Search");
        searchButton.setOnAction(event -> {
            String searchText = searchField.getText();

            //TODO pass object with params
            mementoSearchService.search(searchText);
        });


        GridView<Image> myGrid = new GridView<>(masterData);
        myGrid.setCellFactory(gridView -> new ImageGridCell());

        for(int i = 0; i < 40; i++) {
            masterData.add(new Image("/text-field.png"));
        }

        iconContainer.getChildren().add(myGrid);
    }

}
