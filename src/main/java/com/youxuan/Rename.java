package com.youxuan;

import java.io.File;
import java.io.IOException;

/**
 * 替换文件名中的某些字符串
 * 
 * @author jinwanlin
 *
 */
public class Rename {
	public static void main(String[] args) throws IOException {
		String macDir = "/Users/jinwanlin/Movies";
		String winDir = "D:\\Download\\电影电视";
		
		java.io.File file = new java.io.File(macDir);
		String dirPath = file.getAbsolutePath();// 目录路径
		if (file.isDirectory()) {
			File[] files = file.listFiles();// 获取此目录下的文件列表


			for (File fileFrom : files) {
				String fromFile = fileFrom.getName();// 文件名
				String toFileName = fromFile;
				String[] name = {"[电影天堂www.dygod.com]", 
								 "[电影天堂-www.dy2018.net].", 
								 "【6v电影www.6vdy.com】",
								 "【6v电影www.dy131.com】",
								 "【更多电视剧请去www.dy131.com】",
								 "迅雷下载www.xunbo.cc]",
								 "DVD版",
								 ".DVD",
								 "Movies\\",
								 "迅播影院www.XunBo.Cc]",
								 "www.kan66.com]",
								 "www.dygod.com加长收藏版",
								 ".720p.国粤双语.",
								 ".720p.BD中英双字幕", 
								 "国语中字1024高清",
								 ".720P.国粤双语.BD中字",
								 "(DVD高清晰)][国语中字]",
								 "6v电影www.dy131.com]",
								 "国粤双语中字",
								 "66影视www.66ys.cn]",
								 "【6v电影域名被盗,新地址www.6vhao.com】",
								 "【更多电影请去www.kan66.com】",
								 "x720版",
								 ".清晰TC电影下载www.66e.cc]",
								 "【最新电影www.66e.cc】",
								 "1280",
								 "1024",
								 "【更多电影请去www.66ys.org】",
								 "高清",
								 "中字",
								 "中英双字",
								 "国语",
								 "HD",
								 "BD",
								 "["
								 };
				for (int i = 0; i < name.length; i++) {
					toFileName = toFileName.replace(name[i], "");
				}
				
				toFileName = dirPath + File.separator + toFileName;
				File toFile = new File(toFileName);
				if (fileFrom.exists() && !toFile.exists()) {
					System.out.println(toFileName);
					// 开始更名
					 fileFrom.renameTo(toFile);
				}
			}

		}
	}
	

}
