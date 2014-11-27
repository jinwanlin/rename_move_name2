package com.youxuan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * http封装
 * 
 * @author jinwanlin
 *
 */
public class Http {
	public static Document getUrl(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(60*1000).get();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return doc;
	}
}
