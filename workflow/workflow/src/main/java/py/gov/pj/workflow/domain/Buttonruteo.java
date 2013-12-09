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
 * The persistent class for the buttonruteo database table.
 * 
 */
@Entity
public class Buttonruteo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUTTONRUTEO_BUTTONRUTEOID_GENERATOR", sequenceName="BUTTONRUTEO_BUTTONRUTEO_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUTTONRUTEO_BUTTONRUTEOID_GENERATOR")
	@Column(name="buttonruteo_id")
	private Long buttonruteoId;

	@Column(name="buttonruteo_del")
	private Integer buttonruteoDel;

	//bi-directional many-to-one association to Dybutton
    @ManyToOne
	@JoinColumn(name="dyb_id")
	private Dybutton dybutton;

	//bi-directional many-to-one association to Routing
    @ManyToOne
	@JoinColumn(name="rou_id")
	private Routing routing;

    public Buttonruteo() {
    }

	public Long getButtonruteoId() {
		return this.buttonruteoId;
	}

	public void setButtonruteoId(Long buttonruteoId) {
		this.buttonruteoId = buttonruteoId;
	}

	public Integer getButtonruteoDel() {
		return this.buttonruteoDel;
	}

	public void setButtonruteoDel(Integer buttonruteoDel) {
		this.buttonruteoDel = buttonruteoDel;
	}

	public Dybutton getDybutton() {
		return this.dybutton;
	}

	public void setDybutton(Dybutton dybutton) {
		this.dybutton = dybutton;
	}
	
	public Routing getRouting() {
		return this.routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
	}
	
}