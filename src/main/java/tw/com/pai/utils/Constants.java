package tw.com.pai.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final Map<String, String> REASON_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
		{
			put("0000", "Success");
			put("-1", "System error");
		}
	});
	
	public static final String OPEN_DATA_PM2POINT5="http://opendata2.epa.gov.tw/AQI.json";// 即時PM2.5資料
	public static final String SPECIAL_BOOKSTORE="https://cloud.culture.tw/frontsite/trans/emapOpenDataAction.do?method=exportEmapJson&typeId=M";//獨立書店(opendata)
}
