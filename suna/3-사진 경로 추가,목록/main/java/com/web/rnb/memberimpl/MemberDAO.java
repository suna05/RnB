package com.web.rnb.memberimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;

@Repository("MemberDAO")
public class MemberDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("MemberDAO 객체 생성");
	}
	public void insertMember(MemberDTO mdto) {
		System.out.println("MemberDAO.insertMember() 호출");
		mybatis.insert("MemberDAO.insertMember",mdto);
	}
	public MemberDTO getMember(MemberDTO mdto){
		System.out.println("MemberDAO.getMember() 호출");
		return (MemberDTO)mybatis.selectOne("MemberDAO.getMember",mdto);
	}
	public void updateMember(MemberDTO mdto) {
		System.out.println("MemberDAO.updateMember() 호출");
		mybatis.update("MemberDAO.updateMember", mdto);
	}
	public void deleteMember(MemberDTO mdto) {
		System.out.println("MemberDAO.deleteMember() 호출");
		mybatis.delete("MemberDAO.deleteMember",mdto);
	}
}
