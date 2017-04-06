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

import hb.hibernate.bean.Module;
import hb.hibernate.dao.ModuleDAO;
import hb.hibernate.utils.Consts;


public class ModuleDAOImpl implements ModuleDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(
												ModuleDAOImpl.class);
	 
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
 
    public void addModule(Module m) {
        this.session.save(m);
        this.session.flush();
        logger.info("Module saved successfully, Module Details="+m);
    }
    
    public void deleteModule(Module m) {
    	 this.session.delete(m);
    	 this.session.flush();
    	 logger.info("Module deleted successfully, Module Details="+m);
	}
    
    @SuppressWarnings("unchecked")
    public List<Module> listModules() {
        List<Module> modules = this.session.createQuery("from Module").getResultList();
        for(Module m: modules){
            logger.info("Module List::"+m);
        }
        return modules;
    }
    
  	public Module findModuleByName(String name) {
  		String queryString = "FROM Module m WHERE m.name = :name";
  		Query query = this.session.createQuery(queryString);
  		query.setParameter("name", name);
  		return (Module) query.getSingleResult();
  	}
  	
  	public void updateModule(Module m) {
		this.session.update(m);
	}
}
