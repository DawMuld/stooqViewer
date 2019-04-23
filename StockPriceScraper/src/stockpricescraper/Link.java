package stockpricescraper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DaanM
 */
public class Link {

    private final String name;
    private final String href;





    public Link(String name, String path) {
        this.name = name;
        this.href = path;
    }





    @Override
    public String toString() {
        return name;
    }





    public String name() {
        return name;
    }





    public String href() {
        return href;
    }





}
