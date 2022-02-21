package ie.tudublin;

import javax.print.attribute.standard.Sides;

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
	float offset = 0;

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
			case 2:
			{
				background(0);
				int bar = (int) (mouseX / 10.0f);
				// int bar = 10;
				float w = width / (float) bar;
				float colorgap = 255 / (float) bar;
				for (int i = 0; i < bar; i++) {
					fill(i * colorgap, 255, 255);
					rect(i * w, 0, w, height);
					// circle(width / 2, height / 2, width - map(i, 0, bar, 0, width));
				}
				break;

				// Code with the magicMap

				// int bar = 10;
				// float w = width / (float) bar;

				// for (int i = 0; i < bar; i++) {
				// noStroke();
				// fill(map(i, 0, 10, 0, 255), 255, 255);
				// rect(map(i, 0, 10, 0, 500), 0, w, height);
				// }
				// break;

			}
			case 3: {
				background(0);
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
				// after this starting on case 8
			}
			case 4: {
				background(0);
				int numcircles = (int)(mouseX / 10.0f);
				// int numcircles = 10;
				float w = width / (float) numcircles;
				float colorgap = 255 / (float) numcircles;
				for (int i = 0; i < numcircles; i++) {
					fill(colorgap * i, 255, 255);
					ellipse(w / 2 + (i * w), cy, w, w);
				}
				break;
			}
			case 5: {
				background(0);
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
				// code with magic map
				// map(a, b, c, d, e);
				// a= inputvalue
				// b -c - start and end of the first range
				// d,e 0- start and end of the range
				// int squares = (int) (mouseX/10);
				// float w = width / (float) squares;
				// for (int i = 0; i < squares; i++)
				// {
				// noStroke();
				// fill(map(i, 0, squares, 0 , 255), 255, 255);
				// float x = map(i, 0, squares, 0 , width);
				// rect(x, x, w, w);
				// rect((width -w ) -x , x, w, w);
				// }

			}
			case 6: {
				background(0);
				int numcircles = (int) mouseX / 10;
				float w = width / (float) numcircles;
				float cgap = 255 / (float) numcircles;
				for (int i = 0; i < numcircles; i++) {
					fill(cgap * i, 255, 255);
					ellipse(width - ((i + 1) * w), i * w, w, w);
				}
				break;

			}
			case 7: {
				background(0);
				int circles = (int) (mouseX / 10);
				float w = width / (float) circles;
				for (int i = 0; i < circles; i++) {
					noStroke();
					fill(map(i, 0, circles, 0, 255), 255, 255);
					float x = map(i, 0, circles, 0, width);
					ellipse(x, x, w, w);
					ellipse((width - w) - x, x, w, w);
				}
			}
			case 8: {
				background(0);
				// colorfull circles circle in circles
				int bar = (int) (mouseX / 10.0f);
				// int bar = 10;
				float w = width / (float) bar;
				float colorgap = 255 / (float) bar;
				for (int i = 0; i < bar; i++) {
					fill(i * colorgap, 255, 255);
					circle(width / 2, height / 2, width - map(i, 0, bar, 0, width));
				}
				break;
			}
			case 9:
			{
				background(255);
				int circles = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float) circles;
				for (int j = 0; j < circles; j++) {
					for (int i = 0; i < circles; i++) {
						noStroke();
						float c = map((i + j + offset), 0, circles * 2, 0, 255) % 256;
						fill(c, 255, 255);
						float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						float y = map(j, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						circle(x, y, d);
					}
				}
			}
			case 10:
			{
				background(0);
				colorMode(RGB);
				float border = width * 0.1f;

				for (int i = -5; i <=5; i++)
				{
					float x = map(i, -5, 5, border, width - border);
					stroke (50, 250, 50);
					line (x, border, x, height- border);
					line(border, x,width - border, x);
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);

				}

				break;
			}
			case 11:
			{
				background(0);
				stroke(255);
				colorMode(RGB);
				float cx = width/ 2;
				float cy = height /2;
				float radius= 200;
				int slides = (int) map(mouseX, 1, width, 0, 20);
				for (int i = 1; i < slides; i ++)
				{
					float theta = map(i, 0, slides, 0, TWO_PI);
					float x = cx + sin(theta) * radius;
					float y = cy + cos(theta)  * radius;
					circle (x, y, 20);
				}
			}


		}
	}
}
