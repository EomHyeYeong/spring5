package chap03.spring;

import java.time.LocalDateTime;

public class MemberRegisterService {	// 회원 가입 처리 관련 클래스
	
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// 
	public long regist(RegisterRequest req) {
		// memberDao의 selectByEmail 메서드를 이용해 동일 이메일을 갖는 회원 데이터 존재를 확인
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null)	// 존재하면 예외를 발생
			throw new DuplicateMemberException("dup email " + req.getEmail());
		
		// 존재하지 않으면 Member 객체를 생성, memberDao 클래스의 insert 메서드를 이용해 저장
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}

}
