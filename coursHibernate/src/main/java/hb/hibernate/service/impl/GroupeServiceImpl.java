package hb.hibernate.service.impl;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hb.hibernate.bean.Groupe;
import hb.hibernate.dao.GroupeDAO;
import hb.hibernate.dao.impl.GroupeDAOImpl;
import hb.hibernate.service.GroupeService;

@ManagedBean(name="groupeService")
@SessionScoped
public class GroupeServiceImpl implements GroupeService {

	private GroupeDAO groupeDAO = new GroupeDAOImpl();
	 
    public void addGroupe(Groupe g) {
    	groupeDAO.openCurrentSessionWithTransaction();
        this.groupeDAO.addGroupe(g);
        groupeDAO.closeCurrentSessionwithTransaction();
    }
	public void deleteGroupe(Groupe g) {
		groupeDAO.openCurrentSessionWithTransaction();
		this.groupeDAO.deleteGroupe(g);
		groupeDAO.closeCurrentSessionwithTransaction();
	}
    public Groupe findGroupeByName(String name){
    	groupeDAO.openCurrentSessionWithTransaction();
    	Groupe g = groupeDAO.findGroupeByName(name);
    	groupeDAO.closeCurrentSessionwithTransaction();
    	return g;
    }
    public void updateGroupe(Groupe g){
    	groupeDAO.openCurrentSessionWithTransaction();
    	groupeDAO.updateGroupe(g);
    	groupeDAO.closeCurrentSessionwithTransaction();
    }
    public List<Groupe> listGroupes() {
    	groupeDAO.openCurrentSessionWithTransaction();
        List<Groupe> groupes =  this.groupeDAO.listGroupes();
        groupeDAO.closeCurrentSessionwithTransaction();
        return groupes;
    } 
}
