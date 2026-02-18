package encapsulation.exercises;

/**
 1. Create a private field temperatureInCelsius (double).
 2. Add getter and setter for it (no unrealistic values like -273).
 3. Add a method getFahrenheit() that converts Celsius to Fahrenheit.
 4. Add a method getKelvin() that converts Celsius to Kelvin.
 */
public class Temperature
{
    // 1. Create a private field temperatureInCelsius (double).
    private double temperatureInCelsius;

    // 2. Add getter and setter for it (no unrealistic values like -273).

    public double getTemperatureInCelsius() {
        return this.temperatureInCelsius;
    }

    public void setTemperatureInCelsius(double temperatureInCelsius) {
        try {
            if(temperatureInCelsius <273.00 && temperatureInCelsius > -273.00){
                this.temperatureInCelsius = temperatureInCelsius;
            }
            else{
                throw new Exception("Temperature must be set between -273° and 273°");
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
// 3. Add a method getFahrenheit() that converts Celsius to Fahrenheit.
    public Double getFahrenheit(){

        try{
            double fahrenheit = (this.temperatureInCelsius * 9/5) + 32;
            System.out.printf("%.2f°C = %.2f°F%n", this.temperatureInCelsius, fahrenheit);
            return fahrenheit;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    // 4. Add a method getKelvin() that converts Celsius to Kelvin.
    public Double getKelvin(){

        try{
            double kelvin = this.temperatureInCelsius  + +273.15;
            System.out.printf("%.2f°C = %.2f K%n", this.temperatureInCelsius, kelvin);
            return kelvin;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
