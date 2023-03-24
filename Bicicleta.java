package Programación.JAVA.EjercicioDocPolimorfismo;

public class Bicicleta extends Vehiculo {
    //Atributos

    //Constructores

    //Métodos
    public void mover(int distancia) {
        System.out.println("La bicicleta está pedaleando " + distancia + " metros");
        if (distancia >= 5) {
            System.out.println("La bicicleta está yendo rápido");
        } else {
            System.out.println("La bicicleta está yendo lento");
        }
    }
}