package com.youxuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteText {

	
	public static void main(String[] args) throws IOException {
		open();
		writeToTxt("1114");
		writeToTxt("2223");
		close();
	}
	
	public static FileWriter fw = null;
	public static BufferedWriter writer = null;

	public static void open() throws IOException {
		File file = new File("/Users/jinwanlin/Desktop/aa.txt");

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
