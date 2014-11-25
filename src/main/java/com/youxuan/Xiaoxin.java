package com.youxuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Xiaoxin {

	public static void main(String[] args) {
		// String url = "http://www.weather.com.cn/weather/101010400.shtml";
		// Document doc = getUrl(url);
		//
		// Elements elem = doc.getElementsByTag("Title");
		// System.out.println("Title is:" + elem.text());
		try {
			open();
			a();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				close();
			} catch (IOException e) {
			}
		}

	}

	private static Document getUrl(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return doc;
	}

	public static void a() {
		String url = "http://www.a67.com/dm/3490";
		Document doc = getUrl(url);

		Elements masthead = doc.select("ul#fenjilist li a");
		for (Iterator iterator = masthead.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String href = element.attr("href");
			// System.out.println(href);
			b(href, element.text());
			// break;
		}
	}

	public static void b(String url, String text) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(60*1000).get();
		} catch (Exception e) {
			System.out.println(text + "   " +url);
			e.printStackTrace();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			b(url, text);
			return;
		}

		Element masthead = doc.select(".downurls ul li a").first();
		String href = masthead.attr("href");
		// System.out.println(href);
		c(href);
	}

	public static void c(String url) {
		Document doc = getUrl(url);
		Element masthead = doc.select(".xunlei a").first();
		String thunderHref = masthead.attr("thunderHref");
		System.out.println(thunderHref);
		writeToTxt(thunderHref);
	}

	public static FileWriter fw = null;
	public static BufferedWriter writer = null;

	public static void open() throws IOException {
		File file = new File("/Users/jinwanlin/Desktop/xiaoxin.txt");

		fw = new FileWriter(file);
		writer = new BufferedWriter(fw);
	}

	public static void writeToTxt(String str) {

		try {
			writer.write(str);
			writer.newLine();// 换行
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void close() throws IOException {
		writer.flush();
		writer.close();
		fw.close();
	}

}
