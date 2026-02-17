package constructors.exercises;

/**
 1. Create class Rectangle with width and height.
 2. Add:
      - Constructor(width, height)
      - Constructor(width) → height defaults to width (square)
 3. Add methods getArea() and getPerimeter().
 4. Test both constructors.
*/

public class Rectangle
{
    private int width;
    private int height;

    public Rectangle(){
        this(0,0);
    }
    public Rectangle(int width,int height ){
        this.width=width;
        this.height = height;
    }
    public int getArea(){
        return this.width * this.height;
    }
    public int  getPerimeter(){
    return (this.width + this.height) * 2;
}
}
