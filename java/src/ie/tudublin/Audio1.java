package ie.tudublin;

import processing.core.PApplet;

//Sound imports
import ddf.minim.Minim;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;

public class Audio1 extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    float y = 0;

    public void settings() {
        size(1024, 500);
    }// end settings()

    public void setup() {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        colorMode(HSB);
        // colorMode(RGB);\

        y = height/2;
    }// end setup()

    public void draw() {
        background(0);
        stroke(255);
        float halfH = height / 2;
        float avg = 0;
        float sum = 0;

        for (int i = 0; i < ab.size(); i = i + 5) {
            // float c = map(ab.get(i), -1, 1, 0, 255);
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            // line(i, halfH, i, halfH + ab.get(i) * halfH);
            sum += abs(ab.get(i));
        }

        avg = sum / (float) ab.size();

        stroke(255);
        fill(100, 255, 255);
        circle(width / 2, halfH, avg * 900);
        circle(100, y, 50);
        y += random(-10, 10);

    }// end draw()
}