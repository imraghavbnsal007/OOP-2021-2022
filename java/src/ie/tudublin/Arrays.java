package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    //way of writing arrays in java
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};

    String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "Spetember", "October", "November", "December"};
    //other way of writing arrays in java
    float[] a1 = new float[100];
    float[] a2; //Null pointer exception, if we try to access the element of a2, in java pointer called refrence. 
    // float MAX_VALUE =0;
    // float MIN_VALUE = 0;
    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        //iterating 
        for (int i = 0; i < rainfall.length ; i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        //shortcut of iterating over an arrays, this is to reduce the code 
        //enchanced for loop in java
        // for(float r:rainfall)
        // {
        //     println(r);
        // }
        // for (String m:months)
        // {
        //     println(m);
        // }

            //for writing it in backword
        for (int i = rainfall.length -1; i >=0; i --)
        {
            println(rainfall[i] + "\t" + months[i]); 
        }
        
        int MAX_VALUE = 0;
        int MIN_VALUE= 0;

        for(int i = 0; i <rainfall.length; i++ )
        {
            if(rainfall[i] >= rainfall[MAX_VALUE])
            {
                MAX_VALUE = i;
                
            }
            else if (rainfall[i] < rainfall[MIN_VALUE])
            {
                MIN_VALUE = i;
            }
        }

        println("MAX RAinfall: " + rainfall[MAX_VALUE] + " " + months[MAX_VALUE]);
        println("MIN RAinfall: " + rainfall[MIN_VALUE]+ " " + months[MIN_VALUE]);

        float total =0;
        for(int i =0; i<rainfall.length; i++)
        {
            total += rainfall[i];
        }

        float Average = total / rainfall.length;
        System.out.println("Total is " + total); 
        System.out.println("Average is " + Average);
    }

    public void draw()
    {
        

    }
    
}
