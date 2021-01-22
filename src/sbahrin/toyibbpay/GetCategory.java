/**
 * 
 */
package sbahrin.toyibbpay;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

/**
 * @author Shamsul Bahrin
 *
 */
public class GetCategory {
	
	static String url = Settings.API_URL + "getCategoryDetails";
	
	public static Map<String, Object> post(String categoryCode) throws Exception {
		
        Map<String,Object> params = new HashMap<>();
        params.put("userSecretKey", Settings.SECRET_KEY);
        params.put("categoryCode", categoryCode);
		
        String result = APIRequest.post(url, params);
		JSONObject json = new JSONObject(result);
		
		Map<String, Object> data = new HashMap<>();
		data.put("name", json.get("CategoryName"));
		data.put("description", json.get("categoryDescription"));
		data.put("status", json.get("categoryStatus"));
		
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		
		String categoryCode = Settings.CATEGORY_CODE;
		Map<String, Object> data = post(categoryCode);
		
		System.out.println("name: " + data.get("name"));
		System.out.println("description: " + data.get("description"));
		System.out.println("status: " + data.get("status"));
		
	}

}
