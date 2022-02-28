package ie.tudublin;


import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;


public class Audio1 extends PApplet {
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings(){
        size (1024,500);
    }

    public void draw(){
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 441000, 16);
    }

    
}
