package ee.itcollege.Valve.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the SEADUSE_PUNKT database table.
 * 
 */
@Entity
@Table(name="SEADUSE_PUNKT")
public class SeadusePunkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEADUSE_PUNKT_ID", unique=true, nullable=false)
	private int seadusePunktId;

	@Column(nullable=false, length=32)
	private String avaja;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date avatud;

	@Column(name="KEHTIV_ALATES", length=18)
	private String kehtivAlates;

	@Column(name="KEHTIV_KUNI", length=18)
	private String kehtivKuni;

	@Column(length=18)
	private String kommentaar;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date muudetud;

	@Column(nullable=false, length=32)
	private String muutja;

	@Column(length=18)
	private String pais;

	@Column(length=18)
	private String paragrahv;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date suletud;

	@Column(length=32)
	private String sulgeja;

	@Column(length=18)
	private String tekst;

	//bi-directional many-to-one association to IsikuSeadusIntsidendi
	@OneToMany(mappedBy="seadusePunkt")
	private Set<IsikuSeadusIntsidendi> isikuSeadusIntsidendis;

	//bi-directional many-to-one association to ObjektiSeadusIntsidendi
	@OneToMany(mappedBy="seadusePunkt")
	private Set<ObjektiSeadusIntsidendi> objektiSeadusIntsidendis;

	//bi-directional many-to-one association to PiirivalvuriSeadusIntsidendi
	@OneToMany(mappedBy="seadusePunkt")
	private Set<PiirivalvuriSeadusIntsidendi> piirivalvuriSeadusIntsidendis;

	//bi-directional many-to-one association to Seadus
    @ManyToOne
	@JoinColumn(name="SEADUSE_ID", nullable=false)
	private Seadus seadus;

	//bi-directional many-to-one association to SeadusePunkt
    @ManyToOne
	@JoinColumn(name="YLEMUS_SEADUSE_PUNKT_ID")
	private SeadusePunkt seadusePunkt;

	//bi-directional many-to-one association to SeadusePunkt
	@OneToMany(mappedBy="seadusePunkt")
	private Set<SeadusePunkt> seadusePunkts;

    public SeadusePunkt() {
    }

	public int getSeadusePunktId() {
		return this.seadusePunktId;
	}

	public void setSeadusePunktId(int seadusePunktId) {
		this.seadusePunktId = seadusePunktId;
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

	public String getKehtivAlates() {
		return this.kehtivAlates;
	}

	public void setKehtivAlates(String kehtivAlates) {
		this.kehtivAlates = kehtivAlates;
	}

	public String getKehtivKuni() {
		return this.kehtivKuni;
	}

	public void setKehtivKuni(String kehtivKuni) {
		this.kehtivKuni = kehtivKuni;
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

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getParagrahv() {
		return this.paragrahv;
	}

	public void setParagrahv(String paragrahv) {
		this.paragrahv = paragrahv;
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

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Set<IsikuSeadusIntsidendi> getIsikuSeadusIntsidendis() {
		return this.isikuSeadusIntsidendis;
	}

	public void setIsikuSeadusIntsidendis(Set<IsikuSeadusIntsidendi> isikuSeadusIntsidendis) {
		this.isikuSeadusIntsidendis = isikuSeadusIntsidendis;
	}
	
	public Set<ObjektiSeadusIntsidendi> getObjektiSeadusIntsidendis() {
		return this.objektiSeadusIntsidendis;
	}

	public void setObjektiSeadusIntsidendis(Set<ObjektiSeadusIntsidendi> objektiSeadusIntsidendis) {
		this.objektiSeadusIntsidendis = objektiSeadusIntsidendis;
	}
	
	public Set<PiirivalvuriSeadusIntsidendi> getPiirivalvuriSeadusIntsidendis() {
		return this.piirivalvuriSeadusIntsidendis;
	}

	public void setPiirivalvuriSeadusIntsidendis(Set<PiirivalvuriSeadusIntsidendi> piirivalvuriSeadusIntsidendis) {
		this.piirivalvuriSeadusIntsidendis = piirivalvuriSeadusIntsidendis;
	}
	
	public Seadus getSeadus() {
		return this.seadus;
	}

	public void setSeadus(Seadus seadus) {
		this.seadus = seadus;
	}
	
	public SeadusePunkt getSeadusePunkt() {
		return this.seadusePunkt;
	}

	public void setSeadusePunkt(SeadusePunkt seadusePunkt) {
		this.seadusePunkt = seadusePunkt;
	}
	
	public Set<SeadusePunkt> getSeadusePunkts() {
		return this.seadusePunkts;
	}

	public void setSeadusePunkts(Set<SeadusePunkt> seadusePunkts) {
		this.seadusePunkts = seadusePunkts;
	}
	
}