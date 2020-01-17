package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reponse")
public class Reponse {
	
	@EmbeddedId
	private ReponsePK key;
	@Column(name = "reponse", length =200 )
	private String reponse;
	
	
	
}
