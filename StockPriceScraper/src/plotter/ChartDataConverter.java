/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.time.LocalDate;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import stockdata.StockChartData;
import stockpricescraper.HistoricValue;




/**
 *
 * @author daan-
 */
public class ChartDataConverter {

    public static ObservableList<XYChart.Series<String, Number>> convert(List<HistoricValue> input) {
        StockChartData data = new StockChartData();
        int iMax = input.size();

        for (int i = (iMax - 30); i < iMax; i++) {
            data.addHistoricValue(input.get(i));
        }
        return data.getChartData();
    }






    public static LocalDate toLocalDate(String input) {
        String[] items = input.split("-");
        int year = Integer.parseInt(items[0]);
        int month = Integer.parseInt(items[1]);
        int day = Integer.parseInt(items[2]);
        return LocalDate.of(year, month, day);

    }
}

