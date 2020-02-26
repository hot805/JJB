package com.jjb.Controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/mail", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public boolean mailSending(String email, int randomNum) throws Exception{
		System.out.println("여기 "+email);
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

			messageHelper.setTo(email);// 받는 사람
			messageHelper.setSubject("인증을 위한 메일입니다.");// 제목(생략은 가능)
			messageHelper.setText("인증을 위한 메일로 본인이 맞으시다면 회원가입 인증번호란에 생성된 수를 넣어주시길 바랍니다.  인증번호 : "+randomNum);// 매일 내용

			mailSender.send(message);
			//String result="인증을 위한 메일이 발송되었습니다.";
			System.out.println("완료");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//String result="메일 발송을 실패하였습니다.";
			return false;
		}
	}
}
