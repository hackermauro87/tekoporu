package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.sql.Time;
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
 * The persistent class for the document database table.
 * 
 */
@Entity
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENT_DOCID_GENERATOR", sequenceName="DOCUMENT_DOC_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENT_DOCID_GENERATOR")
	@Column(name="doc_id")
	private Long docId;

	@Column(name="doc_del")
	private Integer docDel;

    @Temporal( TemporalType.DATE)
	@Column(name="doc_fecha")
	private Date docFecha;

	@Column(name="doc_hora")
	private Time docHora;

	@Column(name="doc_state")
	private Integer docState;

	//bi-directional many-to-one association to Doccattached
	@OneToMany(mappedBy="document")
	private Set<Doccattached> doccattacheds;

	//bi-directional many-to-one association to Documenttype
    @ManyToOne
	@JoinColumn(name="doctype_id")
	private Documenttype documenttype;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="document")
	private Set<History> histories;

	//bi-directional many-to-one association to Viatico
	@OneToMany(mappedBy="document")
	private Set<Viatico> viaticos;

    public Document() {
    }

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Integer getDocDel() {
		return this.docDel;
	}

	public void setDocDel(Integer docDel) {
		this.docDel = docDel;
	}

	public Date getDocFecha() {
		return this.docFecha;
	}

	public void setDocFecha(Date docFecha) {
		this.docFecha = docFecha;
	}

	public Time getDocHora() {
		return this.docHora;
	}

	public void setDocHora(Time docHora) {
		this.docHora = docHora;
	}

	public Integer getDocState() {
		return this.docState;
	}

	public void setDocState(Integer docState) {
		this.docState = docState;
	}

	public Set<Doccattached> getDoccattacheds() {
		return this.doccattacheds;
	}

	public void setDoccattacheds(Set<Doccattached> doccattacheds) {
		this.doccattacheds = doccattacheds;
	}
	
	public Documenttype getDocumenttype() {
		return this.documenttype;
	}

	public void setDocumenttype(Documenttype documenttype) {
		this.documenttype = documenttype;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<History> getHistories() {
		return this.histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	
	public Set<Viatico> getViaticos() {
		return this.viaticos;
	}

	public void setViaticos(Set<Viatico> viaticos) {
		this.viaticos = viaticos;
	}
	
}