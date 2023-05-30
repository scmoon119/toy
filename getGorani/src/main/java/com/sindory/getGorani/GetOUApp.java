package com.sindory.getGorani;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetOUApp {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //	SpringApplication.run(GetGoraniApplication.class, args);
        System.out.println("now loading ... getOU");
        String crawlingUrl = "http://www.todayhumor.co.kr/board/list.php?table=humorbest";
        Document document = Jsoup.connect(crawlingUrl).userAgent("Mozilla").get();
        Elements mainContsElements = document.getElementsByClass("table_list");
        Elements aElements = mainContsElements.select("a[href]");

        List<String> urlList = new ArrayList<>();
        for (org.jsoup.nodes.Element aElement : aElements) {
            String htmlStr = aElement.attr("href");
            if (htmlStr.startsWith("#")) {
                break;
            }
            if( htmlStr.contains("list.php")) {  continue; }
            if( htmlStr.contains("no_tag")) {  continue; }

            urlList.add("http://www.todayhumor.co.kr" + htmlStr);
        }
        System.out.println(urlList.size() + " urls found. please press enter key");
        Scanner scn = new Scanner(System.in);
        scn.nextLine();

        for(int i = 0; i < urlList.size(); i ++){
            String url = urlList.get(i);
            Desktop.getDesktop().browse(new URI(url));
            System.out.println(url);
            if( (i +1) % 20 == 0){
                System.out.println("please press enter key");
                scn.nextLine();
            }

        }
        System.out.println("loading finished.");
    }
}
