/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.util.List;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import stockpricescraper.HistoricValue;




/**
 *
 * @author daan-
 */
public class ChartPane extends BorderPane implements ChartObserver {

    private ChartController controller;
    private Label titleLabel;
    private LineChart<String, Number> lineChart;






    public ChartPane() {
        super();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Time");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("price ($)");
        lineChart = new LineChart<>(xAxis, yAxis);
        controller = new ChartController(this);
        setPrefSize(1600, 900);
        setCenter(lineChart);
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        titleLabel = new Label();
        flowPane.getChildren().add(titleLabel);
        setTop(flowPane);
        setBackground(new Background(new BackgroundFill(new RadialGradient(0, 0.1, 100, 100, 20, true, CycleMethod.REFLECT, new Stop(0, Color.web("#3D8380")), new Stop(1, Color.web("#A7D6D3"))), CornerRadii.EMPTY, Insets.EMPTY)));
    }






    public void makeChart(List<HistoricValue> valueList, String name) {
        Platform.runLater(() -> {
            controller.createChart(valueList, name);
        });
    }






    @Override
    public void chartDataChanged(ChartBundle bundle) {
        titleLabel.setText(bundle.quoteName);
        lineChart.setData(bundle.chartData);
    }

}

