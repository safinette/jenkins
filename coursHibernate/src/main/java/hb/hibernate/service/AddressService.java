package hb.hibernate.service;

import java.util.List;

import hb.hibernate.bean.Address;

public interface AddressService {
	
	 public void addAddress(Address a);
	 public void deleteAddress(Address a);
	 public List<Address> listAddresses();
}
