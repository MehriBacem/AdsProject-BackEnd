package org.sid.AtsProject.dao;

import java.io.Serializable;
import java.util.List;

import org.sid.AtsProject.entities.Conversation;
import org.sid.AtsProject.entities.Membre;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageNormal;
import org.sid.AtsProject.entities.MessageOffre;

public interface IMessageDao extends Serializable{
	public MessageOffre addMessageOffre(MessageOffre m);
	public MessageNormal addMessageNormal(MessageNormal m);
	public void deleteMessage(Message m);
	public Message updateMessage(Message m);
	public List<Message> ListMessage();
	public List<MessageOffre> ListMessageOffre();
	public List<MessageNormal> ListMessageNormal();
	public List<MessageOffre> getAllPrestations() ;
	public List<MessageOffre> ListMessageOffreParDemande(long idDemande);
	public List<MessageNormal> ListMessageNormalParDemande(long idDemande);
	public boolean verifierConfirmation();
	public MessageOffre updateMessage(MessageOffre m);
    public Conversation addConversation(Conversation c);
	public Conversation getConversationId(int id);
	List getMessagebyConversation(long id);
}
