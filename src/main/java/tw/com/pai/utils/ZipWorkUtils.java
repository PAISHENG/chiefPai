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
}
