package com.hind.stars.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Star {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStar;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nameStar;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Integer age;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateDiscovered;
	
	@ManyToOne
	private Type type;
	
	public Star() {
		super();
	}
	
	public Star (String nameStar, Integer age, Date dateDiscovered) {
		super();
		this.nameStar = nameStar;
		this.age = age;
		this.dateDiscovered = dateDiscovered;
	}
	
	public Long getIdStar() {
		return idStar;
	}
	
	public void setIdStar(Long idStar) {
		this.idStar = idStar;
	}
	
	public String getNameStar() {
		return nameStar;
	}
	
	public void setNameStar(String nameStar) {
		this.nameStar= nameStar;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getDateDiscovered() {
		return dateDiscovered;
	}
	
	public void setDateDiscovered(Date dateDiscovered) {
		this.dateDiscovered = dateDiscovered;
	}
	
	@Override
	public String toString() {
	return "Star [idStar=" + idStar + ", nameStar=" +
	nameStar + ", ageStar=" + age
	+ ", dateDiscovered=" + dateDiscovered + "]";
	}
}
