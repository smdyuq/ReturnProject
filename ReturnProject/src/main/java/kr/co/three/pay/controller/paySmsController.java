package kr.co.three.pay.controller;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@RestController
public class paySmsController {

	//api 키 숨기기
	@Value("#{config['api_key']}")
	private String api_key;
	@Value("#{config['api_secret']}")
	private String api_secret;
    
	@PostMapping("/paySmsController")
    public String sendSms() {

//		System.out.println(api_key);
//		System.out.println(api_secret);
		
		
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", "01024749245");    // 수신전화번호
        params.put("from", "01024749245");  // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "등록 하신 물건의 구매 요청이 접수 되었습니다. 요청 확인해 주세요");
        params.put("app_version", "test app 1.2"); // application name and version

//        try {
//            JSONObject obj = (JSONObject) coolsms.send(params);
//            System.out.println(obj.toString());
//        } catch (CoolsmsException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getCode());
//        }
        return "success";
    }
}