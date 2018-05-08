package com.web.rnb.writeimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.write.WriteDTO;
import com.web.rnb.writeimpl.WritePager;


@Repository("WriteDAO")
public class WriteDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertWrite(WriteDTO wdto) {
		mybatis.insert("WriteDAO.insertWrite", wdto);
	}

	public WriteDTO getWrite(WriteDTO wdto) {
		return (WriteDTO)mybatis.selectOne("WriteDAO.getDetailWrite", wdto);
	}

	public List<WriteDTO> getListWrite(WritePager writePager) {
		return mybatis.selectList("WriteDAO.getListWrite", writePager);
	}

	public void updateWrite(WriteDTO wdto) {
		mybatis.update("WriteDAO.updateWrite", wdto);
	}


	public void deleteWrite(WriteDTO wdto) {
		mybatis.delete("WriteDAO.deleteWrite", wdto);
	}

	public void updateCount(WriteDTO wdto) {
		mybatis.update("WriteDAO.updateCount", wdto);
	}

	public int getTotalCount() {
		return mybatis.selectOne("WriteDAO.getTotalCount");
	}
	
	public List<WriteDTO> getListPopular(){
		return mybatis.selectList("WriteDAO.getListPopular");
	}
	
}