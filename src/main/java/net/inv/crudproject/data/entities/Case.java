package net.inv.crudproject.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
@Table(name = "cases")
public class Case 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CaseId")
	private long caseId;

	@Column(name = "creationDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "lastUpdateDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;
	@Column(name = "title")
	private String title;
	@Column(name = "description", length = 2056)
	private String description;
	public Case(Date creationDate, Date lastUpdateDate, String title, String description) {
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		this.title = title;
		this.description = description;
	}
	
}

