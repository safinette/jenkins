package hb.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import hb.hibernate.bean.Trainee;
 
public interface TraineeDAO {
 
    public void addTrainee(Trainee trainee);
    public void deleteTrainee(Trainee trainee);
    public List<Trainee> listTrainees();
    public Session openCurrentSessionWithTransaction();
    public void closeCurrentSessionwithTransaction();
}