package org.sid.AtsProject.Services;

import java.util.List;

import org.sid.AtsProject.entities.Conversation;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageNormal;
import org.sid.AtsProject.entities.MessageOffre;
import org.sid.AtsProject.metier.IMessageMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceMessage {

	ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
	IMessageMetier MessageMetier= ( IMessageMetier) app.getBean("MessageMetier");
	
	public ServiceMessage() {
		super();
		
	}
	@RequestMapping(value="/MessageNormal",method=RequestMethod.POST, headers="Accept=application/json")
	public  MessageNormal AjouterMessageNormal(@RequestBody MessageNormal dm){
		MessageMetier.addMessageNormal(dm);
		return dm ;
	}
	@RequestMapping(value="/MessageOffre",method=RequestMethod.POST, headers="Accept=application/json")
	public  MessageOffre AjouterMessageOffre(@RequestBody MessageOffre dm){
		MessageMetier.addMessageOffre(dm);
		return dm ;
	}
	
	@RequestMapping(value="/ConfirmerOffre",method=RequestMethod.PUT, headers="Accept=application/json")
	public  String ConfirmerOffre(@RequestBody MessageOffre dm){
		dm.setIsConfirmed(true);
		MessageOffre ms = MessageMetier.updateMessage(dm);
		if (ms.equals(dm))	{
			return "No Confirmation" ;
		}
		else
		return "Success" ;
	}
	@RequestMapping(value="/Messages",method=RequestMethod.GET, headers="Accept=application/json")
	public List<Message> listMessages(){
		return MessageMetier.ListMessage();
	}
	@RequestMapping(value="/MessagesNormals",method=RequestMethod.GET, headers="Accept=application/json")
	public List<MessageNormal> listmessagesNormals(){
		return MessageMetier.ListMessageNormal();
	}
	@RequestMapping(value="/MessageOffres",method=RequestMethod.GET, headers="Accept=application/json")
	public List<MessageOffre> listMessagesOffres(){
		return MessageMetier.ListMessageOffre();
	}
	@RequestMapping(value="/Conversation",method=RequestMethod.POST, headers="Accept=application/json")
	public  Conversation AjouterConversation(@RequestBody Conversation dm){
		MessageMetier.addConversation(dm);
		return dm ;
	}
	@RequestMapping(value="/Conversation/{id}",method=RequestMethod.GET, headers="Accept=application/json")
	public  List MsgsConveration(@PathVariable int id){
		
		return MessageMetier.getMessagebyConversation(id);
	}
	

}
