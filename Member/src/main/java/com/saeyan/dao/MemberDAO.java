	package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	//singleton pattern
	private MemberDAO() {}
	private static MemberDAO instance=new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	// DBCP Connection
	public Connection getConnection() throws Exception{
		Connection conn=null;
		Context initContext=new InitialContext();
		Context envContext=(Context)initContext.lookup("java:/comp/env");
		DataSource ds=(DataSource)envContext.lookup("jdbc/myoracle");
		conn=ds.getConnection();
		return conn;
	}
	//login 
	public int userCheck(String userid,String pwd) {
		int result=-1;//기본값
		String sql="select pwd from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) { // userid가 존재하면
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {//pwd가 일치하면
					result=1;
				}else { // pwd가 일치하지 않으면
					result=0;
				}				
			}else { // userid가 존재하지 않으면
				result=-1;				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result; // 1:pwd일치, 0:pwd불일치, -1:userid없음
	}
	//id중복체크
	public int confirmID(String userid) {
		int result=-1;
		String sql="select userid from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) { // userid가 있는 경우
				result=1;
			}else { // userid가 없는 경우
				result=-1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//회원등록
	public int insertMember(MemberVO mVo) {
		int result=-1;
		String sql="insert into member(name,userid,pwd,email,phone,admin) values(?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			result=pstmt.executeUpdate();//영향을 받은 행의 수 리턴.insert하면 1행이 추가되므로 1을 리턴.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {				
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//회원정보
	public MemberVO getMember(String userid) {
		MemberVO mVo=null;
		String sql="select * from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mVo=new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}
	//회원정보수정
	public int updateMember(MemberVO mVo) {
		int result=-1;
		String sql="update member set name=?,pwd=?,email=?,phone=?,admin=? where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());			
			pstmt.setString(2, mVo.getPwd());
			pstmt.setString(3, mVo.getEmail());
			pstmt.setString(4, mVo.getPhone());
			pstmt.setInt(5, mVo.getAdmin());
			pstmt.setString(6, mVo.getUserid());
			result=pstmt.executeUpdate();//영향을 받은 행의 수 리턴.update하면 1행이 변경되므로 1을 리턴.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {				
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
