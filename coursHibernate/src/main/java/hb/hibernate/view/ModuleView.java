package hb.hibernate.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hb.hibernate.bean.Module;

@ManagedBean
@ViewScoped
public class ModuleView implements Serializable {
	
	private static final long serialVersionUID = 7309429530141694842L;
	
	private Module module;
	
	@PostConstruct
	public void init(){
		module = new Module();
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
