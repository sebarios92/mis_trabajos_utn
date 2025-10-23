// TP7 - Herencia y Polimorfismo 
// Autor: RIOS_SEBASTIAN
// Archivo único con los 4 temas del Trabajo Práctico 7

// =====================================================
//           1 - Vehículos y herencia básica
// =====================================================
class Vehiculo {
    private final String marca;
    private final String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    public String mostrarInfo() {
        return "Vehículo - Marca: " + marca + ", Modelo: " + modelo;
    }
}

class Auto extends Vehiculo {
    private final int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String mostrarInfo() {
        return "Auto - Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Puertas: " + cantidadPuertas;
    }
}

// =====================================================
//      2 - Figuras geométricas y métodos abstractos
// =====================================================
abstract class Figura {
    protected String nombre;
    public Figura(String nombre) { this.nombre = nombre; }
    public abstract double calcularArea();
    public String getNombre() { return nombre; }
}

class Circulo extends Figura {
    private final double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private double base, altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

// =====================================================
//                     3 - Empleados 
// =====================================================
abstract class Empleado {
    protected String nombre;
    public Empleado(String nombre) { this.nombre = nombre; }
    public abstract double calcularSueldo();
    public String getNombre() { return nombre; }
}

class EmpleadoPlanta extends Empleado {
    private double sueldoBase;

    public EmpleadoPlanta(String nombre, double sueldoBase) {
        super(nombre);
        this.sueldoBase = sueldoBase;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase;
    }
}

class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private double pagoPorHora;

    public EmpleadoTemporal(String nombre, int horasTrabajadas, double pagoPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas * pagoPorHora;
    }
}

//            4 - Animales y comportamiento 
// =====================================================
class Animal {
    public void hacerSonido() {
        System.out.println("(Sonido genérico de animal)");
    }

    public void describirAnimal() {
        System.out.println("Este es un animal.");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}

class Vaca extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Muuu");
    }
}

// =====================================================
//                     MAIN GENERAL 
// =====================================================
public class MainTP7 {
    public static void main(String[] args) {
        System.out.println("================ 1: Vehículos ================");
        Auto auto1 = new Auto("Toyota", "Corolla", 4);
        System.out.println(auto1.mostrarInfo());

        System.out.println("\n================ 2: Figuras ==================");
        Figura[] figuras = {
            new Circulo("Círculo", 3),
            new Rectangulo("Rectángulo", 4, 5)
        };
        for (Figura f : figuras) {
            System.out.println(f.getNombre() + " → Área: " + f.calcularArea());
        }

        System.out.println("\n================ 3: Empleados ================");
        Empleado[] empleados = {
            new EmpleadoPlanta("Ramiro", 250000),
            new EmpleadoTemporal("Sofía", 120, 1800)
        };
        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + " cobra $" + e.calcularSueldo());
        }

        System.out.println("\n================ 4: Animales =================");
        Animal[] animales = { new Perro(), new Gato(), new Vaca() };
        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido();
            System.out.println("-----------------------------");
        }
    }
}
