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
 * The persistent class for the doc_access database table.
 * 
 */
@Entity
@Table(name="doc_access")
public class DocAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOC_ACCESS_ACCID_GENERATOR", sequenceName="DOC_ACCESS_PK_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOC_ACCESS_ACCID_GENERATOR")
	@Column(name="acc_id")
	private Long accId;

	//bi-directional many-to-one association to Document
    @ManyToOne
	@JoinColumn(name="doc_id")
	private Document document;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="user_id")
	private User user;

    public DocAccess() {
    }

	public Long getAccId() {
		return this.accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}