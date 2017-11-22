package org.sid.AtsProject.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Membre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idMembre ;
	@NotEmpty
	private String prenom ;
	@JsonIgnore
	@XmlTransient
	public List<Demande> getDemandes() {
		return demandes;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	private String addresse ;
	private String ville ;
	private String email ;
	private String tel ;
	private String msgpresentation;
	@OneToMany(mappedBy="membre")
	private List<Demande> demandes;
	
	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Membre(String prenom, String addresse, String ville, String email, String tel, String msgpresentation) {
		super();
		this.prenom = prenom;
		this.addresse = addresse;
		this.ville = ville;
		this.email = email;
		this.tel = tel;
		this.msgpresentation = msgpresentation;
		
	}

	public long getIdMembre() {
		return idMembre;
	}
	public void setIdMembre(long idMembre) {
		this.idMembre = idMembre;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getMsgpresentation() {
		return msgpresentation;
	}
	public void setMsgpresentation(String msgpresentation) {
		this.msgpresentation = msgpresentation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	

}
