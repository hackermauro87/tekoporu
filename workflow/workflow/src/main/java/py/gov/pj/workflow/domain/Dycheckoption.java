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
 * The persistent class for the dycheckoption database table.
 * 
 */
@Entity
public class Dycheckoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DYCHECKOPTION_DYCHKID_GENERATOR", sequenceName="DYCHECKOPTION_DYCHK_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DYCHECKOPTION_DYCHKID_GENERATOR")
	@Column(name="dychk_id")
	private Long dychkId;

	@Column(name="dychk_del")
	private Integer dychkDel;

	@Column(name="dychk_desc")
	private String dychkDesc;

	//bi-directional many-to-one association to Check
	@OneToMany(mappedBy="dycheckoption")
	private Set<Check> checks;

    public Dycheckoption() {
    }

	public Long getDychkId() {
		return this.dychkId;
	}

	public void setDychkId(Long dychkId) {
		this.dychkId = dychkId;
	}

	public Integer getDychkDel() {
		return this.dychkDel;
	}

	public void setDychkDel(Integer dychkDel) {
		this.dychkDel = dychkDel;
	}

	public String getDychkDesc() {
		return this.dychkDesc;
	}

	public void setDychkDesc(String dychkDesc) {
		this.dychkDesc = dychkDesc;
	}

	public Set<Check> getChecks() {
		return this.checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}
	
}