package chap03.spring;

public class ChangePasswordService {	// 암호 변경 관련 클래스
	
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		// 암호를 변경할 Member 데이터를 찾기 위해 email을 사용
		Member member = memberDao.selectByEmail(email);
		if (member == null)	// email에 해당하는 Member 존재하지 않으면 예외 발생
			throw new MemberNotFoundException();
		
		// Member가 존재하면 changePassword를 이용해 암호를 변경하고 데이터를 보관
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	// setter 메서드를 통해 의존 객체 MemberDao를 주입 받는다.
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
