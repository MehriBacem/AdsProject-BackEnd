package org.sid.AtsProject.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;				
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@DiscriminatorValue("DM")
public class DemandeMateriel extends Demande {
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String NbJours;
	
	public DemandeMateriel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeMateriel(String intitule, String categorie, String message, String souscategorie, long budget,
			String lieu, Membre membre, String nbJours) {
		super(intitule, categorie, message, souscategorie, budget, lieu, membre);
		NbJours = nbJours;
	}

	public DemandeMateriel(String nbJours) {
		super();
		NbJours = nbJours;
	}

	public String getNbJours() {
		return NbJours;
	}
	public void setNbJours(String nbJours) {
		NbJours = nbJours;
	}
}
