package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the officer database table.
 * 
 */
@Entity
public class Officer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFICER_OFFID_GENERATOR", sequenceName="OFFICER_OFF_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFICER_OFFID_GENERATOR")
	@Column(name="off_id")
	private Long offId;

	@Column(name="off_address")
	private String offAddress;

	@Column(name="off_ci")
	private Integer offCi;

	@Column(name="off_del")
	private Integer offDel;

	@Column(name="off_email")
	private String offEmail;

    @Temporal( TemporalType.DATE)
	@Column(name="off_fechanac")
	private Date offFechanac;

	@Column(name="off_lastname")
	private String offLastname;

	@Column(name="off_name")
	private String offName;

	@Column(name="off_phone")
	private String offPhone;

	//bi-directional many-to-one association to Section
    @ManyToOne
	@JoinColumn(name="sec_id")
	private Section section;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="officer")
	private Set<User> users;

	//bi-directional many-to-one association to Charge
    @ManyToOne
	@JoinColumn(name="cha_id")
	private Charge charge;

	//bi-directional many-to-one association to ViaticoDet
	@OneToMany(mappedBy="officer")
	private Set<ViaticoDet> viaticoDets;

    public Officer() {
    }

	public Long getOffId() {
		return this.offId;
	}

	public void setOffId(Long offId) {
		this.offId = offId;
	}

	public String getOffAddress() {
		return this.offAddress;
	}

	public void setOffAddress(String offAddress) {
		this.offAddress = offAddress;
	}

	public Integer getOffCi() {
		return this.offCi;
	}

	public void setOffCi(Integer offCi) {
		this.offCi = offCi;
	}

	public Integer getOffDel() {
		return this.offDel;
	}

	public void setOffDel(Integer offDel) {
		this.offDel = offDel;
	}

	public String getOffEmail() {
		return this.offEmail;
	}

	public void setOffEmail(String offEmail) {
		this.offEmail = offEmail;
	}

	public Date getOffFechanac() {
		return this.offFechanac;
	}

	public void setOffFechanac(Date offFechanac) {
		this.offFechanac = offFechanac;
	}

	public String getOffLastname() {
		return this.offLastname;
	}

	public void setOffLastname(String offLastname) {
		this.offLastname = offLastname;
	}

	public String getOffName() {
		return this.offName;
	}

	public void setOffName(String offName) {
		this.offName = offName;
	}

	public String getOffPhone() {
		return this.offPhone;
	}

	public void setOffPhone(String offPhone) {
		this.offPhone = offPhone;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Charge getCharge() {
		return this.charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	
	public Set<ViaticoDet> getViaticoDets() {
		return this.viaticoDets;
	}

	public void setViaticoDets(Set<ViaticoDet> viaticoDets) {
		this.viaticoDets = viaticoDets;
	}
	
}