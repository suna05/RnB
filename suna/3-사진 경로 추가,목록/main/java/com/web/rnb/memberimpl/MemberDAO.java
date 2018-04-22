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
		System.out.println("MemberDAO ��ü ����");
	}
	public void insertMember(MemberDTO mdto) {
		System.out.println("MemberDAO.insertMember() ȣ��");
		mybatis.insert("MemberDAO.insertMember",mdto);
	}
	public MemberDTO getMember(MemberDTO mdto){
		System.out.println("MemberDAO.getMember() ȣ��");
		return (MemberDTO)mybatis.selectOne("MemberDAO.getMember",mdto);
	}
	public void updateMember(MemberDTO mdto) {
		System.out.println("MemberDAO.updateMember() ȣ��");
		mybatis.update("MemberDAO.updateMember", mdto);
	}
	public void deleteMember(MemberDTO mdto) {
		System.out.println("MemberDAO.deleteMember() ȣ��");
		mybatis.delete("MemberDAO.deleteMember",mdto);
	}
}
