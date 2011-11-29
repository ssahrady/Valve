package ee.itcollege.Valve.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the RIIK database table.
 * 
 */
@Entity
@Table(name="RIIK")
public class Riik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RIIK_ID", unique=true, nullable=false)
	private int riikId;

	@Column(name="ANSI_KOOD", length=18)
	private String ansiKood;

	@Column(nullable=false, length=32)
	private String avaja;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date avatud;

	@Column(name="ISO_KOOD", nullable=false, length=20)
	private String isoKood;

	@Column(length=500)
	private String kommentaar;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date muudetud;

	@Column(nullable=false, length=32)
	private String muutja;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date suletud;

	@Column(length=32)
	private String sulgeja;

	//bi-directional many-to-one association to Kodakondsus
	@OneToMany(mappedBy="riik")
	private Set<Kodakondsus> kodakondsuses;

    public Riik() {
    }

	public int getRiikId() {
		return this.riikId;
	}

	public void setRiikId(int riikId) {
		this.riikId = riikId;
	}

	public String getAnsiKood() {
		return this.ansiKood;
	}

	public void setAnsiKood(String ansiKood) {
		this.ansiKood = ansiKood;
	}

	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getIsoKood() {
		return this.isoKood;
	}

	public void setIsoKood(String isoKood) {
		this.isoKood = isoKood;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Set<Kodakondsus> getKodakondsuses() {
		return this.kodakondsuses;
	}

	public void setKodakondsuses(Set<Kodakondsus> kodakondsuses) {
		this.kodakondsuses = kodakondsuses;
	}
	
}