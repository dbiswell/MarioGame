import java.util.ArrayList;
import java.awt.Graphics;

class Model
{
	int scrollPost;
	ArrayList<Sprite> sprites;
	Mario mario;


	Model()
	{
		mario = new Mario(this);
		sprites = new ArrayList<Sprite>();
		sprites.add(mario);
		
	}
 	void remember_position()
 	{
 		mario.remember_position();
 	}
	public void update()
	{
		for(int i = 0; i < sprites.size(); i++)
		{
			Sprite s = sprites.get(i);
			s.update();
		}
	}

	void addBrick(int x, int y, int w, int h)
	{
		Sprite s = new Brick(x, y, w, h, this);
		sprites.add(s);
	}


	void addCoinBlocks(int x, int y)
	{
		Sprite s = new CoinBlocks(x, y, this);
		sprites.add(s);
	}
	 void addCoin(int x, int y)
	{
	Sprite s = new Coin(x, y,this);
	sprites.add(s);
	}

	void unmarshal(Json ob)
	{
		 Sprite mario2 = mario;
         sprites.clear();
         sprites.add(mario2);
		 Json json_sprites = ob.get("sprites");
		 for (int i = 0; i < json_sprites.size(); i++)
		 {
			 Json j = json_sprites.get(i);
			 String s = j.getString("type");
			 	if(s.equals("Mario"))
			 	{  

			 		// Mario m = new Mario(j, this);
			 		// sprites.add(m);
			 		// // mario = m;
			 	}
			     if(s.equals("Brick")) {
			 		Brick b = new Brick(j, this);
			 		sprites.add(b);
			 	}

			 	if (s.equals("CoinBlocks")) {
			 		CoinBlocks c = new CoinBlocks(j, this);
			 		sprites.add(c);
			 	}
			 	
			
		 }
	}


	Json marshal()
	{
		Json ob = Json.newObject();
		Json json_sprites = Json.newList();
		ob.add("sprites", json_sprites);
		for(int i = 0; i < sprites.size(); i++)
		{
			Sprite s = sprites.get(i);
			Json j = s.marshal();
			json_sprites.add(j);
		}
    
        return ob;
	}
	void save(String filename)
	{
		Json ob = marshal();
		ob.save(filename);
	}
	void load(String filename)
	{
		Json ob = Json.load(filename);
		unmarshal(ob);	
	} 
	}
