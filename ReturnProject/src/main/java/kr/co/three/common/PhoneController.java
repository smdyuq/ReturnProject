package kr.co.three.common;

import java.util.Random;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
@ComponentScan(basePackages = "net.nurigo.sdk.message.service.DefaultMessageService")
public class PhoneController {

	private DefaultMessageService messageService;

	public PhoneController() {
		// 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다.
		this.messageService = NurigoApp.INSTANCE.initialize("NCS6JWGE9OSKRXIQ", "JI1KAFFQVKXLGHRFYRD2XTNWG4YOQLFW",
				"https://api.coolsms.co.kr");
	}

	@PostMapping("/send-one")
	public ResponseEntity<?> sendOne(@RequestParam("memberPhone") String memberPhone) {
//		Message message = new Message();
		// 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
//		message.setFrom("01024749245");
//		message.setTo(memberPhone);

		// 랜덤 인증번호 생성
		Random random = new Random();
		int randomCode = random.nextInt(9000) + 1000; // 4자리 랜덤 숫자 생성
		String verificationCode = String.valueOf(randomCode);
//		message.setText("인증번호는 " + verificationCode + "입니다.");

//		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
//		System.out.println(response);

		return new ResponseEntity<>(verificationCode, HttpStatus.OK);
	}
}
