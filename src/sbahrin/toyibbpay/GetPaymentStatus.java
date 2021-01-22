/**
 * 
 */
package sbahrin.toyibbpay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import mafex.modules.DateUtil;

/**
 * @author Shamsul Bahrin
 *
 */
public class GetPaymentStatus {
	
	static String url = Settings.API_URL + "getBillTransactions";
    public static String[] keys = {"billName","billDescription","billTo","billEmail","billPhone","billStatus",
    		"billpaymentStatus","billpaymentChannel","billpaymentAmount",
    		"billpaymentInvoiceNo","billPaymentDate"};
	
	public static Map<String, Object> post(String billCode) throws Exception {
		
        Map<String,Object> params = new HashMap<>();
        params.put("billCode", billCode);
        params.put("billpaymentStatus", "");
		
        String result = APIRequest.post(url, params);
        
        JSONArray jsonArray = new JSONArray(result);
        JSONObject json = jsonArray.getJSONObject(0);
		
		Map<String, Object> data = new HashMap<>();
		for ( String key : keys ) {
			try {
				data.put(key, json.get(key));
			} catch ( Exception e ) {
				//ignore if key not found
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		
		String billCode = "xkjj75br";
		Map<String, Object> data = GetPaymentStatus.post(billCode);
		
		for ( String key : keys ) {
			System.out.println(key + ": " + data.get(key));
		}
		
		System.out.println("Bill payment..");
		String paymentDate = (String) data.get("billPaymentDate");
		String billPaymentInvoiceNo = (String) data.get("billpaymentInvoiceNo");
		System.out.println(paymentDate + ", " + billPaymentInvoiceNo);
		
		Date date = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(paymentDate);
		System.out.println(date);
	}
	

}
