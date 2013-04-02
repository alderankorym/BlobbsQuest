import processing.core.*;



public class weapon
{
PImage Sprite;
int damage;
int range;
int speed;
int delay;
int recharge;
int type;

	public weapon (PImage sSprite,int sdamage, int srange, int sspeed, int sdelay, int srecharge, int stype)
	{
	
		Sprite = sSprite;
		damage = sdamage;
		range = srange;
		speed = sspeed;
		delay = sdelay;
		recharge = srecharge;
		type = stype;
		/*
		0 : strike
		1 : throw
		2 : shoot
		3 : bow
		
		
		
		*/
	}

}


