package Programación.JAVA.EjercicioDocPolimorfismo;

public class Main {
    public static void main(String[] args) {

        //Objeto tipo vehículo y uso del método "mover"
        Vehiculo miVehiculo = new Vehiculo();
        miVehiculo.mover(5);

        System.out.println("------------------------");

        //Objeto tipo coche
        miVehiculo = new Coche();
        miVehiculo.mover(8);

        System.out.println("------------------------");

        //Objeto tipo bicicleta
        miVehiculo = new Bicicleta();
        miVehiculo.mover(5);
    }
}
