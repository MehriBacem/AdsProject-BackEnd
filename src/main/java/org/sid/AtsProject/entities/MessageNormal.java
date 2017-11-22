package org.sid.AtsProject.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@DiscriminatorValue("MN")
public class MessageNormal extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String   Contenu ;
	@JoinColumn(name="id_conversation")
	private Conversation conversation ;
		
	public MessageNormal() {
		super();
	}

	public MessageNormal(String type, boolean vu, boolean sensMessage, Membre membre, Demande demande,	String contenu,Conversation conversation) {
		super(type, vu, sensMessage, membre, demande,conversation);
		Contenu = contenu;
	}

	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
	

}
