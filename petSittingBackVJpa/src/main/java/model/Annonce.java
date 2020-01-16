package model;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="annonce")
@SequenceGenerator(name="seqAnnonce",sequenceName="seq_annonce",initialValue=100,allocationSize=1) 
public class Annonce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAnnonce") 
	private int numA ;
	@Column(length=500,nullable=false)
	private String titre;
	@Column(length=1000,nullable=false)
	private String msg;
	@Column
	private double noteP;
	@Column
	private double noteS;
	@Column
	private double statut;
	@Column
//	@ManyToOne
//	@JoinColumn(name="room_id",foreignKey = @ForeignKey(name="person_room_id_fk"))
	private int numC;
//	@Column
	@Transient
	private List<Service> listService = new ArrayList();
//	private Set<Service> listService;
	@Version
	private int version;
	
	public Annonce() {
		
	}
	
	public Annonce(int numA, String titre, String msg, double noteP, double noteS, double statut, int numC,
			List<Service> listService) {
		super();
		this.numA = numA;
		this.titre = titre;
		this.msg = msg;
		this.noteP = noteP;
		this.noteS = noteS;
		this.statut = statut;
		this.numC = numC;
		this.listService = listService;
	}

	public int getNumA() {
		return numA;
	}

	public void setNumA(int numA) {
		this.numA = numA;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public double getNoteP() {
		return noteP;
	}

	public void setNoteP(double noteP) {
		this.noteP = noteP;
	}

	public double getNoteS() {
		return noteS;
	}

	public void setNoteS(double noteS) {
		this.noteS = noteS;
	}

	public double getStatut() {
		return statut;
	}

	public void setStatut(double statut) {
		this.statut = statut;
	}

	public int getNumC() {
		return numC;
	}

	public void setNumC(int numC) {
		this.numC = numC;
	}

	public List<Service> getListService() {
		return listService;
	}

	public void setListService(List<Service> listService) {
		this.listService = listService;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numA;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Annonce other = (Annonce) obj;
		if (numA != other.numA)
			return false;
		return true;
	}
	
	
	
}
