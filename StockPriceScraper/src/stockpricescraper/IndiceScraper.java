package stockpricescraper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class IndiceScraper {

    private static final String INDCE_PATH = "https://stooq.com/t/";





    public static ObservableList<Link> getIndiceList() {
        ObservableList<Link> indices = FXCollections.observableArrayList();
        try {
            Document doc = Jsoup.connect(INDCE_PATH).get();
            Elements elements = doc.getElementsByTag("a");
            for (int i = 0; i < elements.size(); i++) {
                String name = elements.get(i).text();
                String href = elements.get(i).attr("href");
                if (name.contains("^")) {
                    indices.add(new Link(name, href));
                }
            }
        } catch (IOException e) {
        }
        return indices;
    }





}
