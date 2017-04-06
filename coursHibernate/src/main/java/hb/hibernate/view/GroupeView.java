package hb.hibernate.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hb.hibernate.bean.Groupe;

@ManagedBean
@ViewScoped
public class GroupeView implements Serializable {
	
	private static final long serialVersionUID = 7309429530141694842L;
	
	private Groupe groupe;
	
	@PostConstruct
	public void init(){
		groupe = new Groupe();
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
}
