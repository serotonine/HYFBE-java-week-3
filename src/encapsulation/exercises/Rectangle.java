package encapsulation.exercises;

/**
 1. Create private fields width (double), height (double).
 2. Write a constructor to set them.
 3. Add getters and setters (no negative values allowed).
 4. Add methods: getArea() and getPerimeter().
 */
public class Rectangle
{
    double width;
    double height;
    public Rectangle(double width,double height ){
        this.width = width;
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }

    public void setHeight(double height) {
        try{
            if(height >= 0){
                this.height = height;
            }
            else{
                throw new Exception("Height should be a positive number.");
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void setWidth(double width) {
        try{
            if(width >= 0){
                this.width = height;
            }
            else{
                throw new Exception("Width should be a positive number.");
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public double getArea(){
        return this.width * this.height;
    }
    public double  getPerimeter(){
        return (this.width + this.height) * 2;
    }
}

