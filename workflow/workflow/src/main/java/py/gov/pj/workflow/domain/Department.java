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
 * The persistent class for the department database table.
 * 
 */
@Entity
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTMENT_DEPID_GENERATOR", sequenceName="DEPARTMENT_PK_SEQ",initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENT_DEPID_GENERATOR")
	@Column(name="dep_id")
	private Long depId;

	@Column(name="dep_code")
	private String depCode;

	@Column(name="dep_del")
	private Integer depDel;

	@Column(name="dep_desc")
	private String depDesc;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="department")
	private Set<City> cities;

	//bi-directional many-to-one association to Viatico
	@OneToMany(mappedBy="department")
	private Set<Viatico> viaticos;

    public Department() {
    }

	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDepCode() {
		return this.depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public Integer getDepDel() {
		return this.depDel;
	}

	public void setDepDel(Integer depDel) {
		this.depDel = depDel;
	}

	public String getDepDesc() {
		return this.depDesc;
	}

	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}

	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	public Set<Viatico> getViaticos() {
		return this.viaticos;
	}

	public void setViaticos(Set<Viatico> viaticos) {
		this.viaticos = viaticos;
	}
	
}