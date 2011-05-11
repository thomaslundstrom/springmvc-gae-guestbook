package com.thomaslundstrom.guestbook.persistence.appengine;

import java.util.Collection;

import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.thomaslundstrom.guestbook.domain.greeting.Greeting;

@Repository
public class JdoGreetingRepository implements
		com.thomaslundstrom.guestbook.domain.greeting.GreetingRepository {

	JdoTemplate jdoTemplate;
	
	@Autowired
	public JdoGreetingRepository(PersistenceManagerFactory pmf) {
		this.jdoTemplate = new JdoTemplate(pmf);
	}
	
	@Override
	public boolean doStuff() {
		return true;
	}

	@Override
	public void save(Greeting greeting) {
		jdoTemplate.makePersistent(greeting);		
	}
	
	@Override
	public Greeting get(long id) {
		Key key = KeyFactory.createKey(Greeting.class.getSimpleName(), id);
		Greeting greeting = jdoTemplate.getObjectById(Greeting.class, key);
		
		return greeting;
	}


	@Override
	public Collection<Greeting> findAll() {
		
		Collection<Greeting> greetings = jdoTemplate.find(Greeting.class);
//		System.out.println("greetings count:" + greetings.size());
		
		return greetings;
	}

}
