package com.care.root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class MemberDAO {
	public int insert() {
		System.out.println("디비에 잘 저장되었습니다");
		return 1;
	}
	
	public MemberDAO() {
		System.out.println("DAO생성자 실행");
	}
}
