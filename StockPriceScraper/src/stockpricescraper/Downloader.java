package stockpricescraper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class Downloader {
   
    
    
    
    public static void main(String[] args){
        Document doc;
        try {
            doc = Jsoup.connect("https://stooq.pl/").get();
        } catch (IOException ex) {
            throw new RuntimeException(new Error("URLToDocumentError"));
        }
        Elements links = doc.getElementsByTag("a");
        for(int i = 0; i < links.size(); i++){
            System.out.println(links.get(i).attr("href"));
        }
    
    }
}
