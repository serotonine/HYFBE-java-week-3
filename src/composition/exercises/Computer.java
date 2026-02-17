package composition.exercises;

/**
 TODO:
 1. Create class Processor with method processData().
 2. Create class Computer that HAS-A Processor.
 3. In main(), create a Computer and call processData() through it.
*/

class Computer
{
   private final Processor processor;
    Computer(){
        this.processor = new Processor();
    }
    public void start(){
        this.processor.processData();
        System.out.println("Computer started.");
    }
}

class Processor{
    public void processData(){
        System.out.println("Processor is processing datas...");
    }
}