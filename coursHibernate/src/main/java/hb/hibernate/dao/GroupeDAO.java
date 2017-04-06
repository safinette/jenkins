package hb.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import hb.hibernate.bean.Groupe;
 
public interface GroupeDAO {
	public Session openCurrentSessionWithTransaction();
    public void closeCurrentSessionwithTransaction();
    public void addGroupe(Groupe g);
    public void deleteGroupe(Groupe groupe);
    public List<Groupe> listGroupes();
    public Groupe findGroupeByName(String name);
    public void updateGroupe(Groupe g);
}