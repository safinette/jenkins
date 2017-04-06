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

import hb.hibernate.bean.Trainee;
import hb.hibernate.dao.TraineeDAO;
import hb.hibernate.utils.Consts;

public class TraineeDAOImpl implements TraineeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(
												TraineeDAOImpl.class);
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
     
    public void addTrainee(Trainee t) {
        this.session.save(t);
        this.session.flush();
        logger.info("Trainee saved successfully, Trainee Details="+t);
    }
    
    public void deleteTrainee(Trainee trainee) {
    	 this.session.delete(trainee);
    	 this.session.flush();
    	 logger.info("Trainee deleted successfully, Trainee Details="+trainee);
	}
    
    @SuppressWarnings("unchecked")
    public List<Trainee> listTrainees() {
        List<Trainee> trainees = this.session.createQuery("from Trainee").getResultList();
        for(Trainee t : trainees){
            logger.info("Trainee List::"+t);
        }
        return trainees;
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
