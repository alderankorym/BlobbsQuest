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

	public void showMenu()
	{
		background(0);
		stroke(255);
		strokeWeight(2);
		fill(0);
		//menu gauche
		rect(2,0,120,60,6,6,6,6);
		rect(2,60,120,60,6,6,6,6);
		rect(2,120,120,60,6,6,6,6);
		rect(2,180,120,60,6,6,6,6);
		rect(2,240,120,60,6,6,6,6);
		//cadre droite
		rect(124,0,516,300,6,6,6,6);
		//cadre bas
		rect(0,300,640,180,6,6,6,6);
		//textes menu gauche
		fill(255);
		text("EQUIPEMENT",10,35);
		text("OBJETS",10,95);
		text("STATS",10,155);
		text("PLOP4",10,215);
		text("PLOP5",10,275);
		

		
		switch(menuTab)
		{
			case 1 :
			showMenuEquip();
				break;
			case 2 :
			showMenu2();
				break;
			case 3 :
			showMenuStats();
				break;
			case 4 :
			
				break;
			case 5 :
			
				break;
			default :
				break;
		}
	}
	
	public void showMenuEquip()
	{
		fill(0);
		rect(124,0,60,60,6,6,6,6);
		image(BatteIcone,130,5);
		
	}
	
	public void showMenu2()
	{
		
	}
	
	public void showMenuStats()
	{
		text("HP/LIFE  " + perso[0].hp + "  /  " + perso[0].life, 130, 35);
		text("MP/MANA  " + perso[0].mp + "  /  " + perso[0].mana, 130, 95);
	}
	
	
	public void mousePressed()
	{
		if(menu)
		{
			//menu gauche
			if(mouseX<120 && mouseY<60)
				menuTab = 1;
			if(mouseX<120 && mouseY>60 && mouseY<120)
				menuTab = 2;
			if(mouseX<120 && mouseY>120 && mouseY<180)
				menuTab = 3;
			if(mouseX<120 && mouseY>180 && mouseY<240)
				menuTab = 4;
			//menu equipement
			//if(menuTab == 1 && mouseX>120 && mouseX<180 && mouseY<60)
				
		}
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
