/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockpricescraper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import plotter.ChartPane;




/**
 *
 * @author daan-
 */
public class StockPriceScraper extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private FlowPane buttonPane;
    private String quoteName = "";
    private ObservableList<HistoricValue> valueList;
    private ChartPane chartPane;






    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        buttonPane = new FlowPane();
        buttonPane.setAlignment(Pos.CENTER_LEFT);
        buttonPane.setMinHeight(30);
        chartPane = new ChartPane();
        valueList = FXCollections.observableArrayList();
        root.setTop(buttonPane);
        root.setPadding(new Insets(32, 16, 16, 16));
        ListView<Link> indiceList = new ListView<>();
        ObservableList<Link> indiceItems = IndiceScraper.getIndiceList();
        indiceList.setItems(indiceItems);
        indiceList.setPrefSize(400, 800);
        TableView table = initTableView();
        table.setPrefSize(620, 900);
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(620, 900);
        stackPane.getChildren().add(table);
        root.setLeft(indiceList);
        root.setCenter(chartPane);
        root.setRight(stackPane);
        indiceList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            valueList = createTableData(newValue);
            quoteName = newValue.name();
            table.setItems(valueList);
            chartPane.makeChart(valueList, quoteName);

        });
        Button chartButton = new Button("show chart");
        chartButton.setOnAction((event) -> {
            System.out.println("Pointless Button press hahahahahaha");
        });
        buttonPane.getChildren().add(chartButton);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }






    private TableView<HistoricValue> initTableView() {
        TableView<HistoricValue> table = new TableView();
        /**/
        TableColumn dateColumn = new TableColumn("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<HistoricValue, String>("date"));
        dateColumn.setPrefWidth(120);
        /**/
        TableColumn openColumn = new TableColumn("Open");
        openColumn.setCellValueFactory(new PropertyValueFactory<HistoricValue, Double>("open"));
        openColumn.setCellFactory(tc -> new CurrencyCell<>());
        openColumn.setPrefWidth(100);
        /**/
        TableColumn highColumn = new TableColumn("High");
        highColumn.setCellValueFactory(new PropertyValueFactory<HistoricValue, Double>("high"));
        highColumn.setCellFactory(tc -> new CurrencyCell<>());
        highColumn.setPrefWidth(100);
        /**/
        TableColumn lowColumn = new TableColumn("Low");
        lowColumn.setCellValueFactory(new PropertyValueFactory<HistoricValue, Double>("low"));
        lowColumn.setCellFactory(tc -> new CurrencyCell<>());
        lowColumn.setPrefWidth(100);
        /**/
        TableColumn closeColumn = new TableColumn("Close");
        closeColumn.setCellValueFactory(new PropertyValueFactory<HistoricValue, Double>("close"));
        closeColumn.setCellFactory(tc -> new CurrencyCell<>());
        closeColumn.setPrefWidth(100);
        /**/
        TableColumn volumeColumn = new TableColumn("Volume");
        volumeColumn.setCellValueFactory(new PropertyValueFactory<HistoricValue, Long>("volume"));
        volumeColumn.setPrefWidth(100);
        table.getColumns().addAll(dateColumn, openColumn, highColumn, lowColumn, closeColumn, volumeColumn);
        return table;
    }






    public ObservableList<HistoricValue> createTableData(Link link) {
        return IndiceReader.parseIndex(link);
    }






    public LineChart createLineChart(ObservableList<HistoricValue> items) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("open");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("high");
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("low");
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("close");
        for (int i = 0; i < 100; i++) {
            HistoricValue item = items.get(i);
            series1.getData().add(new XYChart.Data(item.getDate(), item.getOpen()));
            series2.getData().add(new XYChart.Data(item.getDate(), item.getHigh()));
            series3.getData().add(new XYChart.Data(item.getDate(), item.getLow()));
            series4.getData().add(new XYChart.Data(item.getDate(), item.getClose()));
        }
        lineChart.getData().addAll(series1, series2, series3, series4);
        lineChart.setPrefSize(800, 800);
        return lineChart;
    }




    public class CurrencyCell<T> extends TableCell<T, Double> {

        private final NumberFormat format = DecimalFormat.getCurrencyInstance();






        @Override
        protected void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setText(format.format(item));
            }
        }

    }


}

