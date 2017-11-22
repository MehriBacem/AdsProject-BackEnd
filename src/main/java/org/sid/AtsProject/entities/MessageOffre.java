package org.sid.AtsProject.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@DiscriminatorValue("MO")
public class MessageOffre extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float prix ;
    private Boolean isConfirmed ;
	
	

	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public MessageOffre() {
		super();
		this.setIsConfirmed(false);
	}
	
	public MessageOffre(String type, boolean vu, boolean sensMessage, Membre membre, Demande demande, float prix,
			Boolean isValide,Conversation conversation) {
		super(type, vu, sensMessage, membre, demande,conversation);
		this.prix = prix;
		this.isConfirmed = isValide;
	}
	

	@JsonIgnore
	public Boolean getIsConfirmed() {
		return isConfirmed;
	}
	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
	
	
	

}
