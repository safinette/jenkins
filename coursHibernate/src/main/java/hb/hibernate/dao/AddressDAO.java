package hb.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import hb.hibernate.bean.Address;

public interface AddressDAO {
	
    public void addAddress(Address a);
    public void deleteAddress(Address a);
    public List<Address> listAddresses();
    public Session openCurrentSessionWithTransaction();
    public void closeCurrentSessionwithTransaction();
}
