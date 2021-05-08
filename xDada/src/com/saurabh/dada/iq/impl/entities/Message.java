package com.saurabh.dada.iq.impl.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message implements Serializable, Comparable<Message> {

	private static final long serialVersionUID = 4640100589788055606L;
	private String messageText;
	private Long id;
	
	private Message() {
	}

	public Message(String messageText, Long id) {
		this();
		this.messageText = messageText;
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(Message o) {
		if (this.getId() > o.getId())
			return 1;
		else if (this.getId() < o.getId())
			return -1;
		else
			return 0;
	}
	
	public String toString(){
		return "Message:: [" + getId() + "," + getMessageText() + "]";
	}

}
