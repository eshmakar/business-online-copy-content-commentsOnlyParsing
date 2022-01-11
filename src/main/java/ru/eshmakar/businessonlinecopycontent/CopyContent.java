package ru.eshmakar.businessonlinecopycontent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CopyContent {
    private static String url = "https://m.business-gazeta.ru/article/534342";
    private static Document document;

    public static void main(String[] args) throws IOException {

        BufferedWriter writerTo5 = new BufferedWriter(new FileWriter("C://5.html"));
        document = Jsoup.connect(url).get();

        Elements selects = document.select("ul.comments-list");
        for (Element element : selects) {
            element.select("a").remove();
            element.select("div.popover__wrap").remove();
            element.select("div.comments-comment__etc").remove();
            element.select("div.show_full").remove();
        }

        writerTo5.write(selects.html());
        writerTo5.close();

    }
}
