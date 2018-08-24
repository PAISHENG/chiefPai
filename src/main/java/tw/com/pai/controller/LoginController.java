package tw.com.pai.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import tw.com.pai.model.Book;
import tw.com.pai.model.Shop;
import tw.com.pai.service.TWSEService;
import tw.com.pai.utils.ConstantsUrls;

@Controller
public class LoginController {
	final static Logger logger = Logger.getLogger(LoginController.class);
	private final String URL="http://mis.twse.com.tw/stock/api/getStockInfo.jsp"
			+ "?ex_ch=tse_2330.tw&json=1&delay=0&_=";
//	http://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_1102.tw&json=1&delay=0&_=1513517057719
	private final String INDEX="http://mis.twse.com.tw/stock/index.jsp";
	
	@Autowired
	TWSEService twseService;
	
	@RequestMapping(value = ConstantsUrls.INEDX, method = RequestMethod.GET)
	public String indexPage(ModelMap model) {
		//logs debug message
//				if(logger.isDebugEnabled()){
//					logger.debug("getWelcome is executed!");
//				}
//
//				//logs exception
//				logger.error("This is Error message", new Exception("Testing"));

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}
	
	@RequestMapping(value = ConstantsUrls.WEB_SOCKET, method = RequestMethod.GET)
	public String socketDemo(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "socketDemo";

	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String testTabsPage(ModelMap model) {
		model.addAttribute("key","test1");
		System.out.print("123");
		return "test";

	}
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String test2TabsPage(ModelMap model) {
		model.addAttribute("key","test2");
		System.out.print("test2");
		return "test";

	}
	@RequestMapping(value = "test3", method = RequestMethod.GET)
	public String test3TabsPage(ModelMap model) {
		model.addAttribute("key","test3");
		System.out.print("123");
		return "test";

	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public String printWelcome(ModelMap model) {
		Date now = new Date();
		String timeStamp=String.valueOf(now.getTime());
		StringBuffer result=new StringBuffer(URL).append(timeStamp);
		
//		model.addAttribute("message", "Spring 3 MVC Hello World");
		return result.toString();

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}
//	@RequestMapping(value="{name}", method = RequestMethod.GET)
//	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
//
//		Shop shop = new Shop();
//		shop.setName(name);
//		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
//
//		return shop;
//	}
	
	@RequestMapping(value="time", method = RequestMethod.GET)
	public @ResponseBody String getTime() {

		Date now = new Date();
		String timeStamp=String.valueOf(now.getTime());

		return timeStamp;
	}
	
	
	@RequestMapping(value = "/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "books.csv";
        
        response.setContentType("text/csv;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        Book book1 = new Book("Effective Java", "Java Best Practices",
                "Joshua Bloch", "Addision-Wesley", "0321356683", "05/08/2008",
                38);
 
        Book book2 = new Book("Head First Java", "Java for Beginners",
                "Kathy Sierra & Bert Bates", "O'Reilly Media", "0321356683",
                "02/09/2005", 30);
 
        Book book3 = new Book("Thinking in Java", "Java Core In-depth",
                "中文", "Prentice Hall", "0131872486", "02/26/2006", 45);
 
        Book book4 = new Book("Java Generics and Collections",
                "Comprehensive guide to generics and collections",
                "Naftalin & Philip Wadler", "O'Reilly Media", "0596527756",
                "10/24/2006", 27);
 
        List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);
 
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "Title", "Description", "Author", "Publisher",
                "isbn", "PublishedDate", "Price" };
 
        csvWriter.writeHeader(header);
 
        for (Book aBook : listBooks) {
            csvWriter.write(aBook, header);
        }
 
        csvWriter.close();
    }
	
	@RequestMapping(value="twse", method = RequestMethod.GET)
	@ResponseBody
	public String testAPI() {

		Date now = new Date();
		String timeStamp=String.valueOf(now.getTime());
		String urlGet=URL+timeStamp;
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
			HttpGet getRequest = new HttpGet(INDEX);
			HttpResponse response = httpClient.execute(getRequest);
//
//			System.out.println(response.getAllHeaders()[2].getValue());
			String cookie="response.getAllHeaders()[2].getValue()";
			
			HttpGet dataRequest = new HttpGet(urlGet);
			dataRequest.setHeader("Cookie", cookie);
			dataRequest.setHeader("Accept", "application/json");
			HttpResponse dataResponse = httpClient.execute(dataRequest);
			if (dataResponse.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + dataResponse.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((dataResponse.getEntity().getContent())));

			String output;
			StringBuffer result=new StringBuffer();
			while ((output = br.readLine()) != null) {
				result.append(output);
			}
			System.out.println(result.toString());
			return result.toString();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="opendataGov", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String govAPI() {

		String url="https://od.moi.gov.tw/od/data/api/EA28418E-8956-4790-BAF4-C2D3988266CC?$format=json";

		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
			
			HttpResponse response = httpClient.execute(new HttpGet(url));
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));

			String output;
			StringBuffer result=new StringBuffer();
			while ((output = br.readLine()) != null) {
				result.append(output);
			}
			System.out.println(result.toString());
			return result.toString();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
	}
	
//	private static String getCookie(){
//		try(){
//			
//		}catch(Exception e)){
//			e.printStackTrace();
//		}
//	}
	
//	HttpClient client = HttpClients.custom().build();
//	HttpUriRequest request = RequestBuilder.get()
//	  .setUri(SAMPLE_URL)
//	  .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
//	  .build();
//	client.execute(request);
}
