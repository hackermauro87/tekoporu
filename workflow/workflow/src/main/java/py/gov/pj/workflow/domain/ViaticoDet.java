package py.gov.pj.workflow.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the viatico_det database table.
 * 
 */
@Entity
@Table(name="viatico_det")
public class ViaticoDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIATICO_DET_VIADETID_GENERATOR", sequenceName="VIATICO_DET_VIA_DET_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIATICO_DET_VIADETID_GENERATOR")
	@Column(name="via_det_id")
	private Long viaDetId;

	//bi-directional many-to-one association to Charge
    @ManyToOne
	@JoinColumn(name="cha_id")
	private Charge charge;

	//bi-directional many-to-one association to Officer
    @ManyToOne
	@JoinColumn(name="off_id")
	private Officer officer;

	//bi-directional many-to-one association to Viatico
    @ManyToOne
	@JoinColumn(name="via_id")
	private Viatico viatico;

    public ViaticoDet() {
    }

	public Long getViaDetId() {
		return this.viaDetId;
	}

	public void setViaDetId(Long viaDetId) {
		this.viaDetId = viaDetId;
	}

	public Charge getCharge() {
		return this.charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	
	public Officer getOfficer() {
		return this.officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	
	public Viatico getViatico() {
		return this.viatico;
	}

	public void setViatico(Viatico viatico) {
		this.viatico = viatico;
	}
	
}