package chap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap03.spring.ChangePasswordService;
import chap03.spring.MemberDao;
import chap03.spring.MemberRegisterService;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}

}
