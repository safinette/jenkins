package hb.hibernate.view;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hb.hibernate.bean.Address;
import hb.hibernate.bean.Groupe;
import hb.hibernate.bean.Trainee;
import hb.hibernate.service.AddressService;
import hb.hibernate.service.GroupeService;
import hb.hibernate.service.TraineeService;

@ManagedBean
@ViewScoped
public class TraineeView implements Serializable {
	
	private static final long serialVersionUID = 7309429530141694842L;
	
	private Trainee trainee;
	
	@ManagedProperty("#{groupeService}")
    private GroupeService groupeService;
	
	@ManagedProperty("#{traineeService}")
    private TraineeService traineeService;
	
	@ManagedProperty("#{addressService}")
    private AddressService addressService;
	
	private List<String> availableGroupes;
	
	private List<Groupe> groupes;
	
	private String selectedGroupe;
	
	@PostConstruct
	public void init(){
		availableGroupes = new ArrayList<String>();
		groupes = groupeService.listGroupes();
		for(Groupe g: groupes){
			availableGroupes.add(g.getName());
		}
		trainee = new Trainee();
		Address address = new Address();
		trainee.setAddress(address);
	}
	
	public void register(){
		System.out.println("[register] APPEL register "+trainee.getAddress());
		
		trainee.setGroupe(groupeService.findGroupeByName(selectedGroupe));
		System.out.println("[register] SG addresse avant create Address ");
		addressService.addAddress(trainee.getAddress());
		System.out.println("[register] SG addresse apres create Address ");
		traineeService.addTrainee(trainee);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Création du stagiaire ok", "");
    	FacesContext.getCurrentInstance().addMessage("Création ok", msg);
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public List<String> getAvailableGroupes() {
		return availableGroupes;
	}

	public String getSelectedGroupe() {
		return selectedGroupe;
	}

	public void setSelectedGroupe(String selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public void setTraineeService(TraineeService traineeService) {
		this.traineeService = traineeService;
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
}
