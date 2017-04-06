package hb.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import hb.hibernate.bean.Module;
 
public interface ModuleDAO {
 
    public void addModule(Module m);
    public void deleteModule(Module m);
    public List<Module> listModules();
    public Session openCurrentSessionWithTransaction();
    public void closeCurrentSessionwithTransaction();
    public Module findModuleByName(String name);
    public void updateModule(Module m);
}