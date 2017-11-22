package org.sid.AtsProject.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;				
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@DiscriminatorValue("DS")
public class DemandeService extends Demande {
	private static final long serialVersionUID = 1L;
	

	private long Typologie;
	
	
	public long getTypologie() {
		return Typologie;
	}
	public void setTypologie(long typologie) {
		Typologie = typologie;
	}

	public DemandeService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DemandeService(String intitule, String categorie, String message, String souscategorie, long budget,
			String lieu, Membre membre, long typologie) {
		super(intitule, categorie, message, souscategorie, budget, lieu, membre);
		Typologie = typologie;
	}
	public DemandeService(long typologie) {
		super();
		Typologie = typologie;
	}
	

	
	
	
}
