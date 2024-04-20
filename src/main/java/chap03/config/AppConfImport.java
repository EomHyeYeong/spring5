package chap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import chap03.spring.member.MemberDao;
import chap03.spring.printer.MemberPrinter;

@Configuration
@Import(AppConfig2.class)
public class AppConfImport {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

}
