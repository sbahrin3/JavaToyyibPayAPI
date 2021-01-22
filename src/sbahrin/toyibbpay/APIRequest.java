/**
 * 
 */
package sbahrin.toyibbpay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Shamsul Bahrin
 *
 */
public class APIRequest {
	
	public static String post(String urlStr, Map<String, Object> params) throws Exception {
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        
        URL url = new URL (urlStr);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));		
		con.setDoOutput(true);
		con.getOutputStream().write(postDataBytes);
		int code = con.getResponseCode();
		if ( code == 200 ) {
			StringBuilder b = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String str = "";
			while ((str = br.readLine()) != null) {
				b.append(str);
			}
			return b.toString().trim();
		} else {
			return "Error: response code = " + code;
		}
	}
	
	public static void get(String urlStr) throws Exception {
		
		
	}

}
