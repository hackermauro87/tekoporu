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
 * The persistent class for the rol database table.
 * 
 */
@Entity
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_ROLID_GENERATOR", sequenceName="ROL_ROL_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_ROLID_GENERATOR")
	@Column(name="rol_id")
	private Long rolId;

	@Column(name="rol_del")
	private Integer rolDel;

	@Column(name="rol_desc")
	private String rolDesc;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="rol")
	private Set<User> users;

    public Rol() {
    }

	public Long getRolId() {
		return this.rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public Integer getRolDel() {
		return this.rolDel;
	}

	public void setRolDel(Integer rolDel) {
		this.rolDel = rolDel;
	}

	public String getRolDesc() {
		return this.rolDesc;
	}

	public void setRolDesc(String rolDesc) {
		this.rolDesc = rolDesc;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}