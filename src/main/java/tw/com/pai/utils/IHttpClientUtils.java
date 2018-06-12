package tw.com.pai.utils;

import java.util.Map;

public interface IHttpClientUtils {

	public String getRequest(String url, Map<String, String> parms);
	
	public String postRequest(String url, Map<String, String> parms);
}
