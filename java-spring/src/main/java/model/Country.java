package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {
	
	@Id
	private int id;
	
	@Column(name ="NAME", nullable = false)
    private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
