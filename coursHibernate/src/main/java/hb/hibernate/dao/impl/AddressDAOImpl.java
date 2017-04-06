package hb.hibernate.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hb.hibernate.bean.Address;
import hb.hibernate.dao.AddressDAO;
import hb.hibernate.utils.Consts;

public class AddressDAOImpl implements AddressDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(
			AddressDAOImpl.class);
	
	private Session session;
	private Transaction transaction;
	
	public Session openCurrentSession() {
        session = getSessionFactory().openSession();
        return session;

    }
	
    public Session openCurrentSessionWithTransaction() {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeCurrentSession() {
        session.close();
    }
    
    public void closeCurrentSessionwithTransaction() {
        transaction.commit();
        session.close();

    }
    
    private static SessionFactory getSessionFactory() {

        StandardServiceRegistry standardRegistry = 
        		new StandardServiceRegistryBuilder().configure(Consts.HIBERNATE_CONFIG_FILE).build();
        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory;
    }
     
	public void addAddress(Address a) {
		System.out.println("[DAO] [addAddress] SG : a "+a);
		this.session.save(a);
        logger.info("Address saved successfully, Address Details="+a);

	}

	public void deleteAddress(Address a) {
		this.session.delete(a);
		this.session.flush();
		logger.info("Address deleted successfully, Address Details="+a);
	}

	public List<Address> listAddresses() {
		@SuppressWarnings("unchecked")
		List<Address> addresses = this.session.createQuery("from Address").getResultList();
        for(Address a : addresses){
            logger.info("Group List::"+a);
        }
        return addresses;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
