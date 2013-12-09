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
 * The persistent class for the documenttype database table.
 * 
 */
@Entity
public class Documenttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTTYPE_DOCTYPEID_GENERATOR", sequenceName="DOCUMENTTYPE_DOCTYPE_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTTYPE_DOCTYPEID_GENERATOR")
	@Column(name="doctype_id")
	private Long doctypeId;

	@Column(name="doctype_del")
	private Integer doctypeDel;

	@Column(name="doctype_desc")
	private String doctypeDesc;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="documenttype")
	private Set<Document> documents;

    public Documenttype() {
    }

	public Long getDoctypeId() {
		return this.doctypeId;
	}

	public void setDoctypeId(Long doctypeId) {
		this.doctypeId = doctypeId;
	}

	public Integer getDoctypeDel() {
		return this.doctypeDel;
	}

	public void setDoctypeDel(Integer doctypeDel) {
		this.doctypeDel = doctypeDel;
	}

	public String getDoctypeDesc() {
		return this.doctypeDesc;
	}

	public void setDoctypeDesc(String doctypeDesc) {
		this.doctypeDesc = doctypeDesc;
	}

	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	
}