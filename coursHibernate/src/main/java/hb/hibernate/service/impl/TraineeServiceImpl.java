package hb.hibernate.service.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hb.hibernate.bean.Trainee;
import hb.hibernate.dao.TraineeDAO;
import hb.hibernate.dao.impl.TraineeDAOImpl;
import hb.hibernate.service.TraineeService;

@ManagedBean(name="traineeService")
@SessionScoped
public class TraineeServiceImpl implements TraineeService {

	private TraineeDAO traineeDAO = new TraineeDAOImpl();
	 
    public void addTrainee(Trainee t) {
    	System.out.println("TraineeService : add "+t);
    	traineeDAO.openCurrentSessionWithTransaction();
        this.traineeDAO.addTrainee(t);
        traineeDAO.closeCurrentSessionwithTransaction();
    }
    
	public void deleteTrainee(Trainee t) {
		traineeDAO.openCurrentSessionWithTransaction();
		this.traineeDAO.deleteTrainee(t);
		traineeDAO.closeCurrentSessionwithTransaction();
	}

    public List<Trainee> listTrainees() {
    	traineeDAO.openCurrentSessionWithTransaction();
        List<Trainee> trainees = this.traineeDAO.listTrainees();
    	traineeDAO.closeCurrentSessionwithTransaction();
    	return trainees;
    }
 
}
