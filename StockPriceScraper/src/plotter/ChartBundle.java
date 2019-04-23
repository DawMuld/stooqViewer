/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;




/**
 *
 * @author daan-
 */
public class ChartBundle {

    public final String quoteName;
    public final ObservableList<XYChart.Series<String, Number>> chartData;






    public ChartBundle(String quoteName, ObservableList<XYChart.Series<String, Number>> chartData) {
        this.quoteName = quoteName;
        this.chartData = chartData;
    }

}

