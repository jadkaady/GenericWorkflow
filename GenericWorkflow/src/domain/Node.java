package domain;

// Generated Aug 12, 2013 2:56:13 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * GwNode generated by hbm2java
 */
@Entity
@Table(name = "gw_node", catalog = "genericworkflow")
public class Node implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -289636178603899703L;
	private Integer id;
	private Workflow gwWorkflow;
	private Node gwNodeByPreviousNode;
	private Node gwNodeByNextNode;
	private String name;
	private String className;
	private Set<NodeAction> gwNodeActions = new HashSet<NodeAction>(0);
	private Set<Node> gwNodesForNextNode = new HashSet<Node>(0);
	private Set<Node> gwNodesForPreviousNode = new HashSet<Node>(0);

	public Node() {
	}

	public Node(Workflow gwWorkflow, String name) {
		this.gwWorkflow = gwWorkflow;
		this.name = name;
	}

	public Node(Workflow gwWorkflow, Node gwNodeByPreviousNode,
			Node gwNodeByNextNode, String name, String className,
			Set<NodeAction> gwNodeActions, Set<Node> gwNodesForNextNode,
			Set<Node> gwNodesForPreviousNode) {
		this.gwWorkflow = gwWorkflow;
		this.gwNodeByPreviousNode = gwNodeByPreviousNode;
		this.gwNodeByNextNode = gwNodeByNextNode;
		this.name = name;
		this.className = className;
		this.gwNodeActions = gwNodeActions;
		this.gwNodesForNextNode = gwNodesForNextNode;
		this.gwNodesForPreviousNode = gwNodesForPreviousNode;
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
	@JoinColumn(name = "workflow", nullable = false)
	public Workflow getGwWorkflow() {
		return this.gwWorkflow;
	}

	public void setGwWorkflow(Workflow gwWorkflow) {
		this.gwWorkflow = gwWorkflow;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "previous_node")
	public Node getGwNodeByPreviousNode() {
		return this.gwNodeByPreviousNode;
	}

	public void setGwNodeByPreviousNode(Node gwNodeByPreviousNode) {
		this.gwNodeByPreviousNode = gwNodeByPreviousNode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "next_node")
	public Node getGwNodeByNextNode() {
		return this.gwNodeByNextNode;
	}

	public void setGwNodeByNextNode(Node gwNodeByNextNode) {
		this.gwNodeByNextNode = gwNodeByNextNode;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "class_name", length = 45)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gwNode")
	public Set<NodeAction> getGwNodeActions() {
		return this.gwNodeActions;
	}

	public void setGwNodeActions(Set<NodeAction> gwNodeActions) {
		this.gwNodeActions = gwNodeActions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gwNodeByNextNode")
	public Set<Node> getGwNodesForNextNode() {
		return this.gwNodesForNextNode;
	}

	public void setGwNodesForNextNode(Set<Node> gwNodesForNextNode) {
		this.gwNodesForNextNode = gwNodesForNextNode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gwNodeByPreviousNode")
	public Set<Node> getGwNodesForPreviousNode() {
		return this.gwNodesForPreviousNode;
	}

	public void setGwNodesForPreviousNode(Set<Node> gwNodesForPreviousNode) {
		this.gwNodesForPreviousNode = gwNodesForPreviousNode;
	}

}
