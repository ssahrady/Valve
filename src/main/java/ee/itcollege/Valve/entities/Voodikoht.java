package ee.itcollege.Valve.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the VOODIKOHT database table.
 * 
 */
@Entity
@Table(name="VOODIKOHT")
public class Voodikoht implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VOODIKOHT_ID", unique=true, nullable=false)
	private int voodikohtId;

	@Column(nullable=false, length=32)
	private String avaja;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date avatud;

	@Column(length=500)
	private String kommentaar;

	private int laius;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date muudetud;

	@Column(nullable=false, length=32)
	private String muutja;

	@Column(length=20)
	private String number;

	private int pikkus;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date suletud;

	@Column(length=32)
	private String sulgeja;

	//bi-directional many-to-one association to PiirivalvurVodikohal
	@OneToMany(mappedBy="voodikoht")
	private Set<PiirivalvurVodikohal> piirivalvurVodikohals;

	//bi-directional many-to-one association to Ruumiyksus
    @ManyToOne
	@JoinColumn(name="RUUMIYKSUS_ID", nullable=false)
	private Ruumiyksus ruumiyksus;

    public Voodikoht() {
    }

	public int getVoodikohtId() {
		return this.voodikohtId;
	}

	public void setVoodikohtId(int voodikohtId) {
		this.voodikohtId = voodikohtId;
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

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public int getLaius() {
		return this.laius;
	}

	public void setLaius(int laius) {
		this.laius = laius;
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

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPikkus() {
		return this.pikkus;
	}

	public void setPikkus(int pikkus) {
		this.pikkus = pikkus;
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

	public Set<PiirivalvurVodikohal> getPiirivalvurVodikohals() {
		return this.piirivalvurVodikohals;
	}

	public void setPiirivalvurVodikohals(Set<PiirivalvurVodikohal> piirivalvurVodikohals) {
		this.piirivalvurVodikohals = piirivalvurVodikohals;
	}
	
	public Ruumiyksus getRuumiyksus() {
		return this.ruumiyksus;
	}

	public void setRuumiyksus(Ruumiyksus ruumiyksus) {
		this.ruumiyksus = ruumiyksus;
	}
	
}