package bonnie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int size = 100;
		JFrame frame= new JFrame();
		Grid g = new Grid(size, size);
		GridPanel gp = new GridPanel(g);
		frame.getContentPane().add(gp);
		frame.setTitle("All praise the holy Bonnie");
		
		//System.out.println((55.12f % (2 * 0.1f) - 0.1f));
		//toEvolve + r.nextFloat() % (2 *distance) - distance;
		
//		g.getValue(25, 25).setGerm(new Germ(0f, 1, 1.5f));
//		g.getValue(75, 25).setGerm(new Germ(0.3f, 2, 1.5f));
//		g.getValue(25, 75).setGerm(new Germ(0.6f, 0.5f, 1.5f));
//		g.getValue(75, 75).setGerm(new Germ(0.8f, 1.5f, 1.5f));
		
		g.getValue(25, 50).setGerm(new Germ(0.7f, 0.6f, 0.8f, 0f));
		g.getValue(75, 50).setGerm(new Germ(0.7f, 1.2f, 0.8f, 0.6f));
		
//		g.getValue(25, 50).setGerm(new Germ(0f, 1, 1.5f, 0.6f));
//		g.getValue(75, 50).setGerm(new Germ(0.5f, 1, 1.5f, 1.2f));
		
		frame.setSize(900, 900);
		frame.setLocation(500, 50);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.nextTurn();
				gp.update();
				//System.out.println("next");
			}
		});
		gp.update();
		timer.setInitialDelay(500);
		timer.start(); 
	}
}
