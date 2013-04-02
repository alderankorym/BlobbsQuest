import processing.core.*;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Main extends PApplet
{
	//LOADING part 1
	PImage Ground;
	PImage Blobb;
	PImage Batte;
	PImage BatteIcone;
	//LOADING part 1

	boolean menu = false;
	int menuTab;
	
	boolean[] keys = new boolean[526];

	character[] perso = new character[50];
	
	
	
	public void setup()
	{
		smooth();
		frameRate(60);
		size(640,480);
		
		//LOADING part 2
		Ground = loadImage("testfield.png");
		Blobb = loadImage("blobb.png");
		Batte = loadImage("batte.png");
		BatteIcone = loadImage("batteIcone.png");
		//LOADING part 2
		
		//PJ CREATION
		perso[0] = new character(Blobb, 100, 100, 7, 200, 200);
		perso[1] = new character(Blobb, 100, 100, 7, 200, 200);
		
		perso[0].weapons = new weapon[50];
		perso[0].weapons[0] = new weapon(Batte, 70, 100, 5, 5, 5, 0);
		
	}
	
	public void draw()
	  {
		if(!menu)
		{
			//interaction
			if(checkKey(KeyEvent.VK_Z))
				perso[0].posY -= perso[0].speed;
			if(checkKey(KeyEvent.VK_S))
				perso[0].posY += perso[0].speed;
			if(checkKey(KeyEvent.VK_Q))
				perso[0].posX -= perso[0].speed;
			if(checkKey(KeyEvent.VK_D))
				perso[0].posX += perso[0].speed;
			if(checkKey(KeyEvent.VK_TAB))
				menu = !menu;
		
			//rendering
			image(Ground,0,0);
			drawCharacter(0);
		}
		else
		{

			if(checkKey(KeyEvent.VK_SPACE))
				menu = !menu;
			
			showMenu();
		}
		
	  }
	
	public void drawCharacter(int id)
	{
		//rotation calculation
		if(mouseY>perso[id].posY)
			perso[id].rotation = asin((perso[id].posX-mouseX) / (sqrt( sq(perso[id].posX-mouseX) + sq(perso[id].posY-mouseY) ) ));
		if(mouseY<perso[id].posY)
			perso[id].rotation =PI + asin((mouseX-perso[id].posX) / (sqrt( sq(mouseX-perso[id].posX) + sq(mouseY-perso[id].posY) ) ));
				
		//rendering
		
		pushMatrix();
		translate(perso[id].posX, perso[id].posY);
		rotate(perso[id].rotation);
		translate(-perso[id].Sprite.width/2, -perso[id].Sprite.height/2); //fucking magicks
		image(perso[id].Sprite,0,0);
		popMatrix();
		
		drawWeapon(id);
	}
	
	public void drawWeapon(int id)

	{
		pushMatrix();
		
		
		//translate(perso[id].posX+30, perso[id].posY);
		
		translate(perso[id].posX, perso[id].posY);
		rotate(perso[id].rotation);
		
		translate(perso[id].weapons[perso[id].weaponID].Sprite.width-185 ,perso[id].weapons[perso[id].weaponID].Sprite.height -5);
		image(perso[id].weapons[perso[id].weaponID].Sprite,0,0);
		popMatrix();
	}

	public void keyPressed()
	  {
		keys[keyCode] = true;
		
	  }
	
	public void keyReleased()
	{
		keys[keyCode] = false;
	}
	
	boolean checkKey(int k)
	{
		if(keys.length >= k)
		{
			return keys[k];
		}
		return false;
		
	}
	
}
