package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    // way of writing arrays in java
    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
            "Nov", "Dec" };
    // other way of writing arrays in java
    float[] a1 = new float[100];
    float[] a2; // Null pointer exception, if we try to access the element of a2, in java
                // pointer called refrence.
    int MAX_VALUE = 0;
    int MIN_VALUE = 0;
    int mode = 0;

    public void settings() {
        size(1000, 500);
    }

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        // iterating
        for (int i = 0; i < rainfall.length; i++) {
            println(rainfall[i] + "\t" + months[i]);
        }
        // shortcut of iterating over an arrays, this is to reduce the code
        // enchanced for loop in java
        // for(float r:rainfall)
        // {
        // println(r);
        // }
        // for (String m:months)
        // {
        // println(m);
        // }

        // for writing it in backword
        for (int i = rainfall.length - 1; i >= 0; i--) {
            println(rainfall[i] + "\t" + months[i]);
        }

        for (int i = 0; i < rainfall.length; i++) {
            if (rainfall[i] >= rainfall[MAX_VALUE]) {
                MAX_VALUE = i;

            } else if (rainfall[i] < rainfall[MIN_VALUE]) {
                MIN_VALUE = i;
            }
        }

        println("MAX RAinfall: " + rainfall[MAX_VALUE] + " " + months[MAX_VALUE]);
        println("MIN RAinfall: " + rainfall[MIN_VALUE] + " " + months[MIN_VALUE]);

        float total = 0;
        for (int i = 0; i < rainfall.length; i++) {
            total += rainfall[i];
        }

        float Average = total / rainfall.length;
        System.out.println("Total is " + total);
        System.out.println("Average is " + Average);
    }

    public void draw() {
        // //sets location for each bar, 50 units
        // for(int i=0;i<500;i=i+50) {
        // //creates a counter variable for each values in the array
        // for(int x= 0; x < rainfall.length; x++) {
        // //draws rectangle for each of the values in the array to correspomding height
        // rect(i, 475, 30, -rainfall[x], 1);
        // }
        // }
        switch (mode) {
            case 0: {
                background(0);
                colorMode(HSB);
                float w = width / (float) rainfall.length;
                for (int i = 0; i < rainfall.length; i++) {
                    // float x = i * w;
                    float x = map(i, 0, rainfall.length, 0, width);

                    int c = (int) map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, rainfall[MAX_VALUE], 0, -height);
                    rect(x, height, w, -rainfall[i]);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (w / 2), height - 50);
                    // map suing

                }
                break;

            }
            case 1: {
                background(0);
                float border = width * 0.1f;
                // draw the axis
                stroke(255);
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);

                for (int i = 0; i < 120; i += 10) {
                    float y = map(i, 0, 120, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(i, border / 2, y);
                }
                float w = (width - (border * 2.0f)) / (float) rainfall.length;

                for (int i = 0; i < rainfall.length; i++) {
                    float x = map(i, 0, rainfall.length, border, width - border);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, -height + (border * 2.0f));
                    rect(x, height - border, w, h);

                    fill(255);
                    text(months[i], x + (w/2), height- (border /2));
                }
                break;

            }

        }

    }

}
