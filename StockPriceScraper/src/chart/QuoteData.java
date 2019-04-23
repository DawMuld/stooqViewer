/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;




/**
 *
 * @author daan-
 */
public class QuoteData {

    private String name;
    private ObservableList<XYChart.Data<String, Number>> openData;
    private ObservableList<XYChart.Data<String, Number>> highData;
    private ObservableList<XYChart.Data<String, Number>> lowData;
    private ObservableList<XYChart.Data<String, Number>> closeData;






    public QuoteData() {
        this.name = "";
        openData = FXCollections.observableArrayList();
        highData = FXCollections.observableArrayList();
        lowData = FXCollections.observableArrayList();
        closeData = FXCollections.observableArrayList();
    }






    public QuoteData(String name) {
        this.name = name;
        openData = FXCollections.observableArrayList();
        highData = FXCollections.observableArrayList();
        lowData = FXCollections.observableArrayList();
        closeData = FXCollections.observableArrayList();
    }

}

