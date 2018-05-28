package tw.com.pai.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abola.crawler.CrawlerPack;

import tw.com.pai.utils.Constants;

@Controller
public class CrawlerController {
	
	final static Logger logger = Logger.getLogger(CrawlerController.class);
	
	@RequestMapping(value = "/crawlerPM2.5", method = RequestMethod.GET)
	@ResponseBody
	public String getOpenDate_PM2Point5(){
		return CrawlerPack.start()
	    .getFromJson(Constants.OPEN_DATA_PM2POINT5)
//	    .getElementsByTag("pm2.5").text();
	    .text();
	}
}
