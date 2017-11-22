package org.sid.AtsProject.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_DM",discriminatorType=DiscriminatorType.STRING,length=15)
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMessage ;
	@NotEmpty
	private String type;
	private boolean vu ;
	private boolean SensMessage ; 
	@ManyToOne
	@JoinColumn(name="id_membre3")
	private Membre membre;
	@ManyToOne
	@JoinColumn(name="id_demande")
	private Demande demande ;
	private String date ;
	@ManyToOne
	@JoinColumn(name="id_conversation")
	private Conversation conversation ;
	
	

	
	public Message(String type, boolean vu, boolean sensMessage, Membre membre, Demande demande,Conversation conversation) {
		super();
		this.conversation=conversation;
		this.type = type;
		this.vu = vu;
		this.SensMessage = sensMessage;
		this.membre = membre;
		this.demande = demande;
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("'le' dd/MM/yyyy 'à' hh:mm:ss");
		this.date =formater.format(aujourdhui);
	}
	public Membre getMembre() {
		return membre;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	public long getIdMessage() {
		return idMessage;
	}
	public Message() {
		super();
	}

	public boolean isSensMessage() {
		return SensMessage;
	}

	public void setSensMessage(boolean sensMessage) {
		SensMessage = sensMessage;
	}
	public boolean isVu() {
		return vu;
	}
	public void setVu(boolean vu) {
		this.vu = vu;
	}
	
}
