package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>();

    float border;
    int firstStar = -1;
    int secondStar = -1;

    void drawGrid() {
        background(0);
        textSize(10);
        stroke(255, 0, 255); // purple grid pattern
        // stroke(0, 255, 0); //for green
        textAlign(CENTER, CENTER);

        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            float y = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, y, width - border, y);
            fill(255);
            text(i, x, border / 2);
            text(i, border / 2, y);

        }
    }

    void printStars() {

        for (Star s : stars) {
            System.out.println(s);
        }
    }

    void loadStars() {
        Table table = loadTable("HabHYG15ly.csv", "header");

        for (TableRow r : table.rows()) {
            Star s = new Star(r);
            stars.add(s);
        }
    }

    public void settings() {
        size(650, 650);
    }

    // Star first = null;
    // Star second = null;

    public void mouseClicked() {
        // for (Star s : stars) {
        // float x = map(s.getxG(), -5, 5, border, width - border);
        // float y = map(s.getyG(), -5, 5, border, height - border);

        // if (dist(mouseX, mouseY, x, y) < 20) {
        // if (first == null) {
        // first = s;
        // break;
        // } else if (second == null) {
        // second = s;
        // break;
        // } else {
        // first = s;
        // second = null;
        // break;
        // }
        // }

        // }

        for (int i = 0; i < stars.size(); i++) {

            Star s = stars.get(i);

            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < s.getAbsMag() / 2) {

                if (firstStar == -1) {
                    firstStar = i;
                    break;
                } else if (secondStar == -1) {
                    secondStar = i;
                    break;
                } else {
                    firstStar = i;
                    secondStar = -1;
                }
            }

        }

    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

        border = width * 0.1f;
    }

    public void drawStars() {
        for (Star s : stars) {
            s.render(this);
        }
    }

    public void draw() {
        background(0);
        drawGrid();
        drawStars();
        // mouseClicked();

        // if (first != null) {
        // float x = map(first.getxG(), -5, 5, border, width - border);
        // float y = map(second.getyG(), -5, 5, border, height - border);

        // if (second != null) {
        // float x2 = map(second.getxG(), -5, 5, border, width - border);
        // float y2 = map(second.getyG(), -5, 5, border, height - border);

        // stroke(255, 255, 0);
        // line(x, y, x2, y2);

        // float distance = dist(first.getxG(), first.getyG(), first.getzG(),
        // second.getxG(), second.getyG(),
        // second.getzG());

        // fill(255);
        // textAlign(CENTER, CENTER);
        // text("Distance between: " + first.getDisplayName() + " and " +
        // second.getDisplayName() + " is "
        // + distance + " parsecs", width / 2, height - (border * 0.5f));
        // } else {
        // stroke(255, 255, 0);
        // line(x, y, mouseX, mouseY);
        // }

        // }

        if (firstStar != -1 && secondStar == -1) {

            Star s = stars.get(firstStar);
            stroke(255, 255, 0);
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            line(x, y, mouseX, mouseY);
        }

        else if (firstStar != -1 && secondStar != -1) {

            Star s = stars.get(firstStar);
            stroke(255, 255, 0);
            float x1 = map(s.getxG(), -5, 5, border, width - border);
            float y1 = map(s.getyG(), -5, 5, border, height - border);

            Star s1 = stars.get(secondStar);
            float x2 = map(s1.getxG(), -5, 5, border, width - border);
            float y2 = map(s1.getyG(), -5, 5, border, height - border);
            line(x1, y1, x2, y2);

            float distance = dist(s.getxG(), s.getyG(), s.getzG(), s1.getxG(), s1.getyG(), s1.getzG());
            stroke(255);
            textAlign(CENTER, CENTER);
            text("Distance between " + s.getDisplayName() + " and " + s1.getDisplayName() + " is " + distance
                    + " parsecs", width / 2, height - (border / 2));

        }

    }
}
        