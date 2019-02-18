package cn.boai.dao.daopack.AddressDao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import cn.boai.dao.daopack.AddressDao.AddressDao;
import cn.boai.pojo.Address;

public class AddressDaoImpl implements AddressDao{

	@Override
	public boolean saveAddress(Address address, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "insert into address(user_id,add_info,add_status,add_name,add_number) values(?,?,?,?,?)";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, address.getUser_id());
		ps.setString(2, address.getAdd_info());
		ps.setInt(3, address.getAdd_status());
		ps.setString(4, address.getAdd_name());
		ps.setString(5, address.getAdd_number());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean updateAddress(Address address, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "update address set add_info=?,add_status=?,add_name=?,add_number=? where add_id=?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, address.getAdd_info());
		ps.setInt(2, address.getAdd_status());
		ps.setString(3, address.getAdd_name());
		ps.setString(4, address.getAdd_number());
		ps.setInt(5, address.getAdd_id());
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean deleteAddress(String id, Connection conn) throws Exception {
		boolean flag = false;
		String sql = "delete from address where add_id = ?";
		PreparedStatement ps = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		int n = ps.executeUpdate();
		if (n > 0) {
			flag = true;
		}
		ps.close();
		return flag;
	}

	@Override
	public Address selectAddressById(String id, Connection conn) throws Exception {
		Address address = null;
		String sql = "select * from address where add_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			address = new Address();
			address.setAdd_id(rs.getInt("add_id"));
			address.setUser_id(rs.getString("user_id"));
			address.setAdd_info(rs.getString("add_info"));
			address.setAdd_status(rs.getInt("add_status"));
			address.setAdd_info(rs.getString("add_info"));
			address.setAdd_name(rs.getString("add_name"));
			address.setAdd_number(rs.getString("add_number"));
			address.setAdd_def(rs.getString("add_def"));
		}
		rs.close();
		ps.close();

		return address;
	}

	@Override
	public List<Address> selectAllAddress(Connection conn) throws Exception {
		List<Address> list = new ArrayList<Address>();
		String sql = "select * from address";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			Address address = new Address();
			address.setAdd_id(rs.getInt("add_id"));
			address.setUser_id(rs.getString("user_id"));
			address.setAdd_info(rs.getString("add_info"));
			address.setAdd_status(rs.getInt("add_status"));
			address.setAdd_info(rs.getString("add_info"));
			address.setAdd_name(rs.getString("add_name"));
			address.setAdd_number(rs.getString("add_number"));
			address.setAdd_def(rs.getString("add_def"));
			list.add(address);
		}
		rs.close();
		ps.close();
		return list;
	}

}
