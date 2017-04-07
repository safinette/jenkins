package hb.hibernate.bean;

import java.io.Serializable;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Groupe implements Serializable {
	
	private static final long serialVersionUID = 8487558235836890429L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	//SG	
	private String name;
	
	@OneToMany(mappedBy="groupe")
	private Set<Trainee> trainees;
	
	@ManyToMany
	@JoinTable(name = "groupe_module", 
		joinColumns = @JoinColumn(name = "idGroupe", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "idModule", referencedColumnName = "id"))
	private Set<Module> modules = new HashSet<Module>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}
	
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((trainees == null) ? 0 : trainees.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trainees == null) {
			if (other.trainees != null)
				return false;
		} else if (!trainees.equals(other.trainees))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
