package hb.hibernate.service;

import java.util.List;

import hb.hibernate.bean.Trainee;

public interface TraineeService {
 
    public void addTrainee(Trainee t);
    public void deleteTrainee(Trainee t);
    public List<Trainee> listTrainees();
     
}