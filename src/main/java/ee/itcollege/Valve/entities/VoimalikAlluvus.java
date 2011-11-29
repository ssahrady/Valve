package ee.itcollege.Valve.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the VOIMALIK_ALLUVUS database table.
 * 
 */
@Entity
@Table(name="VOIMALIK_ALLUVUS")
public class VoimalikAlluvus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VOIMALIK_ALLUVUS_ID", unique=true, nullable=false)
	private int voimalikAlluvusId;

	@Column(nullable=false, length=32)
	private String avaja;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date avatud;

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

	//bi-directional many-to-one association to RiigiAdminYksuseLiik
    @ManyToOne
	@JoinColumn(name="VOIMALIK_ALLUV_LIIK_ID", nullable=false)
	private RiigiAdminYksuseLiik riigiAdminYksuseLiik1;

	//bi-directional many-to-one association to RiigiAdminYksuseLiik
    @ManyToOne
	@JoinColumn(name="RIIGI_ADMIN_YKSUSE_LIK_ID", nullable=false)
	private RiigiAdminYksuseLiik riigiAdminYksuseLiik2;

    public VoimalikAlluvus() {
    }

	public int getVoimalikAlluvusId() {
		return this.voimalikAlluvusId;
	}

	public void setVoimalikAlluvusId(int voimalikAlluvusId) {
		this.voimalikAlluvusId = voimalikAlluvusId;
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

	public RiigiAdminYksuseLiik getRiigiAdminYksuseLiik1() {
		return this.riigiAdminYksuseLiik1;
	}

	public void setRiigiAdminYksuseLiik1(RiigiAdminYksuseLiik riigiAdminYksuseLiik1) {
		this.riigiAdminYksuseLiik1 = riigiAdminYksuseLiik1;
	}
	
	public RiigiAdminYksuseLiik getRiigiAdminYksuseLiik2() {
		return this.riigiAdminYksuseLiik2;
	}

	public void setRiigiAdminYksuseLiik2(RiigiAdminYksuseLiik riigiAdminYksuseLiik2) {
		this.riigiAdminYksuseLiik2 = riigiAdminYksuseLiik2;
	}
	
}