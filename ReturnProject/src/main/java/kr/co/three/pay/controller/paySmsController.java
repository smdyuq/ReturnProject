package kr.co.three.pay.controller;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class paySmsController {

	 public static void sendPaymentSMS() {
	        String api_key = "가입후 받은 API KEY 값";
	        String api_secret = "API Secret 값";
	        Message coolsms = new Message(api_key, api_secret);

	        // 4 params(to, from, type, text) are mandatory. must be filled
	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("to", "01024749245");    // 수신전화번호
	        params.put("from", "0124749245");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
	        params.put("type", "SMS");
	        params.put("text", "결제가 완료되었습니다."); // 실제 발송할 문자 내용으로 수정하세요.
	        params.put("app_version", "test app 1.2"); // application name and version

	        try {
	            JSONObject obj = (JSONObject) coolsms.send(params);
	            System.out.println(obj.toString());
	        } catch (CoolsmsException e) {
	            System.out.println(e.getMessage());
	            System.out.println(e.getCode());
	        }
	    }

		/*
		 * public static void main(String[] args) { // 여기서는 main 메서드를 사용하여 직접 호출하지 않습니다.
		 * // 결제 성공 시에만 호출되어야 합니다. }
		 */
	}