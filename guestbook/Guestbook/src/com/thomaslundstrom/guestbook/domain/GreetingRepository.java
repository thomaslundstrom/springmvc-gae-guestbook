package com.thomaslundstrom.guestbook.domain;

import java.util.Collection;

public interface GreetingRepository {
	public boolean doStuff();
	public void save(Greeting greeting);
	public Collection<Greeting> findAll();
	public Greeting get(long id);
}
