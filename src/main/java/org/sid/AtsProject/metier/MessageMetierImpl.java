package org.sid.AtsProject.metier;

import java.util.List;

import org.sid.AtsProject.dao.IDemandeDao;
import org.sid.AtsProject.dao.IMessageDao;
import org.sid.AtsProject.entities.Conversation;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageNormal;
import org.sid.AtsProject.entities.MessageOffre;
import org.springframework.transaction.annotation.Transactional;
@Transactional(rollbackFor=Exception.class)
public class MessageMetierImpl implements IMessageMetier {

	private  IMessageDao dao ;
	
	
	public MessageMetierImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IMessageDao getDao() {
		return dao;
	}

	public void setDao(IMessageDao dao) {
		this.dao = dao;
	}

	@Override
	public MessageOffre addMessageOffre(MessageOffre m) {
		// TODO Auto-generated method stub
		return dao.addMessageOffre(m);
	}

	@Override
	public void deleteMessage(Message m) {
		// TODO Auto-generated method stub
		dao.deleteMessage(m);
	}

	@Override
	public Message updateMessage(Message m) {
		// TODO Auto-generated method stub
		return dao.updateMessage(m);
	}

	@Override
	public List<Message> ListMessage() {
		// TODO Auto-generated method stub
		return dao.ListMessage();
	}

	@Override
	public List<MessageOffre> ListMessageOffre() {
		// TODO Auto-generated method stub
		return dao.ListMessageOffre();
	}

	@Override
	public List<MessageNormal> ListMessageNormal() {
		// TODO Auto-generated method stub
		return dao.ListMessageNormal();
	}

	@Override
	public List<MessageOffre> ListMessageOffreParDemande(long idDemande) {
		// TODO Auto-generated method stub
		return dao.ListMessageOffreParDemande(idDemande);
	}

	@Override
	public List<MessageNormal> ListMessageNormalParDemande(long idDemande) {
		// TODO Auto-generated method stub
		return dao.ListMessageNormalParDemande(idDemande);
	}

	@Override
	public MessageNormal addMessageNormal(MessageNormal m) {
		
		return dao.addMessageNormal(m);
	}
	@Override
	public List<MessageOffre> getAllPrestations() {
		return dao.getAllPrestations();
	}
	@Override
	public boolean verifierConfirmation(MessageOffre m) {
		// TODO Auto-generated method stub
		return dao.verifierConfirmation();
	}

	@Override
	public MessageOffre updateMessage(MessageOffre m) {
		
		return dao.updateMessage(m);
	}
	public Conversation addConversation(Conversation c){
		return dao.addConversation(c);
	}
	public Conversation getConversationId(int id){
		return dao.getConversationId(id);
	}
	
	public List getMessagebyConversation(long id) {
	return dao.getMessagebyConversation(id);	
	}
	
}
