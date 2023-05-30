package com.sindory.getGorani;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class GetGoraniApplication {

	public static void main(String[] args) throws IOException, URISyntaxException {
	//	SpringApplication.run(GetGoraniApplication.class, args);
		System.out.println("now loading ... getGorani");
//		String crawlingUrl = "https://gorani.kr/board/popular/issue?warning=only&time_range=nine&page=1";
		String crawlingUrl = "https://gorani.kr/best/main/gorani";
		Document document = Jsoup.connect(crawlingUrl).userAgent("Mozilla").get();
		Elements mainContsElements = document.getElementsByClass("common_list");
		Elements aElements = mainContsElements.select("a[href]");

		List<String> urlList = new ArrayList<>();
		for (org.jsoup.nodes.Element aElement : aElements) {
			String htmlStr = aElement.attr("href");
			if (htmlStr.startsWith("#")) {
				break;
			}
			urlList.add(htmlStr);
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
