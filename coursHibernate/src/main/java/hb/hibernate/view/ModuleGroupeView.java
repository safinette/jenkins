package hb.hibernate.view;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import hb.hibernate.bean.Groupe;
import hb.hibernate.bean.Module;
import hb.hibernate.service.GroupeService;
import hb.hibernate.service.ModuleService;
 
@ManagedBean
public class ModuleGroupeView {
	
	@ManagedProperty("#{groupeService}")
    private GroupeService groupeService;
	
	@ManagedProperty("#{moduleService}")
    private ModuleService moduleService;
     
    private List<String> availableGroupes;    
    
	private String selectedGroupe;
	
	private List<String> checkedModules;
	
    private List<String> availableModules;
 
    @PostConstruct
    public void init() {
    	//Groupes in DB
    	List<Groupe> groupesDB = groupeService.listGroupes();
    	List<Module> modulesDB = moduleService.listModules();
    	
    	availableGroupes = new ArrayList<String>();
    	availableModules = new ArrayList<String>();
    	
    	System.out.println("[ModuleGroupeView][init] size groupesDB : "+groupesDB.size());
    	System.out.println("[ModuleGroupeView][init] size modulesDB : "+modulesDB.size());
    	
    	for(Groupe groupe : groupesDB){
    		availableGroupes.add(groupe.getName());
    	}
    	for(Module m: modulesDB){
    		availableModules.add(m.getName());
    	}
    }
    
    public void addModulesToGroupe(){
    	Groupe groupe = groupeService.findGroupeByName(selectedGroupe);
    	System.out.println("[addModulesToGroup] selectedGroupe :"+selectedGroupe);
    	Set<Module> modulesOfSelectedGroup = new HashSet<Module>();
    	
    	for(String s:checkedModules){
    		Module module = moduleService.findModuleByName(s);
    		modulesOfSelectedGroup.add(module);
    	}
    	System.out.println("[addModulesToGroup] modulesOfSelectedGroup :"+modulesOfSelectedGroup.size());
    	groupe.setModules(modulesOfSelectedGroup);
    	groupeService.updateGroupe(groupe);
    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Affectation des modules au groupe ok", "");
    	FacesContext.getCurrentInstance().addMessage("Affectation ok", msg);
    }
    
	public String getSelectedGroupe() {
		return selectedGroupe;
	}

	public void setSelectedGroupe(String selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}

	public List<String> getAvailableGroupes() {
		return availableGroupes;
	}

	public void setAvailableGroupes(List<String> availableGroupes) {
		this.availableGroupes = availableGroupes;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public List<String> getCheckedModules() {
		return checkedModules;
	}

	public void setCheckedModules(List<String> checkedModules) {
		this.checkedModules = checkedModules;
	}

	public List<String> getAvailableModules() {
		return availableModules;
	}

	public void setAvailableModules(List<String> availableModules) {
		this.availableModules = availableModules;
	}
}
