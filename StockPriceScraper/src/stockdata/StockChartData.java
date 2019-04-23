/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import stockpricescraper.HistoricValue;




/**
 *
 * @author daan-
 */
public class StockChartData {

    private XYChart.Series<String, Number> openSeries;
    private XYChart.Series<String, Number> highSeries;
    private XYChart.Series<String, Number> lowSeries;
    private XYChart.Series<String, Number> closeSeries;
    private XYChart.Series<String, Number> volumeSeries;






    public StockChartData() {
        openSeries = new XYChart.Series<>();
        openSeries.setName("Open");
        highSeries = new XYChart.Series<>();
        highSeries.setName("High");
        lowSeries = new XYChart.Series<>();
        lowSeries.setName("Low");
        closeSeries = new XYChart.Series<>();
        closeSeries.setName("Close");
        volumeSeries = new XYChart.Series<>();
        volumeSeries.setName("Volume");
    }






    public ObservableList<XYChart.Series<String, Number>> getChartData() {
        ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
        list.add(openSeries);
        list.add(highSeries);
        list.add(lowSeries);
        list.add(closeSeries);
        // list.add(volumeSeries);
        return list;
    }






    public void addHistoricValue(HistoricValue value) {
        XYChart.Data<String, Number> openData = new XYChart.Data<>(value.getDate(), value.getOpen());
        XYChart.Data<String, Number> highData = new XYChart.Data<>(value.getDate(), value.getHigh());
        XYChart.Data<String, Number> lowData = new XYChart.Data<>(value.getDate(), value.getLow());
        XYChart.Data<String, Number> closeData = new XYChart.Data<>(value.getDate(), value.getClose());
        XYChart.Data<String, Number> volumeData = new XYChart.Data<>(value.getDate(), value.getVolumeValue());
        this.addOpenValue(openData);
        this.addHighValue(highData);
        this.addLowValue(lowData);
        this.addCloseValue(closeData);
        this.addVolumeValue(volumeData);
    }






    public XYChart.Series<String, Number> getOpen() {
        return openSeries;
    }






    public XYChart.Series<String, Number> getHigh() {
        return highSeries;
    }






    public XYChart.Series<String, Number> getLow() {
        return lowSeries;
    }






    public XYChart.Series<String, Number> getClose() {
        return closeSeries;
    }






    public XYChart.Series<String, Number> getVolume() {
        return volumeSeries;
    }






    public void addOpenValue(XYChart.Data<String, Number> value) {
        openSeries.getData().add(value);
    }






    public void addHighValue(XYChart.Data<String, Number> value) {
        highSeries.getData().add(value);
    }






    public void addLowValue(XYChart.Data<String, Number> value) {
        lowSeries.getData().add(value);
    }






    public void addCloseValue(XYChart.Data<String, Number> value) {
        closeSeries.getData().add(value);
    }






    public void addVolumeValue(XYChart.Data<String, Number> value) {
        volumeSeries.getData().add(value);
    }

}

