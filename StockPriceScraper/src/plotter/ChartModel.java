/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;




/**
 *
 * @author daan-
 */
public class ChartModel {

    private final List<ChartObserver> oList;
    private String quoteName;
    private ObservableList<XYChart.Series<String, Number>> chartData;
    private LocalDate minDate;
    private LocalDate maxDate;
    private LocalDate startDate;
    private int visibleDates;






    public ChartModel() {
        oList = new ArrayList<>();
        quoteName = "";
    }






    public void addObserver(ChartObserver o) {
        oList.add(o);
    }






    public void removeObserver(ChartObserver o) {
        oList.remove(o);
    }






    public void updateChartData(ObservableList<XYChart.Series<String, Number>> chartData, String name) {
        this.chartData = chartData;
        visibleDates = chartData.get(0).getData().size();
        minDate = ChartDataConverter.toLocalDate(chartData.get(0).getData().get(0).getXValue());
        maxDate = ChartDataConverter.toLocalDate(chartData.get(0).getData().get(visibleDates - 1).getXValue());

        startDate = minDate;
        quoteName = name;
        fireChartDataUpdateEvent();
    }






    private void fireChartDataUpdateEvent() {
        if (!oList.isEmpty()) {
            ChartBundle bundle = new ChartBundle(quoteName, chartData);
            oList.forEach((o) -> {
                o.chartDataChanged(bundle);
            });
        }
    }

}

