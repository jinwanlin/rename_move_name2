package com.youxuan;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 蜡笔小新 下载地址抓取
 * 
 * @author jinwanlin
 *
 */
public class Xiaoxin {
	private static WriteText w;
	
	public static void main(String[] args) {
		try {
			w = new WriteText("xiaoxin.txt");
			a();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				w.close();
			} catch (IOException e) {
			}
		}

	}



	public static void a() {
		String url = "http://www.a67.com/dm/3490";
		Document doc = Http.getUrl(url);

		Elements links = doc.select("ul#fenjilist li a");
		for (int i = 1000; i < links.size(); i++) {
			Element link = links.get(i);
			String href = link.attr("href");
			// System.out.println(href);
			
			w.writeText(i+1+"");
			b(href, link.text());
			
			if(i==1009){
				break;
			}
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
		Document doc = Http.getUrl(url);
		Element masthead = doc.select(".xunlei a").first();
		String thunderHref = masthead.attr("thunderHref");
		System.out.println(thunderHref);
		w.writeLine(thunderHref);
	}

//	public static FileWriter fw = null;
//	public static BufferedWriter writer = null;
//
//	public static void open() throws IOException {
//		
//		
//		File file = new File("xiaoxin.txt");
//		System.out.println(file.getAbsolutePath());
//		fw = new FileWriter(file);
//		writer = new BufferedWriter(fw);
//	}
//
//	public static void writeToTxt(String str) {
//
//		try {
//			writer.write(str);
//			writer.newLine();// 换行
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void close() throws IOException {
//		writer.flush();
//		writer.close();
//		fw.close();
//	}

}
