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


@Entity
public class Dependence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPENDENCE_DEPENID_GENERATOR", sequenceName="DEPENDENCE_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPENDENCE_DEPENID_GENERATOR")
	@Column(name="depen_id")
	private Long depenId;

	@Column(name="depen_del")
	private Integer depenDel;

	@Column(name="depen_desc")
	private String depenDesc;

	//bi-directional many-to-one association to Section
	@OneToMany(mappedBy="dependence")
	private Set<Section> sections;

	//bi-directional many-to-one association to Viatico
	@OneToMany(mappedBy="dependence")
	private Set<Viatico> viaticos;

    public Dependence() {
    }

	public Long getDepenId() {
		return this.depenId;
	}

	public void setDepenId(Long depenId) {
		this.depenId = depenId;
	}

	public Integer getDepenDel() {
		return this.depenDel;
	}

	public void setDepenDel(Integer depenDel) {
		this.depenDel = depenDel;
	}

	public String getDepenDesc() {
		return this.depenDesc;
	}

	public void setDepenDesc(String depenDesc) {
		this.depenDesc = depenDesc;
	}

	public Set<Section> getSections() {
		return this.sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	
	public Set<Viatico> getViaticos() {
		return this.viaticos;
	}

	public void setViaticos(Set<Viatico> viaticos) {
		this.viaticos = viaticos;
	}
	
}