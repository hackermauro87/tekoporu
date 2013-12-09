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
 * The persistent class for the charge database table.
 * 
 */
@Entity
public class Charge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHARGE_CHAID_GENERATOR", sequenceName="CHARGE_CHA_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHARGE_CHAID_GENERATOR")
	@Column(name="cha_id")
	private Long chaId;

	@Column(name="cha_del")
	private Integer chaDel;

	@Column(name="cha_desc")
	private String chaDesc;

	//bi-directional many-to-one association to Officer
	@OneToMany(mappedBy="charge")
	private Set<Officer> officers;

	//bi-directional many-to-one association to ViaticoDet
	@OneToMany(mappedBy="charge")
	private Set<ViaticoDet> viaticoDets;

    public Charge() {
    }

	public Long getChaId() {
		return this.chaId;
	}

	public void setChaId(Long chaId) {
		this.chaId = chaId;
	}

	public Integer getChaDel() {
		return this.chaDel;
	}

	public void setChaDel(Integer chaDel) {
		this.chaDel = chaDel;
	}

	public String getChaDesc() {
		return this.chaDesc;
	}

	public void setChaDesc(String chaDesc) {
		this.chaDesc = chaDesc;
	}

	public Set<Officer> getOfficers() {
		return this.officers;
	}

	public void setOfficers(Set<Officer> officers) {
		this.officers = officers;
	}
	
	public Set<ViaticoDet> getViaticoDets() {
		return this.viaticoDets;
	}

	public void setViaticoDets(Set<ViaticoDet> viaticoDets) {
		this.viaticoDets = viaticoDets;
	}
	
}