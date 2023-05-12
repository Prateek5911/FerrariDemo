import javax.swing.ImageIcon;

public class Car 
{
	private int xPos, yPos;
	private ImageIcon imgCar;
	private ImageIcon imgRed, imgYellow, imgGreen;
	private int panelHeight, panelWidth;

	public Car()
	{
		imgCar = new ImageIcon("car.png");	
		
		imgRed = new ImageIcon("red.jpg");
		imgYellow = new ImageIcon("yellow.jpg");
		imgGreen = new ImageIcon("green.jpg");
	}

	public void setFrame(int width, int height)
	{
		panelHeight = height;
		panelWidth = width;
		xPos = 0;
		yPos = 30;
	}

	public ImageIcon getImage()
	{
		return imgCar;
	}
	
	public ImageIcon getTrafficLight(int seconds)
	{
		ImageIcon img = imgGreen;
		
		if (seconds > 5)
		{
			img = imgGreen;
		}
		else if (seconds > 0)
		{
			img = imgYellow;
		}
		else if (seconds == 0)
		{
			img = imgRed;
		}
		
		return img;
	}

	private int getCarWidth()
	{
		return imgCar.getIconWidth();
	}

	private int getCarHeight()
	{
		return imgCar.getIconHeight();	
	}

	public void move()
	{
		xPos += 5;

		if (xPos > 900)
		{
			xPos = -getCarWidth();
		}
	}

	public void move(int pixels, int seconds)
	{
		if (seconds > 0)
		{
			xPos += pixels;

			if (xPos > 900)
			{
				xPos = -getCarWidth();
			}
		}
	}

	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}


}
