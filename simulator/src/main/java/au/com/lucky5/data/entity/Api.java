package au.com.lucky5.data.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Api {
	private long id;
	private String name;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
