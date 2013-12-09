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
 * The persistent class for the doccattached database table.
 * 
 */
@Entity
public class Doccattached implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCCATTACHED_DOCCAID_GENERATOR", sequenceName="DOCCATTACHED_DOCCA_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCCATTACHED_DOCCAID_GENERATOR")
	@Column(name="docca_id")
	private Long doccaId;

	@Column(name="docca_del")
	private Integer doccaDel;

	@Column(name="docca_desc")
	private String doccaDesc;

	@Column(name="docca_url")
	private String doccaUrl;

	//bi-directional many-to-one association to Document
    @ManyToOne
	@JoinColumn(name="doc_id")
	private Document document;

    public Doccattached() {
    }

	public Long getDoccaId() {
		return this.doccaId;
	}

	public void setDoccaId(Long doccaId) {
		this.doccaId = doccaId;
	}

	public Integer getDoccaDel() {
		return this.doccaDel;
	}

	public void setDoccaDel(Integer doccaDel) {
		this.doccaDel = doccaDel;
	}

	public String getDoccaDesc() {
		return this.doccaDesc;
	}

	public void setDoccaDesc(String doccaDesc) {
		this.doccaDesc = doccaDesc;
	}

	public String getDoccaUrl() {
		return this.doccaUrl;
	}

	public void setDoccaUrl(String doccaUrl) {
		this.doccaUrl = doccaUrl;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
}