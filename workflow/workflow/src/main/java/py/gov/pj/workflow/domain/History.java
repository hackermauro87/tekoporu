package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HISTORY_HISID_GENERATOR", sequenceName="HISTORY_HIS_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORY_HISID_GENERATOR")
	@Column(name="his_id")
	private Long hisId;

    @Temporal( TemporalType.DATE)
	@Column(name="his_date")
	private Date hisDate;

	@Column(name="his_del")
	private Integer hisDel;

	@Column(name="his_desc")
	private String hisDesc;

	@Column(name="his_time")
	private Time hisTime;

	//bi-directional many-to-one association to Document
    @ManyToOne
	@JoinColumn(name="doc_id")
	private Document document;

    public History() {
    }

	public Long getHisId() {
		return this.hisId;
	}

	public void setHisId(Long hisId) {
		this.hisId = hisId;
	}

	public Date getHisDate() {
		return this.hisDate;
	}

	public void setHisDate(Date hisDate) {
		this.hisDate = hisDate;
	}

	public Integer getHisDel() {
		return this.hisDel;
	}

	public void setHisDel(Integer hisDel) {
		this.hisDel = hisDel;
	}

	public String getHisDesc() {
		return this.hisDesc;
	}

	public void setHisDesc(String hisDesc) {
		this.hisDesc = hisDesc;
	}

	public Time getHisTime() {
		return this.hisTime;
	}

	public void setHisTime(Time hisTime) {
		this.hisTime = hisTime;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
}