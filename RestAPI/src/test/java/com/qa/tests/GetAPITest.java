package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.restclient.RrestClient;
import com.restapi.TestBase;

public class GetAPITest extends TestBase{
	TestBase testbase;
	String serviceUrl;
	String apiUrl;
	String url;
	CloseableHttpResponse closeablehttpResponse;
	RrestClient restclient;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
	testbase = new TestBase();
	serviceUrl = prop.getProperty("URL");
	apiUrl = prop.getProperty("serviceURL");
	
    url = serviceUrl + apiUrl;
	
	}
	@Test
	public void getTest() throws ClientProtocolException, IOException{
		 restclient = new RrestClient();
		closeablehttpResponse = restclient.get(url);
		
        //a.Status Code:
		int statuscode = closeablehttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code :" + statuscode);
		
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200,"status code not 200");

		String rsponseString = EntityUtils.toString(closeablehttpResponse.getEntity(), "UTF-8");
        
		//b.json String:
		JSONObject responseJson = new JSONObject(rsponseString);
		System.out.println("response json from api " + responseJson);
        
		//c.All Headers:
		Header[] headerArray = closeablehttpResponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allheaders.put(header.getName(), header.getValue());

		}
		System.out.println("Header Array" + allheaders);
		
	}
	
	
	
	

}
