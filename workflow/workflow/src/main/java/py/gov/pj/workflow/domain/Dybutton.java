package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the dybutton database table.
 * 
 */
@Entity
public class Dybutton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DYBUTTON_DYBID_GENERATOR", sequenceName="DYBUTTON_DYB_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DYBUTTON_DYBID_GENERATOR")
	@Column(name="dyb_id")
	private Long dybId;

	@Column(name="dyb_del")
	private Integer dybDel;

	@Column(name="dyb_desc")
	private String dybDesc;

	@Column(name="dyb_label")
	private String dybLabel;

	@Column(name="dyb_type")
	private Integer dybType;

	//bi-directional many-to-one association to Buttonruteo
	@OneToMany(mappedBy="dybutton")
	private Set<Buttonruteo> buttonruteos;

    public Dybutton() {
    }

	public Long getDybId() {
		return this.dybId;
	}

	public void setDybId(Long dybId) {
		this.dybId = dybId;
	}

	public Integer getDybDel() {
		return this.dybDel;
	}

	public void setDybDel(Integer dybDel) {
		this.dybDel = dybDel;
	}

	public String getDybDesc() {
		return this.dybDesc;
	}

	public void setDybDesc(String dybDesc) {
		this.dybDesc = dybDesc;
	}

	public String getDybLabel() {
		return this.dybLabel;
	}

	public void setDybLabel(String dybLabel) {
		this.dybLabel = dybLabel;
	}

	public Integer getDybType() {
		return this.dybType;
	}

	public void setDybType(Integer dybType) {
		this.dybType = dybType;
	}

	public Set<Buttonruteo> getButtonruteos() {
		return this.buttonruteos;
	}

	public void setButtonruteos(Set<Buttonruteo> buttonruteos) {
		this.buttonruteos = buttonruteos;
	}

	
	
}