package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the viatico database table.
 * 
 */
@Entity
public class Viatico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIATICO_VIAID_GENERATOR", sequenceName="VIATICO_PK_SEQ",initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIATICO_VIAID_GENERATOR")
	@Column(name="via_id")
	private Long viaId;

    @Temporal( TemporalType.DATE)
	@Column(name="via_dateoutput")
	private Date viaDateoutput;

    @Temporal( TemporalType.DATE)
	@Column(name="via_datereturn")
	private Date viaDatereturn;

	@Column(name="via_del")
	private Integer viaDel;

	@Column(name="via_fuel")
	private Boolean viaFuel;

	@Column(name="via_km_rec")
	private double viaKmRec;

	@Column(name="via_travel_reason")
	private String viaTravelReason;

	@Column(name="via_vehicle")
	private Boolean viaVehicle;

	//bi-directional many-to-one association to Department
    @ManyToOne
	@JoinColumn(name="dep_id")
	private Department department;

	//bi-directional many-to-one association to Document
    @ManyToOne
	@JoinColumn(name="doc_id")
	private Document document;

	//bi-directional many-to-one association to ViaticoDet
	@OneToMany(mappedBy="viatico")
	private Set<ViaticoDet> viaticoDets;

	//bi-directional many-to-one association to Dependence
    @ManyToOne
	@JoinColumn(name="depen_id")
	private Dependence dependence;

    public Viatico() {
    }

	public Long getViaId() {
		return this.viaId;
	}

	public void setViaId(Long viaId) {
		this.viaId = viaId;
	}

	public Date getViaDateoutput() {
		return this.viaDateoutput;
	}

	public void setViaDateoutput(Date viaDateoutput) {
		this.viaDateoutput = viaDateoutput;
	}

	public Date getViaDatereturn() {
		return this.viaDatereturn;
	}

	public void setViaDatereturn(Date viaDatereturn) {
		this.viaDatereturn = viaDatereturn;
	}

	public Integer getViaDel() {
		return this.viaDel;
	}

	public void setViaDel(Integer viaDel) {
		this.viaDel = viaDel;
	}

	public Boolean getViaFuel() {
		return this.viaFuel;
	}

	public void setViaFuel(Boolean viaFuel) {
		this.viaFuel = viaFuel;
	}

	public double getViaKmRec() {
		return this.viaKmRec;
	}

	public void setViaKmRec(double viaKmRec) {
		this.viaKmRec = viaKmRec;
	}

	public String getViaTravelReason() {
		return this.viaTravelReason;
	}

	public void setViaTravelReason(String viaTravelReason) {
		this.viaTravelReason = viaTravelReason;
	}

	public Boolean getViaVehicle() {
		return this.viaVehicle;
	}

	public void setViaVehicle(Boolean viaVehicle) {
		this.viaVehicle = viaVehicle;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Set<ViaticoDet> getViaticoDets() {
		return this.viaticoDets;
	}

	public void setViaticoDets(Set<ViaticoDet> viaticoDets) {
		this.viaticoDets = viaticoDets;
	}
	
	public Dependence getDependence() {
		return this.dependence;
	}

	public void setDependence(Dependence dependence) {
		this.dependence = dependence;
	}
	
}