package helloworld;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HelloGraphics extends JPanel implements ActionListener {
	private Timer timy;
	private int prog = 0;
	public HelloGraphics() {
		timy = new Timer(50, this);
		timy.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/*		g.drawString("Hello", 50, 50);
		setBackground(Color.WHITE);
		g.fillRect(100, 100, 100, 100);
 		g.fillOval(130, 130, 50, 60);
		g.drawArc(30, 200, 40, 50, 90, 60);
		g.fillArc(30, 130, 40, 50, 180, 40);
		g.drawOval(30, 130, 50, 60);*/
		setForeground(Color.RED);
		
		g.drawOval(40, (int) (100 - ( Math.cos(prog * Math.PI / 180) + 1 ) * 15 ), 80, (int) ( (Math.cos(prog * Math.PI / 180) + 1 ) * 30) );
		g.drawOval(200, (int) (100 - ( Math.cos(prog * Math.PI / 180) + 1 ) * 15 ), 80, (int) ( (Math.cos(prog * Math.PI / 180) + 1 ) * 30) );
		g.fillOval(60, 80, 40, 40);
		g.fillOval(220, 80, 40, 40);
		g.drawOval(150, 100, 20, 60);
		g.drawOval(130, 200, 60, 100);
		
	} 

	public static void main(String[] args) {
		HelloGraphics m = new HelloGraphics();
		JFrame f = new JFrame();
		f.add(m);
		f.setSize(400, 400);
		// f.setLayout(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		prog = prog + 5;
		repaint();
/*		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			//createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		paint(g);
		g.dispose();
		bs.show();*/
	}

}
