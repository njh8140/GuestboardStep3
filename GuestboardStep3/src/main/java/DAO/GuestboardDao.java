package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Guestboard;

public class GuestboardDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	public int update(Guestboard guestboard) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		String query = null;
		
		try {
			con = ds.getConnection();
			query = "update guestboard set name = ?, email=?, inputdate=?, subject=?, content=? where id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, guestboard.getName());
			pst.setString(2, guestboard.getEmail());
			pst.setString(3, guestboard.getInputdate());
			pst.setString(4, guestboard.getSubject());
			pst.setString(5, guestboard.getContent());
			pst.setInt(6, guestboard.getId());
			
			return pst.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){} //썼으면 반납해야 한다
		}	
	}

	public Guestboard selectOne(int id) throws Exception{
		System.out.println("DAO selectOne();");
		PreparedStatement pst = null;
		String query = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "select * from guestboard where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				return null;
			} else {
				// 출력한 정보 준비해서 view 위임
				Guestboard guestboard = new Guestboard();
				guestboard.setId(rs.getInt("id"));
				guestboard.setName(rs.getString("name"));
				guestboard.setEmail(rs.getString("email"));
				guestboard.setInputdate(rs.getString("inputdate"));
				guestboard.setSubject(rs.getString("subject"));
				guestboard.setContent(rs.getString("content"));
				
				return guestboard;
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{if(rs != null) rs.close();}catch(SQLException e){}
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public int delete(int id) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "delete from guestboard where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			return pst.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public int insert(Guestboard guestboard) throws Exception{
		System.out.println("guestboardDAO insert();");
		PreparedStatement pst = null;
		String query = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "insert into guestboard(name, email, inputdate, subject, content) values (?, ?, ?, ?, ?)";
			pst = con.prepareStatement(query);
			pst.setString(1, guestboard.getName());
			pst.setString(2, guestboard.getEmail());
			pst.setString(3, guestboard.getInputdate());
			pst.setString(4, guestboard.getSubject());
			pst.setString(5, guestboard.getContent());
			
			return pst.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public ArrayList<Guestboard> selectAll() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "select * from guestboard";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			ArrayList<Guestboard> guestboards = new ArrayList<Guestboard>();
			
			while(rs.next()) {
				Guestboard tmp = new Guestboard();
				tmp.setId(rs.getInt("id"));
				tmp.setName(rs.getString("name"));
				tmp.setEmail(rs.getString("email"));
				tmp.setInputdate(rs.getString("inputdate"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				
				guestboards.add(tmp);
			}
			return guestboards;
	}catch(Exception e) {
		throw e;
	}finally {
		try{if(rs != null) rs.close();}catch(SQLException e){}
		try{if(st != null) st.close();}catch(SQLException e){}
		try{if(con != null) con.close();}catch(SQLException e){}
	}
	}
}