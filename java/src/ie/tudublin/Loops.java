package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	
	public void settings()
	{
		size(500, 500);
		cx = width/2;
		cy = height /2;
	}
	int mode = 0;
	float cx;
	float cy;

	float magicmap(float a, float b, float c, float d, float e)
	{
		float r1= c-b;
		float r2 = e-d;
		float howFar = a-b;

		return d + ((howFar/r1) * r2);
	}


	public void setup() {
		colorMode(HSB);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	
	public void draw()
	{
		background(0);
		noStroke();
		switch(mode)	
		{
			case 0:
			fill(50,255,255);
			if (mouseX < cx)
			{
				
				rect(0,0,cx,height);
			}
			else
			{
				rect(cx, 0 , cx, height);
			}
			
			break;
			case 1:
			fill(50,255,255);
				if (mouseX < cx && mouseY < cy)
				{
					rect(0, 0, cx, cy);
				}

				else if (mouseX > cx && mouseY < cy)
				{
					rect(cx, 0, cx, cy);
				}
				else if (mouseX <cx && mouseY > cy )
				{
					rect(0, cy, cx, cy);
				}
				else
				{
					rect(cx, cy, cx, cy);
				}
				break;
				case 2:
				{
					int bar = (int)(mouseX / 10.0f);
					// int bar = 10;
                	float w = width / (float) bar;
                	float colorgap = 255 / (float) bar;
                	for(int i = 0 ; i < bar ; i ++)
                	{
                    	fill(i * colorgap, 255, 255);
                    	rect(i * w, 0, w, height);
                	}
                	break;
					
				}
				case 3:
				{
					float w = 200;
					float h = 50;
					rectMode(CENTER);
					if (mouseX > cx - (w/2) && mouseX < cx + (w/2) && mouseY > cy - (h/2) && mouseY <cy + (h/2))
					{
						fill(50, 255, 255);
					}
					else{
						fill (0, 255, 234);
					}
					rect(cx, cy, w, h);
					break;
				}
				case 4:
				{
					int bar = 10;
                	float w = width / (float) bar;
                
                	for(int i = 0 ; i < bar ; i ++)
                	{
                    	noStroke();
						fill(map(i, 0, 10, 0, 255), 255 , 255);
						rect(map(i, 0, 10, 0, 500), 0, w, height);
					}
                	break;
				}

				
		}
	}
}
