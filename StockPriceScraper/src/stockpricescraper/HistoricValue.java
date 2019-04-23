package stockpricescraper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;




/**
 *
 * @author DaanM
 */
public class HistoricValue {

    private final SimpleStringProperty date;
    private final SimpleDoubleProperty open;
    private final SimpleDoubleProperty high;
    private final SimpleDoubleProperty low;
    private final SimpleDoubleProperty close;
    private final SimpleLongProperty volume;






    public HistoricValue(String date, double open, double high, double low, double close, long volume) {
        this.date = new SimpleStringProperty(date);
        this.open = new SimpleDoubleProperty(open);
        this.high = new SimpleDoubleProperty(high);
        this.low = new SimpleDoubleProperty(low);
        this.close = new SimpleDoubleProperty(close);
        this.volume = new SimpleLongProperty(volume);
    }






    public String getDate() {
        return date.get();
    }






    public void setDate(String value) {
        date.set(value);
    }






    public StringProperty getDateProperty() {
        return date;
    }






    public double getOpen() {
        return open.get();
    }






    public void setOpen(double value) {
        open.set(value);
    }






    public DoubleProperty getOpenProperty() {
        return open;
    }






    public double getHigh() {
        return high.get();
    }






    public void setHigh(double value) {
        high.set(value);
    }






    public DoubleProperty getHighProperty() {
        return high;
    }






    public double getLow() {
        return low.get();
    }






    public void setLow(double value) {
        low.set(value);
    }






    public DoubleProperty getLowProperty() {
        return low;
    }






    public double getClose() {
        return close.get();
    }






    public void setClose(double value) {
        close.set(value);
    }






    public DoubleProperty getCloseProperty() {
        return close;
    }






    public long getVolume() {
        return volume.get();
    }






    public double getVolumeValue() {
        return (double) volume.get();
    }






    public void setVolume(long value) {
        volume.set(value);
    }






    public LongProperty getVolumeProperty() {
        return volume;
    }

}

