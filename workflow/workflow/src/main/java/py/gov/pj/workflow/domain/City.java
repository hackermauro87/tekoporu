package py.gov.pj.workflow.domain;

import java.io.Serializable;
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

@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CITY_CITID_GENERATOR", sequenceName="CITY_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CITY_CITID_GENERATOR")
	@Column(name="cit_id")
	private Long citId;

	@Column(name="cit_del")
	private Integer citDel;

	@Column(name="cit_desc")
	private String citDesc;

	//bi-directional many-to-one association to Department
    @ManyToOne
	@JoinColumn(name="dep_id")
	private Department department;

	//bi-directional many-to-one association to Locality
	@OneToMany(mappedBy="city")
	private Set<Locality> localities;

    public City() {
    }

	public Long getCitId() {
		return this.citId;
	}

	public void setCitId(Long citId) {
		this.citId = citId;
	}

	public Integer getCitDel() {
		return this.citDel;
	}

	public void setCitDel(Integer citDel) {
		this.citDel = citDel;
	}

	public String getCitDesc() {
		return this.citDesc;
	}

	public void setCitDesc(String citDesc) {
		this.citDesc = citDesc;
	}
	
	public Set<Locality> getLocalities() {
		return this.localities;
	}

	public void setLocalities(Set<Locality> localities) {
		this.localities = localities;
	}

	public void setDepartment(Department department) {

		this.department = department;
	}

	public Department getDepartment() {

		return department;
	}
	
}