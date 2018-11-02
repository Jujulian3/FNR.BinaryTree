package model;

public class Tree { 

	private Node root; 

	public Tree() {
		root = null;
	}

	public void addNode(int value) { 
		if(root == null) root = new Node(value);
		else add(root, value);
	}

	private void add(Node node, int value) {
		if(value < node.getValue()) {
			if(node.getLeft() != null) add(node.getLeft(), value);
			else node.setLeft(new Node(value));

		} else if (value > node.getValue()) {
			if(node.getRight() != null) add(node.getRight(), value);
			else node.setRight(new Node(value));
		}
	}

	public void removeNode(int value) 
	{ 
		root = remove(root, value); 
	} 

	private Node remove(Node node, int value) 
	{   
		if (node != null) {
			if(value < node.getValue()) node.setLeft(remove(node.getLeft(), value));
			else if(value > node.getValue()) node.setRight(remove(node.getRight(), value));
			else {

				if(node.getLeft() == null && node.getRight() == null) node = null;
				else if(node.getLeft() == null) node = node.getRight();
				else if(node.getRight() == null) node = node.getLeft();
				else {
					node.setValue(minValue(node.getRight()));
					node.setRight(remove(node.getRight(), minValue(node.getRight())));
				}
			}
		}
		return node;
	} 

	private int minValue(Node node) 
	{ 
		int value = node.getValue(); 
		while (node.getLeft() != null) 
		{ 
			value = node.getLeft().getValue(); 
			node = node.getLeft();
		} 
		return value; 
	} 

	public String showTree() {
		String result = "";		
		result = result + "Pré-ordem [RED]\n" + showRED(root).substring(0, showRED(root).length()-3);		
		result = result + "\nEm ordem [ERD]\n" + showERD(root).substring(0, showERD(root).length()-3);	
		result = result + "\nPós-ordem [EDR]\n" + showEDR(root).substring(0, showEDR(root).length()-3);		
		return result + "\n\n";
	}

	private String showRED(Node node) {
		String result = "";
		if(node != null) result = result + ((char) node.getValue()) + " - " + showRED(node.getLeft()) + showRED(node.getRight());
		return result;
	}

	private String showERD(Node node) {
		String result = "";
		if(node != null) result = result + showERD(node.getLeft()) + ((char) node.getValue()) + " - " + showERD(node.getRight());
		return result;
	}

	private String showEDR(Node node) {
		String result = "";
		if(node != null) result = result + showEDR(node.getLeft()) + showEDR(node.getRight()) + ((char) node.getValue()) + " - ";
		return result.replace(" -  - ", " - ");
	}
}