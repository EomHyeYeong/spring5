package chap03.spring;

import java.time.LocalDateTime;

public class Member {	// 회원 데이터 관련 클래스
	
	private long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password,
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}
	
	void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	
	// 암호를 변경하는 메서드
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException(); // custom exception
		this.password = newPassword;
	}

}
