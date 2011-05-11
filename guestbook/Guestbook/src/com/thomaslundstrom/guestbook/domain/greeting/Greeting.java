package com.thomaslundstrom.guestbook.domain.greeting;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

import java.io.Serializable;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Greeting implements Serializable /* needs serializable to be able to put in a cache */ {
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 237498273498L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private User author;

    @Persistent
    private String content;

    @Persistent
    private Date date;

    public Greeting(User author, String content, Date date) {
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public Key getKey() {
        return key;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}