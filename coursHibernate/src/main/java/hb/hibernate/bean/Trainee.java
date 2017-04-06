package hb.hibernate.bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
 
@Entity
public class Trainee implements Serializable {
	private static final long serialVersionUID = 718481103965709910L;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String firstname;
    
    @OneToOne
    @JoinColumn(name = "idAddress",referencedColumnName = "id")
    private Address address;
    
    @ManyToOne
    @JoinColumn(name="idGroup")
    private Groupe groupe;
    
  
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
 
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", firstname=" + firstname + ", address=" + address
				+ ", groupe=" + groupe + "]";
	}
}