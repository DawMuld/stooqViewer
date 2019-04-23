/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import javafx.scene.chart.XYChart;




/**
 *
 * @author daan-
 */
public class StockSeries {

    private XYChart.Series<String, Number> openSeries;
    private XYChart.Series<String, Number> highSeries;
    private XYChart.Series<String, Number> lowSeries;
    private XYChart.Series<String, Number> closeSeries;






    public StockSeries() {
        openSeries = new XYChart.Series<>();
        openSeries.setName("Open");
        highSeries = new XYChart.Series<>();
        highSeries.setName("High");
        lowSeries = new XYChart.Series<>();
        lowSeries.setName("Low");
        closeSeries = new XYChart.Series<>();
        closeSeries.setName("Close");
    }






    public void add(String ymd, double open, double high, double low, double close) {

    }

}

