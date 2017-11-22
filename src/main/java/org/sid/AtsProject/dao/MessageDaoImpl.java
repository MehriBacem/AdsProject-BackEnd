package org.sid.AtsProject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.AtsProject.entities.Conversation;
import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageNormal;
import org.sid.AtsProject.entities.MessageOffre;

public class MessageDaoImpl implements IMessageDao{
	public MessageDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceContext
	 private EntityManager em ;

	@Override
	public MessageOffre addMessageOffre(MessageOffre m) {
		em.persist(m);
		return m ;
	}
	@Override
	public void deleteMessage(Message m) {

		em.remove(m);
	
	}
	@Override
	public Message updateMessage(Message m) {
		em.merge(m);
		return m;
	}
	@Override
	public List<Message> ListMessage() {
		Query req=em.createQuery("select m from Message m") ;
		return req.getResultList();
	}
	@Override
	public List<MessageOffre> ListMessageOffre() {
Query req=em.createQuery("select m from Message m where m.type=:x") ;
req.setParameter("x","MessageOffre");
		return req.getResultList();	
		}
	@Override
	public List<MessageNormal> ListMessageNormal() {
		Query req=em.createQuery("select m from Message m where m.type=:x") ;
		req.setParameter("x","MessageNormal");
				return req.getResultList();	}
	@Override
	public List<MessageOffre> ListMessageOffreParDemande(long idDemande) {
		
			Query req=em.createQuery("select m from MessageOffre  m where m.demande.idDemande=:x") ;
			req.setParameter("x","idDemande");
					return req.getResultList();	
					
	}
	@Override
	public List<MessageNormal> ListMessageNormalParDemande(long idDemande) {
		Query req=em.createQuery("select m from MessageNormal m where m.demande.idDemande=:x") ;
		req.setParameter("x","idDemande");
				return req.getResultList();	
	}
	@Override
	public MessageNormal addMessageNormal(MessageNormal f) {
		em.persist(f);
		return f;
	}
	@Override
	public boolean verifierConfirmation() {
		Long count = (Long) em.createQuery("select count(*) from MessageOffre m where m.isConfirmed:=true").getSingleResult();	
		System.out.println(count);
		boolean reponse =count.equals(1) ;
		return reponse;
	}
	@Override
	public MessageOffre updateMessage(MessageOffre m) {
		if(verifierConfirmation()==true)
		em.merge(m);
		return m;
		
	}
	  public Conversation addConversation(Conversation c){
		  em.persist(c);
			return c ;
	  }
	public Conversation  getConversationId(int id){
			Conversation d=em.find(Conversation.class, id);
			if(d==null) {
				throw new RuntimeException("element introuvable") ;
			}
			return d;		
		
	}
	@Override
	public List getMessagebyConversation(long id) {
		javax.persistence.Query req=em.createQuery("select d from Message d where d.conversation.idConv=:x");
		req.setParameter("x",id);
		return req.getResultList();
	}
	@Override
	public List<MessageOffre> getAllPrestations() {
		List<MessageOffre> l=ListMessageOffre();
		ArrayList<MessageOffre> lpres=new ArrayList<MessageOffre>();
		for (MessageOffre mo : l){
			if(mo.getIsConfirmed()){
				lpres.add((MessageOffre)(mo));
			}
		}
		return (List<MessageOffre>)lpres;
	}

}
