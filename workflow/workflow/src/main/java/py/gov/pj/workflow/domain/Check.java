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
 * The persistent class for the checks database table.
 * 
 */
@Entity
@Table(name="checks")
public class Check implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHECKS_CHKID_GENERATOR", sequenceName="CHECKS_CHK_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHECKS_CHKID_GENERATOR")
	@Column(name="chk_id")
	private Long chkId;

	@Column(name="chk_checked")
	private Boolean chkChecked;

	@Column(name="chk_del")
	private Integer chkDel;

	//bi-directional many-to-one association to Dycheckoption
    @ManyToOne
	@JoinColumn(name="dychk_id")
	private Dycheckoption dycheckoption;

	//bi-directional many-to-one association to Routing
    @ManyToOne
	@JoinColumn(name="rou_id")
	private Routing routing;

    public Check() {
    }

	public Long getChkId() {
		return this.chkId;
	}

	public void setChkId(Long chkId) {
		this.chkId = chkId;
	}

	public Boolean getChkChecked() {
		return this.chkChecked;
	}

	public void setChkChecked(Boolean chkChecked) {
		this.chkChecked = chkChecked;
	}

	public Integer getChkDel() {
		return this.chkDel;
	}

	public void setChkDel(Integer chkDel) {
		this.chkDel = chkDel;
	}

	public Dycheckoption getDycheckoption() {
		return this.dycheckoption;
	}

	public void setDycheckoption(Dycheckoption dycheckoption) {
		this.dycheckoption = dycheckoption;
	}
	
	public Routing getRouting() {
		return this.routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
	}
	
}