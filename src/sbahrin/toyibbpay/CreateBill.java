/**
 * 
 */
package sbahrin.toyibbpay;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Shamsul Bahrin
 *
 */
public class CreateBill {
	
	static String url = Settings.API_URL + "createBill";
	public static String toyyibpayUrl = Settings.PAYMENT_URL;
	
	public static String post(
				String categoryCode,
				String billName,
				String billDescription,
				String billPriceSetting,
				String billPayorInfo,
				String billAmount,
				String billReturnUrl,
				String billCallbackUrl,
				String billExternalReferenceNo,
				String billTo,
				String billEmail,
				String billPhone,
				String billSplitPayment,
				String billSplitPaymentArgs,
				String billPaymentChannel,
				String billDisplayMerchant,
				String billContentEmail,
				String billChargeToCustomer ) throws Exception {
		
		
        Map<String,Object> params = new HashMap<>();
        params.put("userSecretKey", Settings.SECRET_KEY);
        params.put("categoryCode", categoryCode);
        params.put("billName", billName);
        params.put("billDescription", billDescription);
        params.put("billPriceSetting", billPriceSetting);
        params.put("billPayorInfo", billPayorInfo);
        params.put("billAmount", billAmount);
        params.put("billReturnUrl", billReturnUrl);
        params.put("billCallbackUrl", billCallbackUrl);
        params.put("billExternalReferenceNo", billExternalReferenceNo);
        params.put("billTo", billTo);
        params.put("billEmail", billEmail);
        params.put("billPhone", billPhone);
        params.put("billSplitPayment", billSplitPayment);
        params.put("billSplitPaymentArgs", billSplitPaymentArgs);
        params.put("billPaymentChannel", billPaymentChannel);
        params.put("billDisplayMerchant", billDisplayMerchant);
        params.put("billContentEmail", billContentEmail);
        params.put("billChargeToCustomer", billChargeToCustomer);

        String result = APIRequest.post(url, params);
                
		JSONArray jsonArray = new JSONArray(result.toString());
		JSONObject json = jsonArray.getJSONObject(0);
		String billCode = json.getString("BillCode");
        
		return billCode;
		
	}

	
	public static String makePayment(
			String billAmount, 
			String billTo,
			String billEmail,
			String billPhone,
			String billReturnUrl,
			String billCallbackUrl) throws Exception {
		String categoryCode = Settings.CATEGORY_CODE;
		String billName = "MAFEX Payment";
		String billDescription = "Payment for purchasing from MAFEX";
		String billPriceSetting = "1";
		String billPayorInfo = "1";
		String billExternalReferenceNo = "";
		String billSplitPayment = "0";
		String billSplitPaymentArgs = "";
		String billPaymentChannel = "2";
		String billDisplayMerchant = "1";
		String billContentEmail = "Thank You for your purchase from MAFEX";
		String billChargeToCustomer = "";
		
		String billCode = post(categoryCode, 
				billName, 
				billDescription, 
				billPriceSetting, 
				billPayorInfo, 
				billAmount, 
				billReturnUrl, 
				billCallbackUrl, 
				billExternalReferenceNo, 
				billTo, 
				billEmail, 
				billPhone, 
				billSplitPayment, 
				billSplitPaymentArgs, 
				billPaymentChannel, 
				billDisplayMerchant, 
				billContentEmail, 
				billChargeToCustomer);
		
		return billCode;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		String categoryCode = Settings.CATEGORY_CODE;
		String billName = "Mafex Bill";
		String billDescription = "Mafex Bill Description";
		String billPriceSetting = "1";
		String billPayorInfo = "1";
		String billAmount = "100";
		String billReturnUrl = "";
		String billCallbackUrl = "";
		String billExternalReferenceNo = "";
		String billTo = "SHAMSUL BAHRIN";
		String billEmail = "sbahrin3@gmail.com";
		String billPhone = "0186674654";
		String billSplitPayment = "0";
		String billSplitPaymentArgs = "";
		String billPaymentChannel = "2";
		String billDisplayMerchant = "1";
		String billContentEmail = "Thank You for your purchasing from MAFEX";
		String billChargeToCustomer = "";
		
		String billCode = post(categoryCode, 
				billName, 
				billDescription, 
				billPriceSetting, 
				billPayorInfo, 
				billAmount, 
				billReturnUrl, 
				billCallbackUrl, 
				billExternalReferenceNo, 
				billTo, 
				billEmail, 
				billPhone, 
				billSplitPayment, 
				billSplitPaymentArgs, 
				billPaymentChannel, 
				billDisplayMerchant, 
				billContentEmail, 
				billChargeToCustomer);
		
		System.out.println(billCode);
		System.out.println(CreateBill.toyyibpayUrl + billCode);
		
	}
	

}
