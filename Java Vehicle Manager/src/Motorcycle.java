 class Motorcycle extends MotorVehicle implements Engine {

    //override for starting the vehicle
    @Override
    public void start() {

        running = true;
        System.out.println("Type of vehicle you have selected:Motorcycle");
        System.out.println("Status: Started\n");
    }
    //override for stoping the vehicle
    @Override
    public void stop() {

        running = false;
        System.out.println("Type of vehicle you have selected :Motorcycle");
        System.out.println("Status: Stopped\n");
    }


}
