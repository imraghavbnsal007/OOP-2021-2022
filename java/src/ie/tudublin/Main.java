package ie.tudublin;



public class Main
{
    public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

    public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

    public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    public static void arrays()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
    }


    public static void audio1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }

    public void cat()
    {
        System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        System.out.println(lucy);

        
        Cat cat = new Cat("Ginger");

        while(cat.getNumLives() > 0)
        {
            cat.kill();
        }
        cat.kill();

    }
    public static void main(String[] args)
    {
<<<<<<< HEAD
<<<<<<< HEAD
        // loops();
        bugZap();
=======
        arrays();
>>>>>>> 403b6fb11112ea2edb4adb0a388a5a52ef91c7ab
=======
        audio1();
>>>>>>> 5f60229c857be44e8ac8324d1d819d0eb99d5d1e

        // Tara Misty
        // Tara Tara
        
    }
}