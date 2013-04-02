import processing.core.*;


public class character
{
	
//carac du PJ
int life;
int hp;
int sanity;
int mana;
int mp;
int speed;

//physique du PJ
float rotation;
float posX, posY;
int hitX, hitY;


int weaponID = 0;

PImage Sprite;

weapon[] weapons;



	public character(PImage sSprite, int slife, int smana, int sspeed, float sposX, float sposY)
	{

		Sprite = sSprite;
		life = slife;
		hp = life;
		
		mana = smana;
		mp = mana;
		
		speed = sspeed;
		
		posX = sposX;
		posY = sposY;
		
	}


	

}
