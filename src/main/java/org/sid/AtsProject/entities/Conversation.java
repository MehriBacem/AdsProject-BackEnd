package org.sid.AtsProject.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conversation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idConv ;
	
	@OneToMany(mappedBy="conversation")
	private List<Message>  messages ;
	public Conversation() {
		super();
		
	}
	
	public long getIdConv() {
		return idConv;
	}
	public void setIdConv(long idConv) {
		this.idConv = idConv;
	}
	@JsonIgnore
	@XmlTransient
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	
}
