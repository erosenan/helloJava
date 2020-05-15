package bonnie;

import java.awt.Color;

import javax.swing.JPanel;

public class NodePanel extends JPanel {
	Node node;
	
	public NodePanel(Node current){
		this.node = current;
		//System.out.println("node panel for (" + node.getX() + ", " + node.getY() + ") set");
	}
	
	public void update(){
		setBackground(node.isAlive() ? Color.getHSBColor(node.getGerm().getSpecies(), Util.bonnie(node.getEnergy() / 10), node.getGerm().isHibernating()? 0.3f : 0.7f) : Color.white);
	}
}
