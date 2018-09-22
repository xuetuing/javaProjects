package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Sale;

public class SaleDAOImpl implements SaleDAO {

	public List<Sale> findTop() throws Exception {
		List<Sale> list = new ArrayList<Sale>();
		
		Connection con = DBUtil.getConnection();
		String sql = "select * from sale order by qty desc limit ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 3);
		
		ResultSet rs = ps.executeQuery();
		Sale sale = null;
		while(rs.next()){
			sale = new Sale();
			sale.setId(rs.getInt("id"));
			sale.setName(rs.getString("name"));
			sale.setQuantity(rs.getInt("qty"));
			list.add(sale);
		}
		DBUtil.close(con);
		return list;
	}

}
