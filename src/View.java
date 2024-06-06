import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Iterator;
class View extends JPanel
{
	Model model;
	Mario mario;
	static Image background = null;


	View(Controller c, Model m)
	{
	   model = m;
	  if (background == null)
	  {
	
	  	try
		{
			background= ImageIO.read(new File("nsync.jpg"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}

	  }
	  
	}


	public void paintComponent(Graphics g)

	{
		//screen
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//background
		g.drawImage(background,model.scrollPost/2,0,null);
		

		//ground
		g.setColor(new Color(11, 250, 60));
		g.fillRect(0, 596, 4000, 700);
		

		Iterator<Sprite> it = model.sprites.iterator();
		while(it.hasNext())
		{
			Sprite s = it.next();
			s.draw(g);
		}		



	}
	
	
}
