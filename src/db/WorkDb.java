package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkDb {
	PreparedStatement ps = null;
	ResultSet resultSet=null;
	public void select(Connection con,Object a[][]){
		int i=0;
		String sql="select * from t_user";
		try {
			ps=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			resultSet=ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {	
			System.out.println("表中数据如下:");
			System.out.println("----------------------");
			while(resultSet.next()) {
				String userName=resultSet.getString("userName");
				String tel=resultSet.getString("tel");
				a[i][0]=userName;
				a[i][1]=tel;
				i++;
				System.out.println("userName："+userName);
				System.out.println("tel："+tel);
				System.out.println("----------------------");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
					
	}

	public ResultSet getUsers(User user, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from t_user ");
		if (user.getUserName() != null) {
			sql.append(" where userName like '%" + user.getUserName() + "%'");
		}
		ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(User user, Connection con) throws SQLException {
		String	sql = "delete from t_user where userName='" + user.getUserName() + "'";	
		ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(User user, Connection con) throws SQLException {
		String sql = "insert into t_user  values(?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getTel());
		return ps.executeUpdate();
	}
	public int modify(User user, Connection con) throws SQLException {
		String sql = "update t_user  set userName=?, tel=? where userName = '" + user.getUserName() + "'";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getTel());
		return ps.executeUpdate();
	}
}
