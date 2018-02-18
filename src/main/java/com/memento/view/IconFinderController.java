package com.memento.view;

import com.memento.model.MementoResponseModel;
import com.memento.services.MementoSearchService;
import com.memento.services.MementoSearchServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ImageGridCell;

import java.util.Optional;

// https://docs.oracle.com/javafx/2/ui_controls/pagination.htm
public class IconFinderController {

    public static final int PAGE_ITEMS_COUNT = 30;

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;

    @FXML
    private Pagination pagination;

    private ObservableList<Image> masterData = FXCollections.observableArrayList();

    private MementoSearchService mementoSearchService;

    public IconFinderController() {
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

        // 3. search panel
        searchButton.setText("Search");
        searchButton.setOnAction(event -> {
            String searchText = searchField.getText();

            //TODO pass object with params
            Optional<MementoResponseModel> icons = mementoSearchService.search(searchText);

            if (icons.isPresent()) {

                MementoResponseModel model = icons.get();

                model.getIcons().stream()
                        .flatMap(raster -> raster.getRaster_sizes().stream())
                        .filter(item -> item.getSize() == 64)
                        .flatMap(formats -> formats.getFormats().stream())
                        .forEach(url -> masterData.add(new Image(url.getPreview_url())));

                pagination.setPageCount(model.getTotal_count() / PAGE_ITEMS_COUNT);
                pagination.setVisible(true);

            }

        });

        pagination.setPageFactory(IconFinderController.this::createPage);

    }

    private Node createPage(Integer pageIndex) {

        GridView<Image> myGrid = new GridView<>(masterData);
        myGrid.setCellFactory(gridView -> new ImageGridCell());
        myGrid.setMaxHeight(200);

        VBox iconContainer = new VBox();

        iconContainer.getChildren().add(myGrid);

        return iconContainer;
    }

}
