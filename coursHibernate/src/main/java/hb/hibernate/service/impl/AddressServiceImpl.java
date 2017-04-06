package hb.hibernate.service.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hb.hibernate.bean.Address;
import hb.hibernate.dao.AddressDAO;
import hb.hibernate.dao.impl.AddressDAOImpl;
import hb.hibernate.service.AddressService;

@ManagedBean(name="addressService")
@SessionScoped
public class AddressServiceImpl implements AddressService {
	
	private AddressDAO addressDAO = new AddressDAOImpl();
	
	public void addAddress(Address a) {
		addressDAO.openCurrentSessionWithTransaction();
		this.addressDAO.addAddress(a);
		addressDAO.closeCurrentSessionwithTransaction();
		
	}

	public void deleteAddress(Address a) {
		addressDAO.openCurrentSessionWithTransaction();
		this.addressDAO.deleteAddress(a);
		addressDAO.closeCurrentSessionwithTransaction();
	}

	public List<Address> listAddresses() {
		addressDAO.openCurrentSessionWithTransaction();
		List<Address> addresses =  this.addressDAO.listAddresses();
		addressDAO.closeCurrentSessionwithTransaction();
		return addresses;
	}

}
