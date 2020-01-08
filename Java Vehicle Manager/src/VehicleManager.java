import java.util.Scanner;
class VehicleManager {
    Car[] cars= new Car[3]; //car array instant variable
    Motorcycle[] motorcycles= new Motorcycle[3]; //motorcycle array instant variable

    public void run(){
        Car car1= new Car();
        car1.running=true;
        car1.color="orange";
        Car car2= new Car();
        car2.running=false;
        car2.color="pink";
        Car car3= new Car();
        car3.running=false;
        car3.color="yellow"; // 3 cars created

        Motorcycle m1= new Motorcycle();
        m1.running=false;
        m1.color="Red";
        Motorcycle m2= new Motorcycle();
        m2.running=true;
        m2.color="blue";
        Motorcycle m3= new Motorcycle();
        m3.running=false;
        m3.color="purple"; //3 motorcycles created


        //cars and motorcycles are created and assigned to the arrays
        //this one is the cars array
        cars[0]=car1;
        cars[1]=car2;
        cars[2]=car3;
        //This one is the motorcycle array

        motorcycles[0]=m1;
        motorcycles[1]=m2;
        motorcycles[2]=m3;


        //prints out all of the cars and motorcycles information to be filled out by the persob
        System.out.print("Select which car to start \n 1 2 3 :");
        int num= new Scanner(System.in).nextInt();
        cars[num-1].start();

        System.out.print("Select which motorcycle to start \n 1 2 3 :");
        num= new Scanner(System.in).nextInt();
        motorcycles[num-1].start();

        System.out.print("Select which car to stop \n 1 2 3 :");
        num= new Scanner(System.in).nextInt();

        System.out.print("Select which motocycle to stop \n 1 2 3 :");
        num= new Scanner(System.in).nextInt();
        motorcycles[num-1].stop();

        System.out.println("");
        System.out.println("");

        //This will print out all the information in a clean way.

        //this will print out all the information you need at the end for your car and the statis of it
        for (int i = 0; i < 3; i++) {
            if (cars[i].running) {
                System.out.println("The car "+(i+1)+" is running..");
            }else{
                System.out.println("The car "+(i+1)+" is stopped..");
            }
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            //This will print all the information you need and the statis of all the motorcycles.
            if (motorcycles[i].running) {
                System.out.println("The motorcycle "+(i+1)+" is running..");
            }else{
                System.out.println("The motorcycle "+(i+1)+" is stopped..");
            }
        }
    }
}

