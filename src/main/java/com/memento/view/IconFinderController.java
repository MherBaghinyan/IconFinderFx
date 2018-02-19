package com.memento.view;

import com.memento.model.Formats;
import com.memento.model.MementoResponseModel;
import com.memento.services.MementoSearchService;
import com.memento.services.MementoSearchServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ImageGridCell;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

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

        // search panel
        searchButton.setText("Search");
        searchButton.setOnAction(event -> loadData());

        searchField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loadData();
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

    private void loadData() {

        String searchText = searchField.getText();

        Task<List<String>> task = new Task<List<String>>() {
            @Override protected List<String> call() throws Exception {
                updateMessage("Loading images");

                List<String> result = new ArrayList<>();

                //TODO pass object with params
                Optional<MementoResponseModel> icons = mementoSearchService.search(searchText, 0);

                if (icons.isPresent()) {

                    MementoResponseModel model = icons.get();

                    if (!model.getIcons().isPresent()) {
                        return new ArrayList<>();
                    }

                    result = model.getIcons().get().stream()
                            .flatMap(raster -> raster.getRaster_sizes().stream())
                            .filter(item -> item.getSize() == 64)
                            .flatMap(formats -> formats.getFormats().stream())
                            .map(Formats::getPreview_url).collect(Collectors.toList());

                }

                return result;
            }
        };

//        task.setOnRunning((e) -> loadingDialog.show());
        task.setOnSucceeded(event -> {
            List<String> data = task.getValue();
            data.forEach(url -> masterData.add(new Image(url)));
            pagination.setVisible(true);
            pagination.setPageCount(masterData.size() / PAGE_ITEMS_COUNT);});

        Thread th = new Thread(task);

        th.setDaemon(true);

        th.start();
    }

}
