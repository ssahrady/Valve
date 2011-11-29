package ee.itcollege.Valve.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the PIIRIRIKKUJA database table.
 * 
 */
@Entity
@Table(name="PIIRIRIKKUJA")
public class Piiririkkuja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PIIRIRIKKUJA_ID", unique=true, nullable=false)
	private int piiririkkujaId;

	@Column(nullable=false, length=32)
	private String avaja;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date avatud;

	@Column(length=25)
	private String eesnimi;

	@Column(length=20)
	private String isikukood;

	@Column(length=500)
	private String kommentaar;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date muudetud;

	@Column(nullable=false, length=32)
	private String muutja;

	@Column(name="PEREK_NIMI", length=35)
	private String perekNimi;

	@Column(length=1)
	private String sugu;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date suletud;

	@Column(length=32)
	private String sulgeja;

    @Temporal( TemporalType.DATE)
	private Date synniaeg;

	//bi-directional many-to-one association to IsikIntsidendi
	@OneToMany(mappedBy="piiririkkuja")
	private Set<IsikIntsidendi> isikIntsidendis;

	//bi-directional many-to-one association to Kodakondsus
	@OneToMany(mappedBy="piiririkkuja")
	private Set<Kodakondsus> kodakondsuses;

	//bi-directional many-to-one association to Objekt
    @ManyToOne
	@JoinColumn(name="OBJEKT_ID", nullable=false)
	private Objekt objekt;

    public Piiririkkuja() {
    }

	public int getPiiririkkujaId() {
		return this.piiririkkujaId;
	}

	public void setPiiririkkujaId(int piiririkkujaId) {
		this.piiririkkujaId = piiririkkujaId;
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

	public String getEesnimi() {
		return this.eesnimi;
	}

	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
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

	public String getPerekNimi() {
		return this.perekNimi;
	}

	public void setPerekNimi(String perekNimi) {
		this.perekNimi = perekNimi;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
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

	public Date getSynniaeg() {
		return this.synniaeg;
	}

	public void setSynniaeg(Date synniaeg) {
		this.synniaeg = synniaeg;
	}

	public Set<IsikIntsidendi> getIsikIntsidendis() {
		return this.isikIntsidendis;
	}

	public void setIsikIntsidendis(Set<IsikIntsidendi> isikIntsidendis) {
		this.isikIntsidendis = isikIntsidendis;
	}
	
	public Set<Kodakondsus> getKodakondsuses() {
		return this.kodakondsuses;
	}

	public void setKodakondsuses(Set<Kodakondsus> kodakondsuses) {
		this.kodakondsuses = kodakondsuses;
	}
	
	public Objekt getObjekt() {
		return this.objekt;
	}

	public void setObjekt(Objekt objekt) {
		this.objekt = objekt;
	}
	
}