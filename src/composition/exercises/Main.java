package composition.exercises;

public class Main {
    public static void main(String[] args) {
        System.out.println("/// COMPUTER ///");
        Computer myComputer = new Computer();
        myComputer.start();
        System.out.println("/// DEPARTMENT ///");
        Department coldCase = new Department("Cold cases");
        Department antiTerrorism = new Department("Anti Terrorism");
        coldCase.hire("Victor", "Inspector");
        coldCase.hire("Alexandra", "cop");
        coldCase.hire("Ahmed", "cop");
        coldCase.hire("Magali", "secretary");
        coldCase.listEmployees();
        antiTerrorism.hire("Mamadou", "cop");
        antiTerrorism.hire("Karim", "cop");
        antiTerrorism.hire("Andrei", "cop");
        antiTerrorism.hire("Florence", "cop");
        System.out.println("///THE HOUSE OF MY DREAM ///");
        House myHouse = new House();
        myHouse.addRoom("Bedroom", 5, 3, 2);
        myHouse.addRoom("Desktop", 4, 3, 1);
        myHouse.addRoom("Kitchen", 3, 3, 1);
        myHouse.addRoom("Saloon", 5, 5, 4);
        myHouse.addRoom("Bathroom", 3, 4, 1);
        myHouse.addRoom("Entrance", 1, 3, 0);

        myHouse.listRooms();
        System.out.println("Total aera = "+ myHouse.getTotalAera() + "m2");
        System.out.println("/// MY LIBRARY ///");
        Library myLibrary = new Library();
       myLibrary.addBook("Kill the mockingbird", "Lee Harper");
       myLibrary.addBook("Crime and Punishment", "Fiodor Dostoïevski");
       myLibrary.addBook("2084: the end of the world", "Sansal Boualem");
        myLibrary.addBook("Madame Bovary", "Gustave Flaubert");
       myLibrary.addBook("On the Marble Cliffs", "Ernst Jünger");
       System.out.println("/// MY LIBRARY BOOKS LIST ///");
       myLibrary.listBooks();
    }
}
