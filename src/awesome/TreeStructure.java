package awesome;

import java.util.ArrayList;
/**
 * 
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 * @version 1.0
 */
public class TreeStructure<Element> {
	/**
	 * The parent node of the tree.
	 */
	TreeStructure<Element> parent;
	/**
	 * The children of this node in the tree.
	 */
	ArrayList<TreeStructure<Element>> children;
	
	/**
	 * The datastructure which holds the current state of the board
	 */
	Element element;
	
	/**
	 * 
	 * @param parent The parent node of this node.
	 */
	public TreeStructure(TreeStructure<Element> parent, Element element){
		setParent(parent);
		setElement(element);
		this.children = new ArrayList<TreeStructure<Element>>();
	}
	
	public void addChild(TreeStructure<Element> child){
		this.children.add(child);
		child.setParent(this);
	}

	/**
	 * @return the parent
	 */
	public TreeStructure<Element> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeStructure<Element> parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public ArrayList<TreeStructure<Element>> getChildren() {
		return children;
	}

	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}

	/**
	 * @param children the children to set
	 */
	private void setChildren(ArrayList<TreeStructure<Element>> children) {
		this.children = children;
	}
	
	
	

	
	
}
