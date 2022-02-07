package ie.tudublin;

    import processing.core.PApplet;

public class BugZap extends PApplet {

    public void setting()
    {
        size(1000, 1000);
    }
    float playerX, playerY;
    float playerWidth = 40;
    float bugWidth;
    float bugX, bugY;

    public void setup(){
        colorMode(RGB);

        smooth();

        playerX = width /2;
        playerY = height -50;
        restBug();
    }
   
    private void restBug() {
        bugX = random(bugWidth /2, width - (bugWidth /2));
        bugY = 50;
    }

    // void drawBug(float x, float y, float w)
    // {
    //     float halfw = w/2;
    //     stroke(255);
    //     noFill();
    //     // triangle(x -halfw, y + halfw, x2, y2, x3, y3);
    // }


    void drawPlayer(float x, float y, float w){
        stroke(255);
        noFill();
        rectMode(CENTER);
        rect(x, y, w, 20);
        line(x, y-10, x, y-20);
    }

    public void keyPressed()
    {
        if(keyCode == LEFT)
        {
            // playerX--;
            playerX --;
        }
        if(keyCode == RIGHT)
        {
            playerY++;
        }

        if (key = ' ')
        {
            float halfW = bugWidth /2;
            if (playerX > bug - halfW && playerX < bugX + halfW)
            {
                score++;
                restBug();
                line(playerX, playerY - 10, playerX, bugY);

            }
            else{
                line(playerX, playerY - 10, , y2);
            }
        }
    }
    int score = 0;

    void moveBug()
    {
        bugY++;
        bugX =+ random(-20, 20);
    }
    public void draw(){
        background(0);
        strokeWeight(2);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth);

        if (frameCount % 20 == 0)
        {
            moveBug();
        }


    }

    
    
}
