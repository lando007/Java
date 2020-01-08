 class Car extends MotorVehicle implements Engine{
    //override for starting the vehicle
    @Override
    public void start() {

        running=true;

        System.out.println("Type of vehicle you have selected: Car");
        System.out.println("Status: Started\n");
    }
    //override for stoping the car
    @Override
    public void stop() {

        running=false;

        System.out.println("Type of vehicle you have selected: Car");
        System.out.println("Status: Stopped\n");
    }}




