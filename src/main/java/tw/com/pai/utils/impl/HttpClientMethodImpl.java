package tw.com.pai.utils.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import tw.com.pai.utils.IHttpClientUtils;

public class HttpClientMethodImpl implements IHttpClientUtils {

	@Override
	public String getRequest(String url, Map<String, String> parms) {
		
		HttpClient   client= HttpClientBuilder.create().build();
		try {
			HttpResponse response=client.execute(new HttpGet(url));
			int statusCode=response.getStatusLine().getStatusCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String postRequest(String url, Map<String, String> parms) {
		
		HttpClient   client= HttpClientBuilder.create().build();
		try {
			HttpResponse response=client.execute(new HttpPost(url));
			int statusCode=response.getStatusLine().getStatusCode();
			
			if(statusCode == HttpStatus.SC_OK){
				
			}else{
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
