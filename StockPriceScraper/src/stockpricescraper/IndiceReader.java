package stockpricescraper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class IndiceReader {

    private final static String HREF_BASE = "https://stooq.com/q/d/?s=";





    public static ObservableList<HistoricValue> parseIndex(Link link) {
        ObservableList<HistoricValue> stock = FXCollections.observableArrayList();
        Link downloadLink = getDownloadLink(getDocument(link));
        try {
            URL url = new URL(downloadLink.href());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] items = line.split(",");
                String date = items[0];
                double open = Double.parseDouble(items[1]);
                double high = Double.parseDouble(items[2]);
                double low = Double.parseDouble(items[3]);
                double close = Double.parseDouble(items[4]);
                long volume = 0L;
                if (items.length == 6) {
                    volume = Long.parseLong(items[5]);
                }
                HistoricValue value = new HistoricValue(date, open, high, low, close, volume);
                stock.add(value);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stock;
    }





    private static Document getDocument(Link link) {
        try {
            Document doc = Jsoup.connect(HREF_BASE + link.name()).get();
            return doc;
        } catch (IOException e) {
        }
        return null;
    }





    private static Link getDownloadLink(Document document) {
        Elements elements = document.getElementsByTag("a");
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            Link link = new Link(element.text(), "https://stooq.com/" + element.attr("href"));
            if (link.name().contains("Download data in csv file...")) {
                System.out.println("located link {\n\tname:" + link.name() + "\n\thref:" + link.href());
                return link;
            }
        }
        return null;
    }





}
