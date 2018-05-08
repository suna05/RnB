package com.web.rnb.memberimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;

@Repository("MemberDAO")
public class MemberDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberDTO mdto) {
		mybatis.insert("MemberDAO.insertMember",mdto);
	}
	public MemberDTO getMember(MemberDTO mdto){
		return (MemberDTO)mybatis.selectOne("MemberDAO.getMember",mdto);
	}
	public void updateMember(MemberDTO mdto) {
		mybatis.update("MemberDAO.updateMember", mdto);
	}
	public void deleteMember(MemberDTO mdto) {
		mybatis.delete("MemberDAO.deleteMember",mdto);
	}
	public List<MemberDTO> getListMember() {
		return mybatis.selectList("MemberDAO.getListMember");
	}
}
