<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
package ie.tudublin;

import processing.core.PApplet;

public class Audio1 extends PApplet {
    
}
=======
package ie.tudublin;

import processing.core.PApplet;

public class Audio1 extends PApplet
{
    
    
}
>>>>>>> 25b711959804c0ede9b303dfca8449c75993fc23
=======
package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
    }

    public void draw()
    {
        background(0);
        stroke(255);
        float halfH = height / 2;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            line(i, halfH, i, halfH + ab.get(i) * halfH);
        }
    }
    

    
}
>>>>>>> 5f60229c857be44e8ac8324d1d819d0eb99d5d1e
=======
package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;
    }

    public void draw()
    {
        background(0);
        stroke(255);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            //float c = map(ab.get(i), -1, 1, 0, 255);
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            // line(i, halfH, i, halfH + ab.get(i) * halfH);
            sum += abs(ab.get(i));
        }
        average= sum / (float) ab.size();

        stroke(255);
        fill(100, 255, 255);        
        lerpedA = lerp(lerpedA, average, 0.1f);
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);


    }
    
    float y;
    float smoothedY;
    float lerpedA = 0;

    
}
>>>>>>> 48343e907348a37b23ec86e215e0728dc7aa1638
=======
package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        //size(1024, 500, P3D);
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        

        switch (mode) {
			case 0:
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);                    
                }
                break;
        case 1:
                {
                    strokeWeight(2);
                    for(int i = 0 ; i < ab.size() ; i += 10)
                    {
                        //float c = map(ab.get(i), -1, 1, 0, 255);
                        float c = map(i + off, 0, ab.size(), 0, 255) % 255;
                        stroke(c, 255, 255);
                        float f = lerpedBuffer[i] * halfH * 6.0f;
                        fill(c, 255, 255);
                        circle(i, halfH + f, 5);
                        circle(i, halfH - f, 5);                        
                        line(i, halfH + f, i, halfH - f);                    
                    }
                }
                break;
        case 2:
            {
                    background(0, 0, 0, 100);
                    stroke(255, 255, 255);	
                    float cx = width / 2;
                    float cy = height / 2;	
                    float radius = map(smoothedAmplitude, 0, 0.1f, 50, 500);		
                    int points = (int)map(mouseX, 0, 255, 3, 50);
                    int sides = points * 2;
                    float px = cx;
                    float py = cy - radius; 
                    for(int i = 0 ; i <= sides ; i ++)
                    {
                        float r = (i % 2 == 0) ? radius : radius / 2; 
                        // float r = radius;
                        float theta = map(i, 0, sides, 0, TWO_PI);
                        float x = cx + sin(theta) * r;
                        float y = cy - cos(theta) * r;
                        
                        //circle(x, y, 20);
                        line(px, py, x, y);
                        px = x;
                        py = y;
                    }
            }
        }

        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
>>>>>>> ff7514b8f67f00bde7e93f06a65899fbfe0de1bc
