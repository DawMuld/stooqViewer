/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockdata;




/**
 *
 * @author daan-
 */
public class HisQuote implements Comparable<HisQuote> {

    private int[] date;
    private double data[];






    public HisQuote() {
        date = new int[]{0, 0, 0};
        data = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
    }






    public HisQuote(int year, int month, int day) {
        date = new int[]{year, month, day};
        data = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
    }






    public HisQuote(int year, int month, int day, double open, double high, double low, double close, double volume) {
        date = new int[]{year, month, day};
        data = new double[]{open, high, low, close, volume};
    }






    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int[] getDate() {
        return date;
    }






    public int getYear() {
        return date[0];
    }






    public void setYear(int year) {
        date[0] = year;
    }






    public int getMonth() {
        return date[1];
    }






    public void setMonth(int month) {
        date[1] = month;
    }






    public int getDay() {
        return date[2];
    }






    public void setDay(int day) {
        date[2] = day;
    }






    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public double[] getData() {
        return data;
    }






    public double getOpen() {
        return data[0];
    }






    public void setOpen(double open) {
        data[0] = open;
    }






    public double getHigh() {
        return data[1];
    }






    public void setHigh(double high) {
        data[1] = high;
    }






    public double getLow() {
        return data[2];
    }






    public void setLow(double low) {
        data[2] = low;
    }






    public double getClose() {
        return data[3];
    }






    public void setClose(double close) {
        data[3] = close;
    }






    public double getVolume() {
        return data[4];
    }






    public void setVolume(double volume) {
        data[4] = volume;
    }






    @Override
    public int compareTo(HisQuote o) {
        int[] date2 = o.getDate();
        for (int i = 0; i < 3; i++) {
            if (date[i] > date2[i]) {
                return 1;
            } else if (date[i] < date2[i]) {
                return -1;
            }
        }
        return 0;
    }

}

