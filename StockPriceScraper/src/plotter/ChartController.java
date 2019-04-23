/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.util.List;
import stockpricescraper.HistoricValue;




/**
 *
 * @author daan-
 */
public class ChartController {

    private ChartModel chartModel;
    private ChartPane chartPane;






    public ChartController(ChartPane pane) {
        this.chartModel = new ChartModel();
        this.chartPane = pane;
        chartModel.addObserver(pane);
    }






    public void createChart(List<HistoricValue> list, String name) {
        System.out.println("Creating chart");
        chartModel.updateChartData(ChartDataConverter.convert(list), name);
    }

}

