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
					// int numRects = (int)(mouseX / 10.0f);
					int numRects = 10;
                	float w = width / (float) numRects;
                	float cgap = 255 / (float) numRects;
                	for(int i = 0 ; i < numRects ; i ++)
                	{
                    	fill(i * cgap, 255, 255);
                    	rect(i * w, 0, w, height);
                	}
                	break;
					
				}
		}
	}
}
