package com.Ajit;

import com.Ajit.factory.CatLogFactory;
import com.Ajit.factory.SearchFactory;

public class Main {

    public static void main(String[] args) {
        SearchFactory searchFactory = new SearchFactory();
        CatLogManager catLogManager = new CatLogFactory().getCatLogManager(searchFactory);
    }
}
