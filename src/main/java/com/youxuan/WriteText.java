package com.youxuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 写入文本文件
 * 
 * @author jinwanlin
 *
 */
public class WriteText {

	
	public static void main(String[] args) throws IOException {
		WriteText w = new WriteText("");
		w.writeLine("1114");
		w.writeLine("2223");
		w.close();
	}
	
	public FileWriter fw = null;
	public BufferedWriter writer = null;

	public WriteText(String abstractFilePath) throws IOException {
		File file = new File(abstractFilePath);

		fw = new FileWriter(file);
		writer = new BufferedWriter(fw);
	}
	

	public void writeText(String str) {
		try {
			writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeLine(String str) {
		try {
			writer.write(str);
			writer.newLine();// 换行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		writer.flush();
		writer.close();
		fw.close();
	}
}
