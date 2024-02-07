package kr.co.three.pay.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.three.pay.dto.PayDTO;
import kr.co.three.pay.service.PayServiceImpl;
import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@Controller
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private PayServiceImpl payService;
	
	@Autowired
	private SalesServiceImpl salesService;
	
//	결제확인 페이지로 이동(sales dao,serviceImpl에서 처리)
	@GetMapping("/payCheckPage.do")
	public String payPage(@RequestParam(value = "salesNo") int salesNo, @RequestParam(value = "type") String type, SalesDTO sales, Model model,
			HttpSession session) {
		
		//데이터 불러오기(salesService 사용)
		SalesDTO salesCheck = salesService.payCheck(salesNo);

		model.addAttribute("salesCheck", salesCheck);
		
		
		if ("direct".equals(type)) {
	        return "pay/payDirectPage.do"; // 'pay/payDirectPage'는 직거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
	    } else if ("delivery".equals(type)) {
	        return "pay/payDeliveryPage.do"; // 'pay/payDeliveryPage'는 택배거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
	    } else {
	        return "error"; // 'error'는 잘못된 요청이 들어왔을 때 렌더링하는데 필요한 view의 이름입니다.
	    }
	}

//	결제 완료 페이지로 이동
	@PostMapping("/paying.do")
	public String paying(PayDTO pay, HttpSession session) {

		int memberNo = (int) session.getAttribute("memberNo");
		pay.setMemberNo(memberNo);

		return "pay/payComplete";

	}
	
	@GetMapping("/payDirectPage.do")
	public String payPage(@RequestParam(value = "salesNo") int salesNo, PayDTO pay, SalesDTO sales, Model model,
			HttpSession session) {
		

		SalesDTO salesCheck = salesService.payCheck(salesNo);

		model.addAttribute("salesCheck", salesCheck);
		
		
		return null;
		
		
		
		
		
		//pay 테이블 등록(결재에서 써야함)
//		pay.setPayReceipt("직거래");
//		pay.setPayAddress("직거래");
		
		
//		session.setAttribute("salesNo", salesNo);
//	    int memberNo = (int) session.getAttribute("memberNo");
//
//	    int salesNum = (int) session.getAttribute("salesNo"); // 세션에서 salesNo 값을 가져옴
//		System.out.println(salesNum);
//		System.out.println(memberNo);
//		pay.setSalesNo(salesNum);
//		pay.setMemberNo(memberNo);
//		
//		
//		int result = payService.insertPay(pay);
//		
//		
//
//		if (result == 1) {
//			return "redirect:/pay/payDirectPage.do";
//		} else {
//			return "common/error";
//		}
	}
	
	@RequestMapping("/kakaopay.cls")
	@ResponseBody
	public String kakaopay() {
		
		try {
			URL address = new URL("https://open-api.kakaopay.com/online/v1/payment/ready");
			HttpsURLConnection connect = (HttpsURLConnection) address.openConnection();
			connect.setRequestMethod("POST");
			connect.setRequestProperty("Authorization", "SECRET_KEY DEVCAA44D02689C6566DAD7E211D3E510F0BCDA9");
			connect.setRequestProperty("Content-Type", "application/json");
			connect.setDoOutput(true);
			
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=초코파이&quantity=1&total_amount=60000&vat_amount=200&tax_free_amount=0&approval_url=https://developers.kakao.com/success&fail_url=https://developers.kakao.com/fail&cancel_url=https://developers.kakao.com/cancel";
		
			OutputStream output = connect.getOutputStream();				//연결
			DataOutputStream dataOutput = new DataOutputStream(output);		//데이터 주는곳
			dataOutput.writeBytes(parameter);								//데이터 쓰기
//			dataOutput.flush();
			dataOutput.close();
			
			int result = connect.getResponseCode();
			
			InputStream input;
			if(result == 200) {
				input = connect.getInputStream();
			}else {
				input = connect.getErrorStream();
			}
			
			InputStreamReader inputReader = new InputStreamReader(input);
			BufferedReader bufferedReader = new BufferedReader(inputReader);
			
			return bufferedReader.readLine();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "{\"result\":\"NO\"}";
	}
	
	
	
	
	
}

