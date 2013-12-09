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
import javax.persistence.Table;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_USERID_GENERATOR", sequenceName="USERS_USER_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_USERID_GENERATOR")
	@Column(name="user_id")
	private Long userId;

	@Column(name="user_del")
	private Integer userDel;

	@Column(name="user_nick")
	private String userNick;

	@Column(name="user_pwd")
	private String userPwd;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="user")
	private Set<Document> documents;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user")
	private Set<Notification> notifications;

	//bi-directional many-to-one association to Officer
    @ManyToOne
	@JoinColumn(name="off_id")
	private Officer officer;

	//bi-directional many-to-one association to Rol
    @ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;

    public User() {
    }

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getUserDel() {
		return this.userDel;
	}

	public void setUserDel(Integer userDel) {
		this.userDel = userDel;
	}

	public String getUserNick() {
		return this.userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Officer getOfficer() {
		return this.officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}