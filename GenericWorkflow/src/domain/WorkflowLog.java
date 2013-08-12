package domain;

// Generated Aug 12, 2013 2:56:13 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GwWorkflowLog generated by hbm2java
 */
@Entity
@Table(name = "gw_workflow_log", catalog = "genericworkflow")
public class WorkflowLog implements java.io.Serializable {

	private Integer id;
	private NodeAction gwNodeAction;
	private String user;
	private String comments;
	private Date date;

	public WorkflowLog() {
	}

	public WorkflowLog(NodeAction gwNodeAction) {
		this.gwNodeAction = gwNodeAction;
	}

	public WorkflowLog(NodeAction gwNodeAction, String user,
			String comments, Date date) {
		this.gwNodeAction = gwNodeAction;
		this.user = user;
		this.comments = comments;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "node_action", nullable = false)
	public NodeAction getGwNodeAction() {
		return this.gwNodeAction;
	}

	public void setGwNodeAction(NodeAction gwNodeAction) {
		this.gwNodeAction = gwNodeAction;
	}

	@Column(name = "user", length = 45)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "comments", length = 65535)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}