//package com.youxuan;
//
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class S {
//
//	// 列表页面1
//	static String url_a = "http://taohuazu.cc/forum-221-1.html";
//	
//	// 列表页面2
//	static String URL_2 = "http://taohuazu.cc/forum-56-1.html";
//
//	public static void main(String[] args) {
////		b("http://taohuazu.cc/thread-145423-1-1.html");
//		b("http://taohuazu.cc/thread-6416-1-1.html");
//	}
//	
//	
//	public static void a() {
//		Document doc = Http.getUrl(url_a);
//		Elements links = doc.select(".z");
//		for (int i = 0; i < links.size(); i++) {
//			Element link = links.get(i);
//			String href = link.attr("href");
//			b(href);
//		}
//	}
//	
//	public static void b(String url) {
//		Document doc = Http.getUrl(url);
//
//		Elements imgs = doc.select("img.zoom");
//		for (int i = 0; i < imgs.size(); i++) {
//			Element img = imgs.get(i);
//			String src = img.attr("file");
//			System.out.println(src);
//			
//		}
//		
//	}
//	
//}
