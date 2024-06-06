import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
class Mario extends Sprite
{
  String type = "Mario";
  int prevx;
  int prevy;
  int groundcount;
    
  static Image[] mario_images = null;
	Mario(Model m)
	{
    super(m);
    prevx=0;
    prevy=0;
    model = m;
    groundcount = 0;
    w = 60;
    h = 95;
    vert_vel = 0;

      if (mario_images == null)
    {
      mario_images = new Image[5];
      model = m;
      try
    {
      mario_images[0]= ImageIO.read(new File("mario1.png"));
      mario_images[1]= ImageIO.read(new File("mario2.png"));
      mario_images[2]= ImageIO.read(new File("mario3.png"));
      mario_images[3]= ImageIO.read(new File("mario4.png"));
      mario_images[4]= ImageIO.read(new File("mario5.png"));
    
  
    }
    catch(Exception e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }

    }
  }
  Mario(Json ob, Model m)
  {

    super(m);
    x = (int)ob.getLong("x");
    y = (int)ob.getLong("y");
    w = (int)ob.getLong("w");
    h = (int)ob.getLong("h");
    vert_vel= (double)ob.getLong("vert_vel");

      if (mario_images == null)
    {
      mario_images = new Image[5];
      model = m;
      try
    {
      mario_images[0]= ImageIO.read(new File("mario1.png"));
      mario_images[1]= ImageIO.read(new File("mario2.png"));
      mario_images[2]= ImageIO.read(new File("mario3.png"));
      mario_images[3]= ImageIO.read(new File("mario4.png"));
      mario_images[4]= ImageIO.read(new File("mario5.png"));
    
  
    }
    catch(Exception e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }

    }

  }
  
  Json marshal()
    {
   Json ob = Json.newObject();
     ob.add("type", type);
     ob.add("x", x);  
     ob.add("y", y);
     ob.add("w", w);
     ob.add("h", h);
     ob.add("vert_vel", vert_vel);
         return ob;
    }
    
 

	
	void remember_position()
	{  

		prevy = y;
		prevx = x;

	}
   
  void draw(Graphics g)
  {
     //mario
    int marioFrame =(Math.abs(model.mario.x)/15)%5;
    g.drawImage(mario_images[marioFrame], model.mario.x-model.scrollPost, model.mario.y, null);
    model.scrollPost++;

  }
  void get_out (Sprite b)
  {
	
        
      //coming from the left
    if (x + w > b.x && !(prevx + w > b.x))
    { 
      //set postion to the point where mario hits brick
      x = b.x - w;
      
    }
    //coming from the right 
    else if (x < b.x + b.w && !(prevx < b.x +b.w))
    {
      //set postion to the point where mario hits brick
       x = b.x + b.w;
       
    }
    //coming from the top
    else if (y + h > b.y && !(prevy + h > b.y))
    {
      //set postion to the point where mario hits brick
      y = b.y -h;
       
       //stop gravity when mario hits brick so he doesn't go through brick
       vert_vel = 0;
       groundcount = 0;
    }

    else if (y < b.y + b.h  && !(prevy < b.y + b.h))
    {
      //set postion to the point where mario hits brick
         y = b.y + b.h;
       //stop gravity when mario hits brick so he doesn't float before falling 
       vert_vel = 0;
    } 

    
  }
  boolean amMario()
    {
      return true;
    }

  void update()
  {

    model.scrollPost = x -50;
  	vert_vel += 2.8;  
  	y += vert_vel;
    //stop when mario hits ground
  	if (y>=500)
  	{
  		y = 500;
      vert_vel= 0;
      groundcount = 0;
  	}


  	Iterator<Sprite> it = model.sprites.iterator();
    while(it.hasNext())
  	{
  		Sprite s = it.next();
      if(s.amBrick())
      {
  		if(doesCollide(s))
          get_out(s);      
      }
      else if(s.amCoinBlock())
      { 
       if(doesCollide(s)){
        get_out(s);  
       }
      }
     

  	}
      

    groundcount ++ ;
  }
private Mario CoinBlocks(Sprite s) {
	// TODO Auto-generated method stub
	return null;
}


}