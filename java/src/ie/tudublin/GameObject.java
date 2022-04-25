package ie.tudublin;

public abstract class GameObject {
    float x, y;
    float fx, fy;
    float w;
    float halfW;

    YASC yasc;
    float rotation;

    public GameObject(YASC yasc)

    {
        this.yasc = yasc;
    }
    
     // subclasses must implement these abstract methods, otherwise they will be abstract
    public abstract void render();
    public abstract void update();
}
