package tw.com.pai.service;

public class TWSEService {
	private final String URL="http://mis.twse.com.tw/stock/api/getStockInfo.jsp"
			+ "?ex_ch=tse_2330.tw&json=1&delay=0&_=";
   public String toPrint(String url){
	   return url;
   }
}
