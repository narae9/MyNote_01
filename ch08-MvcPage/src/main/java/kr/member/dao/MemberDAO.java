package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.member.vo.MemberVO;
import kr.util.DBUtil;

public class MemberDAO {
	//싱글턴 패턴
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
		
		//회원가입
		public void insertMember(MemberVO member)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			PreparedStatement pstmt3 = null;
			ResultSet rs = null;
			String sql = null;
			int num = 0; //시퀀스 번호 저장
			
			try {
				conn = DBUtil.getConnection();
				//오토 커밋 해제
				conn.setAutoCommit(false);
				
				//회원번호(mem_num) 생성
				sql = "SELECT zmember_seq.nextval FROM dual";
				pstmt = conn.prepareStatement(sql);
				//4단계
				rs = pstmt.executeQuery();
				if(rs.next()) {
					num = rs.getInt(1);
				}
				//zmember에 데이터 저장
				sql = "INSERT INTO zmember (mem_num, id) VALUES (?,?)";
				//3단계
				pstmt2 = conn.prepareStatement(sql);
				//? 바인딩
				pstmt2.setInt(1, num);
				pstmt2.setString(2, member.getId());
				//4단계
				pstmt2.executeUpdate();
				
				sql = "INSERT INTO zmember_detail (mem_num,name,passwd,"
						+ "phone,email,zipcode,address1,address2) VALUES "
						+ "(?,?,?,?,?,?,?,?)";
				//3단계
				pstmt3 = conn.prepareStatement(sql);
				//?바인딩
				pstmt3.setInt(1, num);
				pstmt3.setString(2, member.getName());
				pstmt3.setString(3, member.getPasswd());
				pstmt3.setString(4, member.getPhone());
				pstmt3.setString(5, member.getEmail());
				pstmt3.setString(6, member.getZipcode());
				pstmt3.setString(7, member.getAddress1());
				pstmt3.setString(8, member.getAddress2());
				
				//4단계
				pstmt3.executeUpdate();
				
				//sql 실행시 모두 성공하면 commit
				conn.commit();
			}catch(Exception e) {
				//sql문이 하나라도 실패하면 rollback
				conn.rollback();
				throw new Exception(e);
			}finally {
				DBUtil.executeClose(null, pstmt3, null);
				DBUtil.executeClose(null, pstmt2, null);
				DBUtil.executeClose(rs, pstmt, conn);
			}
		}
		//ID 중복 체크 및 로그인 처리
		//회원상세 정보
		//회원정보 수정
		//비밀번호 수정
		//프로필 사진 수정
		//회원탈퇴(회원정보 삭제)
		
		//관리자
		//전체글 개수(검색글 개수)
		//목록(검색글 목록)
		//회원정보 수정
}