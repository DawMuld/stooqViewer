/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.chart.XYChart;




/**
 *
 * @author daan-
 */
public class ChartRange {

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final LocalDate lBound;
    private final LocalDate uBound;






    public ChartRange(LocalDate lBound, LocalDate uBound) {
        this.lBound = lBound;
        this.uBound = uBound;
    }






    @Override
    public String toString() {
        return lBound.format(DTF) + " to " + uBound.format(DTF);
    }






    public boolean isInRange(XYChart.Data<String, Number> chartData) {
        LocalDate date = toLocalDate(chartData.getXValue());
        return date.isAfter(lBound) && date.isBefore(uBound);
    }






    public private LocalDate toLocalDate(String dateString) {
        String[] items = dateString.split("-");
        return LocalDate.of(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Integer.parseInt(items[2]));

    }

}

