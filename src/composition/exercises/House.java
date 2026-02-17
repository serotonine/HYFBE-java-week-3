package composition.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 1. Create class Room with fields: length, width.
 2. Add method getArea() in Room.
 3. Create class House that HAS-A Room.
 4. Add method printRoomArea() in House to delegate to Room.
*/

class House
{   Map<String, Room> rooms;
    public House(){
        this.rooms = new HashMap<>();
    }
    public void addRoom(String name, int length,int width,int windows){
        this.rooms.put(name,new Room(length,width,windows));
        System.out.println(name + " was added");
    }
    public void listRooms(){
        this.rooms.forEach((String name, Room room)->{
            System.out.print(name + ": ");
            System.out.print(room.getAera() + "m2, ");
            System.out.println(room.getWindowsNumber() + " Windows." );
        });
    }
    public int getTotalAera(){
        int total = 0;
        for(Room room:this.rooms.values()){
            total += room.getAera();
        }
        return total;
    }
}

class Room{
   private  int length;
   private  int width;
   private int windows;

   public Room(){
       this(0,0,0);
   }
   public Room(int length,int width,int windows){
       this.windows = windows;
       this.width = width;
       this.length = length;
   }

    public int getAera() {
        return this.length * this.width;
    }

    public int getWindowsNumber(){
       return this.windows;
    }
}
