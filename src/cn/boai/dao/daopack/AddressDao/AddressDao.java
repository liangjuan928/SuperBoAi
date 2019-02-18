package cn.boai.dao.daopack.AddressDao;

import java.util.List;

import com.mysql.jdbc.Connection;

import cn.boai.pojo.Address;

public interface AddressDao {
	public boolean saveAddress(Address address,Connection conn) throws Exception;
	public boolean updateAddress(Address address,Connection conn) throws Exception;
	public boolean deleteAddress(String id,Connection conn) throws Exception;
	public Address selectAddressById(String id,Connection conn) throws Exception;
	public List<Address> selectAllAddress(Connection conn) throws Exception;
}
