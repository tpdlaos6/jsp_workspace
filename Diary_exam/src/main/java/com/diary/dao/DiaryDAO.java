package com.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.diary.dto.DiaryVO;

import util.DBManager;

public class DiaryDAO {
	private DiaryDAO() {
	}
	
	private static DiaryDAO instance=new DiaryDAO();
	public static DiaryDAO getInstance() {
		return instance;
	}

	
	//등록
	public void insertDiary(DiaryVO dVo) {
		String sql="insert into diary(no,weather,title,content,wdate) values(seq_diary.nextval,?,?,?,sysdate)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getWeather());
			pstmt.setString(2, dVo.getTitle());
			pstmt.setString(3, dVo.getContent());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
	
