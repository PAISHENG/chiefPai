package tw.com.pai.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.pai.service.WebClientService;

public class WebClientServiceImpl implements WebClientService {

	private static final Logger logger = LoggerFactory.getLogger(WebClientServiceImpl.class);

	@Override
	public String GetHtmlResouceByURL(String url, String encoding) {
		// use java net url to as a webClient
		StringBuffer buffer = new StringBuffer();
		URL urlobj = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader input = null;
		try {
			urlobj = new URL(url);
			uc = urlobj.openConnection();
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			// 建立缓冲流读输入的数据
			input = new BufferedReader(isr);

			// 循环遍历数据
			String line = null;
			while ((line = input.readLine()) != null) {
				// 添加换行
				buffer.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("connection fail "+ e);
		} finally {
			try {
				if (isr != null)
					isr.close();
				if (input != null)
					input.close();
			} catch (IOException e) {
				logger.debug("close io fail"+ e);
			}
		}
		return buffer.toString();
	}
}
