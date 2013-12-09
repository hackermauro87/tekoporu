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


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTIFICATION_NOTID_GENERATOR", sequenceName="NOTIFICATION_NOT_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTIFICATION_NOTID_GENERATOR")
	@Column(name="not_id")
	private Long notId;

	@Column(name="not_del")
	private Integer notDel;

	@Column(name="not_desc")
	private String notDesc;

	//bi-directional many-to-one association to Routing
    @ManyToOne
	@JoinColumn(name="rou_id")
	private Routing routing;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="user_id")
	private User user;

    public Notification() {
    }

	public Long getNotId() {
		return this.notId;
	}

	public void setNotId(Long notId) {
		this.notId = notId;
	}

	public Integer getNotDel() {
		return this.notDel;
	}

	public void setNotDel(Integer notDel) {
		this.notDel = notDel;
	}

	public String getNotDesc() {
		return this.notDesc;
	}

	public void setNotDesc(String notDesc) {
		this.notDesc = notDesc;
	}

	public Routing getRouting() {
		return this.routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}