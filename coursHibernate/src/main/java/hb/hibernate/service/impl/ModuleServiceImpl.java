package hb.hibernate.service.impl;

import java.util.List;






import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import hb.hibernate.bean.Module;
import hb.hibernate.dao.ModuleDAO;
import hb.hibernate.dao.impl.ModuleDAOImpl;
import hb.hibernate.service.ModuleService;

@ManagedBean(name="moduleService")
@SessionScoped
public class ModuleServiceImpl implements ModuleService {
	
	private ModuleDAO moduleDAO = new ModuleDAOImpl();
	
	public void addModule(Module m) {
		moduleDAO.openCurrentSessionWithTransaction();
		this.moduleDAO.addModule(m);
		moduleDAO.closeCurrentSessionwithTransaction();
	}

	public void deleteModule(Module m) {
		moduleDAO.openCurrentSessionWithTransaction();
		this.moduleDAO.deleteModule(m);
		moduleDAO.closeCurrentSessionwithTransaction();
	}

	public List<Module> listModules() {
		moduleDAO.openCurrentSessionWithTransaction();
		List<Module> modules =  this.moduleDAO.listModules();
		moduleDAO.closeCurrentSessionwithTransaction();
		return modules;
	}
	
	public Module findModuleByName(String name){
		moduleDAO.openCurrentSessionWithTransaction();
		Module m = moduleDAO.findModuleByName(name);
		moduleDAO.closeCurrentSessionwithTransaction();
		return m;
	}
	
	public void updateModule(Module m){
		moduleDAO.openCurrentSessionWithTransaction();
		moduleDAO.updateModule(m);
		moduleDAO.closeCurrentSessionwithTransaction();
	}
}
