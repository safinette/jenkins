package hb.hibernate.service;

import java.util.List;

import hb.hibernate.bean.Groupe;

public interface GroupeService {
    public void addGroupe(Groupe g);
    public void deleteGroupe(Groupe g);
    public List<Groupe> listGroupes();
    public Groupe findGroupeByName(String name);
    public void updateGroupe(Groupe g);  
}