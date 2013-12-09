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
 * The persistent class for the routing database table.
 * 
 */
@Entity
public class Routing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROUTING_ROUID_GENERATOR", sequenceName="ROUTING_ROU_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROUTING_ROUID_GENERATOR")
	@Column(name="rou_id")
	private Long rouId;

	@Column(name="pos_destination")
	private Integer posDestination;

	@Column(name="pos_origin")
	private Integer posOrigin;

	@Column(name="rou_del")
	private Integer rouDel;

	@Column(name="rou_desc")
	private String rouDesc;

	//bi-directional many-to-one association to Buttonruteo
	@OneToMany(mappedBy="routing")
	private Set<Buttonruteo> buttonruteos;

	//bi-directional many-to-one association to Check
	@OneToMany(mappedBy="routing")
	private Set<Check> checks;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="routing")
	private Set<Notification> notifications;

    public Routing() {
    }

	public Long getRouId() {
		return this.rouId;
	}

	public void setRouId(Long rouId) {
		this.rouId = rouId;
	}

	public Integer getPosDestination() {
		return this.posDestination;
	}

	public void setPosDestination(Integer posDestination) {
		this.posDestination = posDestination;
	}

	public Integer getPosOrigin() {
		return this.posOrigin;
	}

	public void setPosOrigin(Integer posOrigin) {
		this.posOrigin = posOrigin;
	}

	public Integer getRouDel() {
		return this.rouDel;
	}

	public void setRouDel(Integer rouDel) {
		this.rouDel = rouDel;
	}

	public String getRouDesc() {
		return this.rouDesc;
	}

	public void setRouDesc(String rouDesc) {
		this.rouDesc = rouDesc;
	}

	public Set<Buttonruteo> getButtonruteos() {
		return this.buttonruteos;
	}

	public void setButtonruteos(Set<Buttonruteo> buttonruteos) {
		this.buttonruteos = buttonruteos;
	}
	
	public Set<Check> getChecks() {
		return this.checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}
	
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	
}