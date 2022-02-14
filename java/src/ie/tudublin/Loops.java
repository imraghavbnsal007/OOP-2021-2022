package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	public void settings() {
		size(500, 500);
		cx = width / 2;
		cy = height / 2;
	}

	int mode = 0;
	float cx;
	float cy;

	float magicmap(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	public void draw() {
		background(0);
		noStroke();
		switch (mode) {
			case 0:
				fill(50, 255, 255);
				if (mouseX < cx) {

					rect(0, 0, cx, height);
				} else {
					rect(cx, 0, cx, height);
				}

				break;
			case 1:
				fill(50, 255, 255);
				if (mouseX < cx && mouseY < cy) {
					rect(0, 0, cx, cy);
				}

				else if (mouseX > cx && mouseY < cy) {
					rect(cx, 0, cx, cy);
				} else if (mouseX < cx && mouseY > cy) {
					rect(0, cy, cx, cy);
				} else {
					rect(cx, cy, cx, cy);
				}
				break;
			case 2: {
				int bar = (int) (mouseX / 10.0f);
				// int bar = 10;
				float w = width / (float) bar;
				float colorgap = 255 / (float) bar;
				for (int i = 0; i < bar; i++) {
					fill(i * colorgap, 255, 255);
					rect(i * w, 0, w, height);
				}
				break;

			}
			case 3: {
				float w = 200;
				float h = 50;
				rectMode(CENTER);
				if (mouseX > cx - (w / 2) && mouseX < cx + (w / 2) && mouseY > cy - (h / 2) && mouseY < cy + (h / 2)) {
					fill(50, 255, 255);
				} else {
					fill(0, 255, 234);
				}
				rect(cx, cy, w, h);
				break;
				//after this starting on case 8
			}
			case 4: {
				int bar = 10;
				float w = width / (float) bar;

				for (int i = 0; i < bar; i++) {
					noStroke();
					fill(map(i, 0, 10, 0, 255), 255, 255);
					rect(map(i, 0, 10, 0, 500), 0, w, height);
				}
				break;
			}
			case 5: {
				// int numcircles = (int)(mouseX / 10.0f);
				int numcircles = 10;
				float w = width / (float) numcircles;
				float colorgap = 255 / (float) numcircles;
				for (int i = 0; i < numcircles; i++) {
					fill(colorgap * i, 255, 255);
					ellipse(w / 2 + (i * w), cy, w, w);
				}
				break;
			}
			case 6: {
				rectMode(CORNER);
				int numRects = (int) mouseX / 10;
				// int numRects = 10;
				float w = width / (float) numRects;
				float cgap = 255 / (float) numRects;
				for (int i = 0; i < numRects; i++) {
					fill(cgap * i, 255, 255);
					rect(i * w, i * w, w, w);
					rect(width - ((i + 1) * w), i * w, w, w);
				}
				break;

			}
			case 7:
			{
				int numcircles = (int) mouseX /10;
				float w = width / (float) numcircles;
				float cgap = 255 / (float) numcircles;
				for (int i = 0; i < numcircles; i++)
				{
					fill(cgap *i, 255, 255);
					ellipse(width - ((i+1) * w), i *w, w, w);
				}

			}
			
			// case 8:
            // {
            //     int sides = (mouseX / 50);
			// 	// int sides = 50;
            //     float theta = TWO_PI / (float) sides;
            //     float radius = 200;
            //     stroke(255);
            //     for(int i = 1 ; i <= sides ; i ++)
            //     {
            //         float x1 = sin(theta * (i - 1)) * radius;
            //         float y1 = cos(theta * (i - 1)) * radius;
            //         float x2 = sin(theta * i) * radius;
            //         float y2 = cos(theta * i) * radius;
            //         line(cx + x1, cy + y1, cx + x2, cy + y2);
            //     }
			// 	break;
            // }
			//staring for last lab from case 3 continuing
			case 9:
			{
				// map(a, b, c, d, e);
				// a= inputvalue
				//b -c - start and end of the first range
				//d,e 0- start and end of the range
			}
            

		}
	}
}
