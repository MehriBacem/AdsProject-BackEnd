package org.sid.AtsProject.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_DM",discriminatorType=DiscriminatorType.STRING,length=15)
public class Demande implements Serializable,Comparable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idDemande ;
	@NotEmpty
	private String intitule;
	private String categorie;
	private String message;
	private String souscategorie;
	private long budget;
	private String lieu;
	private String DateCreation ;
	@ManyToOne
	@JoinColumn(name="id_membre2") //cle étrangère
	private Membre membre;
	@OneToMany(mappedBy="demande")
	private List<Message>  messages ;
	@JsonIgnore
	@XmlTransient
	public List<Message> getMessages() {
		return messages;
	}
	
	public Demande(String intitule, String categorie, String message, String souscategorie, long budget, String lieu,
			Membre membre) {
		super();
		this.intitule = intitule;
		this.categorie = categorie;
		this.message = message;
		this.souscategorie=souscategorie;
		this.budget = budget;
		this.lieu = lieu;
		this.membre = membre;
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("'le' dd/MM/yyyy 'à' hh:mm:ss");
		this.setDateCreation(formater.format(aujourdhui));
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public long getIdDemande() {
		return idDemande;
	}
	public Demande() {
		super();
	}
	public void setIdDemande(long idDemande) {
		this.idDemande = idDemande;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public long getBudget() {
		return budget;
	}
	public void setBudget(long budget) {
		this.budget = budget;
	}

	public String getSouscategorie() {
		return souscategorie;
	}

	public void setSouscategorie(String souscategorie) {
		this.souscategorie = souscategorie;
	}

	@Override
    public int compareTo(Object comparestu) {
        long comparebud=((Demande)comparestu).getBudget();
        /* For Ascending order*/
        return (int)(this.budget-comparebud);
        
    }

	public String getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(String dateCreation) {
		DateCreation = dateCreation;
	}
	

}
