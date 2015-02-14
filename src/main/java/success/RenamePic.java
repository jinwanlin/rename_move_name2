package success;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 挑选pic
 * 
 * @author jinwanlin
 *
 */
public class RenamePic {

	private static String macDir = "/Users/jinwanlin/s__";

	private static String newDir = "/Users/jinwanlin/s__2/";

	public static void main(String[] args) throws IOException {
		String[] exis = {".jpg", ".jpeg", ".png", ".png", "", "", "", "", "", "", "", "", "",};
		List<String> javaList = Arrays.asList(exis);

		int lastDir = 15;

		File newFilse = new File(newDir);
		if (!newFilse.exists()) {
			newFilse.mkdirs();
		}

		File file = new File(macDir);
		// String dirPath = file.getAbsolutePath();// 目录路径
		if (file.isDirectory()) {
			File[] dirs = file.listFiles();// 获取此目录下的文件列表

			for (int i = 0; i < dirs.length; i++) {
				File dir = dirs[i];

				if (dir.getName().charAt(0) == '.')
					continue;

				if (dir.isDirectory()) {
					File[] files = dir.listFiles();
					for (int j = 0; j < files.length; j++) {
						File f = files[j];
						long size = f.length();
						if (size < 10000)
							continue;

						String s = f.getName();
						if (s.equals(".DS_Store"))
							continue;
						String exi = s.substring(s.indexOf("."), s.length());
						if (!javaList.contains(exi))
							continue;

						String fileNameA = i + lastDir + 1 + "";

						File newFile = new File(newDir + dir.getName() + "_" + j + exi);
						f.renameTo(newFile);

					}

				}

			}

		}
	}

	// public static void main(String[] args) {
	// long sd=1412068518365L;
	// Date dat=new Date(sd);
	// GregorianCalendar gc = new GregorianCalendar();
	// gc.setTime(dat);
	// java.text.SimpleDateFormat format = new
	// java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	// String sb=format.format(gc.getTime());
	// System.out.println(sb);
	// }
}
