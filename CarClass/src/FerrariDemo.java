import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FerrariDemo extends JPanel implements ActionListener 
{
	private Car ferrari;
	private Timer t;
	private final int WIDTH = 900;
	private final int HEIGHT = 100;
	private int seconds;
	private Font f;
	private Timer tClock;
	private int speed;
	
	
	public static void main(String[] args) 
	{new FerrariDemo();
	}
	public FerrariDemo()
	{
		ferrari = new Car();
		setLayout(null);
		setBackground(Color.WHITE);
		JFrame frame = new JFrame();
		frame.setContentPane(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Ferrari");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		// Set the timer and clock
		tClock = new Timer(1000, this); // 1000 milliseconds = 1 second
		f = new Font("Times New Roman", Font.PLAIN, 15);
		seconds = 10;
		speed = 5;
		ferrari.setFrame(getWidth(), getHeight());
		t = new Timer(5, this);
		t.start();
		tClock.start();
	}
	
	// Action Performed 
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == t)
		{
			ferrari.move(speed, seconds);
		}

		if (e.getSource() == tClock)
		{
			if (seconds > 0)
			{
				seconds--;
				speed += 5;
			}
		}
		
		// Draw again 
		repaint();
	}

	// Paint and draw the images 
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(ferrari.getTrafficLight(seconds).getImage(), 800, 0, this);
		g2.drawImage(ferrari.getImage().getImage(), ferrari.getX(), ferrari.getY(), this);

		g2.setFont(f);

		if (seconds > 0)
		{
			g2.drawString(Integer.toString(seconds), 450, 25);
		}
	}
}