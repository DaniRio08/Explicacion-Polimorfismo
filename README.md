Introducción
===
El polimorfismo es uno de los conceptos más importantes de la programación orientada a objetos. Se trata de la capacidad de un objeto de ser tratado como si fuera de un tipo diferente al que realmente es, lo que permite escribir código más flexible y reutilizable.

En este trabajo, se explicará en qué consiste el polimorfismo, y para ayudar en la comprensión, se utilizará un ejemplo práctico muy sencillo. A lo largo del trabajo, se explorarán las ventajas que ofrece esta técnica, así como algunos de los desafíos que pueden surgir al implementarla.
En general, el objetivo de este trabajo es proporcionar una introducción clara y accesible al polimorfismo y mostrar cómo se puede aplicar en situaciones reales de programación orientada a objetos.


Programación Orientada a Objetos
===

Para entender qué es el polimorfismo y para qué se usa, primero hay que tener alguna noción básica de Programación Orientada a Objetos (POO). En programación existen diferentes paradigmas. Antes de la POO hacer un programa de software como por ejemplo simuladores para procesos industriales era algo muy complicado, extenso y, por lo tanto, difícil de mantener. Cada cambio del modelo original requería de muchos esfuerzos para poder reflejar estos cambios en el simulador.

A partir de este problema surgió una idea que consistía en que la programación intentase replicar los objetos del mundo real de la forma más fiel posible, diseñando un módulo para cada pieza a simular y haciendo que las piezas pudieran interactuar entre ellas, como lo harían en el mundo real. A esto se le denominó **programación orientada a objetos**. Cada pieza se implementaría en un módulo, llamado **clase**, que tendría variables para almacenar los valores necesarios para representar el su estado, los **atributos**, y rutinas que simulan su comportamiento, llamados **métodos**. Además, se podría comunicar con los otros módulos con los que estás relacionada.

En general, el nuevo paradigma de la programación, la programación orientada a objetos, se centra en la creación de objetos con un estado y un comportamiento específicos, lo que facilita la creación de software modular, reutilizable y fácil de mantener.


Explicación polimorfismo
===

Una de las principales características de la programación orientada a objetos es el polimorfismo. Se refiere a la capacidad de un objeto de una clase específica para tomar múltiples formas o comportarse de diferentes maneras. En Java, esto se puede lograr mediante la creación de clases y objetos que comparten una relación de herencia (subclases que extienden a una superclase)

Concretamente, el polimorfismo es la capacidad de una subclase para proporcionar su propia implementación de un método que ya existe en su superclase. Cuando se llama a un método en un objeto de la subclase, el compilador de Java primero buscará la implementación del método en la subclase. Si no se encuentra una implementación en la subclase, el compilador buscará en la superclase.

### Ventajas
- **Reutilización de código**: Al utilizar polimorfismo, se pueden crear clases base que pueden ser extendidas y reutilizadas por otras clases, lo que ayuda a ahorrar tiempo y esfuerzo en la programación.

- **Flexibilidad**: El polimorfismo permite que los objetos puedan ser tratados de manera más general y abstracta, lo que hace que el código sea más flexible y adaptable a cambios futuros.

- **Mantenimiento del código**: Al utilizar polimorfismo, el código es más fácil de mantener, ya que los cambios realizados en una clase base se propagan a todas las clases que la extienden.

### Desafíos de su implementación
El polimorfismo puede hacer que el código sea más complejo, por el hecho de que requiere una **planificación y diseño cuidadosos** para asegurarse de que las clases y los objetos estén correctamente definidos y estructurados. Además, supone un **mayor consumo de recursos** debido a que el programa debe hacer uso de más memoria y procesamiento para determinar qué métodos y atributos deben ser utilizados para cada objeto. También es cierto que, en algunos casos, puede haber **problemas de compatibilidad** al utilizar polimorfismo, especialmente cuando se trabaja con diferentes versiones de un lenguaje de programación o con diferentes implementaciones de una interfaz.


Ejemplo práctico
===

~~~
public class Vehiculo {
    //Atributos  
    //Constructores  
    //Métodos
    public void mover(int distancia) {
        System.out.println("El vehículo se está moviendo " + distancia + " metros");
    }
}
~~~
En este ejemplo usamos una clase “Vehículo” como clase principal (Superclase). Si no se tratase de un ejemplo para ver el funcionamiento del polimorfismo, la clase debería tener unas propiedades que todos los vehículos tienen (los atributos) como podrían ser el número de ruedas, el ancho y la altura de la base, el peso de la carrocería…  También tendría constructores y además otros comportamientos (métodos) aparte de “mover”.

Como en este caso solo queremos ver el funcionamiento del polimorfismo, la clase solo cuenta con un método muy simple llamado “mover”. Este imprimirá por pantalla una frase y cuando sea llamado recibirá como parámetro una distancia.

~~~
public class Coche extends Vehiculo {
    //Atributos  
    //Constructores  
    //Métodos
}
~~~
Luego tenemos una clase llamada “Coche” que extiende la clase Vehículo, es decir, es una subclase de esta. Ahora mismo, esta clase no tiene ningún atributo, ni constructor y ni siquiera tiene un método. Sin embargo, al ser una subclase de Vehículo, hereda el método “mover” que habíamos definido anteriormente. Si yo creo un objeto de la clase Coche y le aplico el método “mover”, aunque no esté especificado en la propia clase Coche, este devolverá lo que se había definido en su superclase:

~~~
public class Main {
    public static void main(String[] args) {
        Vehiculo miVehiculo = new Coche();
        miVehiculo.mover(5);
        //Mostrará por pantalla: "El vehículo se está moviendo 5 metros"
    }
}
~~~
Como habíamos comentado anteriormente, aunque mi objeto de tipo “Coche” no tiene un método “mover” especificado, gracias a la herencia usa el método definido en la clase “Vehículo”.

Sin embargo, el mensaje para todos los vehículos es algo ambiguo. Si yo quisiera que el mensaje que muestra por pantalla un objeto de tipo coche fuese diferente que el que se muestra para un vehículo del tipo bicicleta, tendría que usar el polimorfismo. Gracias al polimorfismo se puede crear un método “mover” dentro de la clase Coche que muestre un mensaje específico para los coches:

~~~
public class Coche extends Vehiculo {
    //Atributos  
    //Constructores  
    //Métodos
    public void mover(int distancia) {
        System.out.println("El coche está avanzando " + distancia + " metros");
        if (distancia > 10) {
            System.out.println("El coche está yendo rápido");
        } else {
            System.out.println("El coche está yendo lento");
        }
    }
}
~~~

~~~
public class Main {
    public static void main(String[] args) {
        Vehiculo miVehiculo = new Coche();
        miVehiculo.mover(5);
        //Mostrará por pantalla: "El coche está avanzando 5 metros. El coche está yendo lento"
    }
}
~~~
Ejecutando exactamente el mismo código que antes, es decir, creando un objeto del tipo coche y llamando al método “mover”, ahora lo que se muestra por pantalla es diferente. Esto es así gracias al polimorfismo. El método “mover” toma otro aspecto, otra forma, y el mensaje que se muestra es el específico para los coches y no el general para los vehículos.

Podemos hacer otra prueba, creando una clase Bicicleta que también extienda a la superclase Vehículo. Gracias al polimorfismo, esta nueva clase puede volver a implementar el método “mover”, pero esta vez adoptando una forma diferente. Lo que provocará que cuando se cree un objeto de la clase Bicicleta y se llame al método, el mensaje sea específico para las bicicletas. Y es que aunque tanto los coches como las bicicletas son vehículos, no se comportan exactamente de la misma manera. Y gracias al polimorfismo esto se puede aplicar a la programación.

~~~
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
~~~

~~~
public class Main {
    public static void main(String[] args) {
        Vehiculo miVehiculo = new Bicicleta();
        miVehiculo.mover(5);
        //Mostrará por pantalla: "La bicicleta está pedaleando 5 metros. La bicicleta está yendo rápido"
    }
}
~~~

Conclusión
===
En conclusión, y como se ha visto en el ejemplo, el polimorfismo es una característica fundamental de la programación orientada a objetos que permite que un objeto de una clase pueda comportarse y adoptar formas diferentes. 
Y es que a pesar de que el polimorfismo puede requerir un mayor esfuerzo de programación, debido a que es necesaria una buena jerarquía de clases y a que puede suponer un mayor consumo de recursos, su implementación es esencial para aprovechar plenamente las ventajas de la programación orientada a objetos y crear software modular, reutilizable y fácil de mantener.
