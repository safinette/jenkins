package hb.hibernate.dao.impl;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hb.hibernate.bean.Groupe;
import hb.hibernate.dao.GroupeDAO;
import hb.hibernate.utils.Consts;

public class GroupeDAOImpl implements GroupeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(
												GroupeDAOImpl.class);
	 
	private Session session;
	private Transaction transaction;
	
	public Session openCurrentSession() {
        session = getSessionFactory().openSession();
        return session;
    }
	
	public void closeCurrentSession() {
		session.close();
	}
	    
    public Session openCurrentSessionWithTransaction() {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeCurrentSessionwithTransaction() {
        transaction.commit();
        session.close();
    }

    public void addGroupe(Groupe g) {
        this.session.merge(g);
        logger.info("Group saved successfully, Group Details="+g);
    }
    
    public void deleteGroupe(Groupe g) {
    	 this.session.delete(g);
    	 this.session.flush();
    	 logger.info("Group deleted successfully, Group Details="+g);
	}
    
	public Groupe findGroupeByName(String name) {
		String queryString = "FROM Groupe g WHERE g.name = :name";
		Query query = this.session.createQuery(queryString);
		query.setParameter("name", name);
		return (Groupe) query.getSingleResult();
	}
	  
    public void updateGroupe(Groupe g){
    	this.session.update(g);
    }
    
    @SuppressWarnings("unchecked")
	public List<Groupe> listGroupes() {
    	System.out.println("listGroups session :"+session);
        List<Groupe> groupes = this.session.createQuery("from Groupe").getResultList();
        for(Groupe g : groupes){
            logger.info("Group List::"+g);
        }
        return groupes;
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
	
	 
    private static SessionFactory getSessionFactory() {
        StandardServiceRegistry standardRegistry = 
        		new StandardServiceRegistryBuilder().
        				configure(Consts.HIBERNATE_CONFIG_FILE).build();
        Metadata metadata = 
        			new MetadataSources(standardRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = 
        		metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }
    
}
