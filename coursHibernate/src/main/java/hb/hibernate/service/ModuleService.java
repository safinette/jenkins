package hb.hibernate.service;

import java.util.List;

import hb.hibernate.bean.Module;


public interface ModuleService {
	
	 public void addModule(Module m);
	 public void deleteModule(Module m);
	 public List<Module> listModules();
	 public Module findModuleByName(String name);
	 public void updateModule(Module m);
}
