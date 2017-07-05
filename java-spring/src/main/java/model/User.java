package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	private int id;
	
	@Column(name ="FIRSTNAME", nullable = false)
    private String firstName;
	
	@Column(name ="LASTNAME", nullable = false)
    private String lastName;
	
	@Column(name ="EMAIL", nullable = false)
    private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERCOUNTRYMAPPING", 
         joinColumns = @JoinColumn(name = "USERID"),
         inverseJoinColumns = @JoinColumn(name = "COUNTRYID"))
	Set<Country> countries = new HashSet<Country>(0);
    
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Set<Country> getCountries() {
		return countries;
	}
}
