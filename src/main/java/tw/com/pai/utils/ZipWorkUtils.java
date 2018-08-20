package tw.com.pai.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipWorkUtils {

	// 解壓縮檔案
	public static void doUnzipFile(String zipFile, String fileName, String exportPath) {
		byte[] buffer = new byte[1024];

		// 開啟欲解壓縮的檔案
		try {
			File folder = new File(zipFile);
			if (folder.exists()) {
				folder.mkdirs();
			}
			// get the zip file content
			System.out.println("file: "+ zipFile + fileName);
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile + fileName));
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (null != ze) {
				String unzipFileName = ze.getName();
				File newFile = new File(exportPath + File.separator + unzipFileName);
				System.out.println("file unzip : " + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				
				fos.close();   
	            ze = zis.getNextEntry();
			}
			
			zis.closeEntry();
	    	zis.close();
	    		
	    	System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// //取得壓縮檔內的下一個項目(一個壓縮的檔案或目錄，為壓縮時所建立的)
	// ZipEntry zipEntry = zIn.getNextEntry();
	//
	// //設定解壓縮的目的資料夾
	// String unZipDir = "C:/";
	// if(!zipEntry.isDirectory()) {
	//
	// //先判斷上一層資料夾是否存在，若不存在則先建立資料夾，再解壓縮檔案
	// File f1 = new File(unZipDir+zipEntry.getName());
	// File parent = f1.getParentFile();
	// if(!parent.exists()) {
	// parent.mkdirs();
	// }
	//
	// //開啟解壓縮欲寫入的檔案
	// FileOutputStream fOut = new FileOutputStream(f1);
	//
	// //以byte讀取解壓縮後的資料再寫入檔案
	// int byteNo1;
	// byte[] b1 = new byte[64];
	//
	// while ((byteNo1=zIn.read(b1))>0) {
	// fOut.write(b1, 0, byteNo1);
	// }
	// fOut.close();
	// zIn.close();
	// }
}
