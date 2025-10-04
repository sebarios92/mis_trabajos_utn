package tp_uml;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 *
 * @author sebastianrios
 */
public class TP_UML {

    /**
     * @param args 
     */
    public static void main(String[] args) {

        // ==== DEMO 1: Pasaporte – Foto – Titular ====
        Foto f = new Foto(new byte[]{1,2,3}, "JPG");
        Titular t = new Titular("Juan Perez", "12345678");
        Pasaporte p = new Pasaporte("AR-0001", LocalDate.now(), f, t);

        System.out.println("Titular: " + t.getNombre() + " | Pasaporte: " + p.getNumero());

        // ==== DEMO 2: Celular – Batería – Usuario ====
        UsuarioCel uc = new UsuarioCel("María Garcia", "23456789");
        Celular cel = new Celular("111222333444555", "Samsung", "S24");
        Bateria bat = new Bateria("EB-BG991ABY", 4000);
        cel.asignarBateria(bat);
        cel.asignarUsuario(uc);
        System.out.println("Celular asignado a: " + uc.getCelular());

        // ==== DEMO 3: Reproductor – Canción – Artista ====
        Artista art = new Artista("Cerati", "Rock");
        Cancion can = new Cancion("Crimen", art);
        Reproductor rep = new Reproductor();
        rep.reproducir(can);

       
    }
}

// ===============================================
// EJERCICIO 1 – Pasaporte – Foto – Titular
// ===============================================
class Foto {
    private byte[] imagen;
    private String formato;
    public Foto(byte[] imagen, String formato) { this.imagen = imagen; this.formato = formato; }
    public byte[] getImagen() { return imagen; }
    public void setImagen(byte[] imagen) { this.imagen = imagen; }
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
}

class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte;
    public Titular(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public Pasaporte getPasaporte() { return pasaporte; }
    public void setPasaporte(Pasaporte pasaporte) { this.pasaporte = pasaporte; }
}

class Pasaporte {
    private String numero;
    private LocalDate fechaEmision;
    private final Foto foto;          // composición
    private Titular titular;          // asociación bidireccional 1:1
    public Pasaporte(String numero, LocalDate fechaEmision, Foto foto, Titular titular) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = foto;
        this.titular = titular;
        titular.setPasaporte(this);
    }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }
    public Foto getFoto() { return foto; }
    public Titular getTitular() { return titular; }
    public void setTitular(Titular titular) { this.titular = titular; }
}

// ===============================================
// EJERCICIO 2 – Celular – Batería – Usuario
// ===============================================
class Bateria {
    private final String modelo;
    private final int capacidad;
    public Bateria(String modelo, int capacidad) { this.modelo = modelo; this.capacidad = capacidad; }
}

class UsuarioCel {
    private final String nombre;
    private final String dni;
    private Celular celular;
    public UsuarioCel(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public Celular getCelular() { return celular; }
    public void setCelular(Celular celular) { this.celular = celular; }
}

class Celular {
    private final String imei;
    private final String marca;
    private final String modelo;
    private Bateria bateria;     // agregación
    private UsuarioCel usuario;  // asociación 1:1 bidireccional
    public Celular(String imei, String marca, String modelo) {
        this.imei = imei; this.marca = marca; this.modelo = modelo;
    }
    public void asignarBateria(Bateria b) { this.bateria = b; }
    public void asignarUsuario(UsuarioCel u) { this.usuario = u; u.setCelular(this); }
}

// ===============================================
// EJERCICIO 3 – Libro – Autor – Editorial
// ===============================================
class Autor {
    private final String nombre;
    private final String nacionalidad;
    public Autor(String nombre, String nacionalidad) { this.nombre = nombre; this.nacionalidad = nacionalidad; }
}

class Editorial {
    private final String nombre;
    private final String direccion;
    public Editorial(String nombre, String direccion) { this.nombre = nombre; this.direccion = direccion; }
}

class Libro {
    private final String titulo;
    private final String isbn;
    private final Autor autor;          // asociación unidireccional
    private final Editorial editorial;  // agregación
    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo; this.isbn = isbn; this.autor = autor; this.editorial = editorial;
    }
}

// ===============================================
// EJERCICIO 4 – TarjetaDeCredito – Cliente – Banco
// ===============================================
class Banco {
    private final String nombre;
    private final String cuit;
    public Banco(String nombre, String cuit) { this.nombre = nombre; this.cuit = cuit; }
}

class Cliente {
    private final String nombre;
    private final String dni;
    private TarjetaDeCredito tarjeta;
    public Cliente(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public TarjetaDeCredito getTarjeta() { return tarjeta; }
    public void setTarjeta(TarjetaDeCredito tarjeta) { this.tarjeta = tarjeta; }
}

class TarjetaDeCredito {
    private final String numero;
    private final LocalDate fechaVencimiento;
    private Cliente cliente;       // bidireccional
    private final Banco banco;     // agregación
    public TarjetaDeCredito(String numero, LocalDate fechaVencimiento, Banco banco) {
        this.numero = numero; this.fechaVencimiento = fechaVencimiento; this.banco = banco;
    }
    public void asignarCliente(Cliente c) { this.cliente = c; c.setTarjeta(this); }
}

// ===============================================
// EJERCICIO 5 – Computadora – PlacaMadre – Propietario
// ===============================================
class PlacaMadre {
    private final String modelo;
    private final String chipset;
    public PlacaMadre(String modelo, String chipset) { this.modelo = modelo; this.chipset = chipset; }
}

class Propietario {
    private final String nombre;
    private final String dni;
    private Computadora computadora;
    public Propietario(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public void setComputadora(Computadora c) { this.computadora = c; }
    public Computadora getComputadora() { return computadora; }
}

class Computadora {
    private final String marca;
    private final String numeroSerie;
    private final PlacaMadre placaMadre;   // composición
    private final Propietario propietario; // bidireccional
    public Computadora(String marca, String numeroSerie, PlacaMadre placaMadre, Propietario propietario) {
        this.marca = marca; this.numeroSerie = numeroSerie; this.placaMadre = placaMadre;
        this.propietario = propietario; propietario.setComputadora(this);
    }
}

// ===============================================
// EJERCICIO 6 – Reserva – Cliente – Mesa
// ===============================================
class ClienteRes {
    private final String nombre;
    private final String telefono;
    public ClienteRes(String nombre, String telefono) { this.nombre = nombre; this.telefono = telefono; }
}

class Mesa {
    private final int numero;
    private final int capacidad;
    public Mesa(int numero, int capacidad) { this.numero = numero; this.capacidad = capacidad; }
}

class Reserva {
    private final LocalDate fecha;
    private final LocalTime hora;
    private final ClienteRes cliente; // unidireccional
    private final Mesa mesa;          // agregación
    public Reserva(LocalDate fecha, LocalTime hora, ClienteRes cliente, Mesa mesa) {
        this.fecha = fecha; this.hora = hora; this.cliente = cliente; this.mesa = mesa;
    }
}

// ===============================================
// EJERCICIO 7 – Vehículo – Motor – Conductor
// ===============================================
class Motor {
    private final String tipo;
    private final String numeroSerie;
    public Motor(String tipo, String numeroSerie) { this.tipo = tipo; this.numeroSerie = numeroSerie; }
}

class Conductor {
    private final String nombre;
    private final String licencia;
    private Vehiculo vehiculo;
    public Conductor(String nombre, String licencia) { this.nombre = nombre; this.licencia = licencia; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo v) { this.vehiculo = v; }
}

class Vehiculo {
    private final String patente;
    private final String modelo;
    private final Motor motor;       // agregación
    private Conductor conductor;
    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = patente; this.modelo = modelo; this.motor = motor;
    }
    public void asignarConductor(Conductor c) { this.conductor = c; c.setVehiculo(this); }
}

// ===============================================
// EJERCICIO 8 – Documento – FirmaDigital – Usuario
// ===============================================
class UsuarioFirm {
    private final String nombre;
    private final String email;
    public UsuarioFirm(String nombre, String email) { this.nombre = nombre; this.email = email; }
}

class FirmaDigital {
    private final String codigoHash;
    private final LocalDateTime fecha;
    private final UsuarioFirm usuario;   // agregación
    public FirmaDigital(String codigoHash, LocalDateTime fecha, UsuarioFirm usuario) {
        this.codigoHash = codigoHash; this.fecha = fecha; this.usuario = usuario;
    }
}

class Documento {
    private final String titulo;
    private final String contenido;
    private final FirmaDigital firma;    // composición
    public Documento(String titulo, String contenido, FirmaDigital firma) {
        this.titulo = titulo; this.contenido = contenido; this.firma = firma;
    }
}

// ===============================================
// EJERCICIO 9 – CitaMédica – Paciente – Profesional
// ===============================================
class Paciente {
    private final String nombre;
    private final String obraSocial;
    public Paciente(String nombre, String obraSocial) { this.nombre = nombre; this.obraSocial = obraSocial; }
}

class Profesional {
    private final String nombre;
    private final String especialidad;
    public Profesional(String nombre, String especialidad) { this.nombre = nombre; this.especialidad = especialidad; }
}

class CitaMedica {
    private final LocalDate fecha;
    private final LocalTime hora;
    private final Paciente paciente;        // unidireccional
    private final Profesional profesional;  // unidireccional
    public CitaMedica(LocalDate fecha, LocalTime hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha; this.hora = hora; this.paciente = paciente; this.profesional = profesional;
    }
}

// ===============================================
// EJERCICIO 10 – CuentaBancaria – ClaveSeguridad – Titular
// ===============================================
class ClaveSeguridad {
    private final String codigo;
    private final LocalDateTime ultimaModificacion;
    public ClaveSeguridad(String codigo, LocalDateTime ultimaModificacion) {
        this.codigo = codigo; this.ultimaModificacion = ultimaModificacion;
    }
}

class TitularCta {
    private final String nombre;
    private final String dni;
    private CuentaBancaria cuenta;
    public TitularCta(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public void setCuenta(CuentaBancaria c) { this.cuenta = c; }
    public CuentaBancaria getCuenta() { return cuenta; }
}

class CuentaBancaria {
    private final String cbu;
    private final double saldo;
    private final ClaveSeguridad clave; // composición
    private final TitularCta titular;   // bidireccional
    public CuentaBancaria(String cbu, double saldo, ClaveSeguridad clave, TitularCta titular) {
        this.cbu = cbu; this.saldo = saldo; this.clave = clave; this.titular = titular; titular.setCuenta(this);
    }
}

// ===============================================
// EJERCICIO 11 – Reproductor – Canción – Artista
// ===============================================
class Artista {
    private final String nombre;
    private final String genero;
    public Artista(String nombre, String genero) { this.nombre = nombre; this.genero = genero; }
    public String getNombre() { return nombre; }
}

class Cancion {
    private final String titulo;
    private final Artista artista; // unidireccional
    public Cancion(String titulo, Artista artista) { this.titulo = titulo; this.artista = artista; }
    public String getTitulo() { return titulo; }
    public Artista getArtista() { return artista; }
}

class Reproductor {
    public void reproducir(Cancion c) {
        System.out.println("Reproduciendo: " + c.getTitulo() + " de " + c.getArtista().getNombre());
    }
}

// ===============================================
// EJERCICIO 12 – Impuesto – Contribuyente – Calculadora
// ===============================================
class Contribuyente {
    private final String nombre;
    private final String cuil;
    public Contribuyente(String nombre, String cuil) { this.nombre = nombre; this.cuil = cuil; }
}

class Impuesto {
    private final double monto;
    private final Contribuyente contribuyente; // unidireccional
    public Impuesto(double monto, Contribuyente contribuyente) { this.monto = monto; this.contribuyente = contribuyente; }
    public double getMonto() { return monto; }
}

class Calculadora {
    public void calcular(Impuesto imp) {
        System.out.println("Total a pagar: " + imp.getMonto());
    }
}

// ===============================================
// EJERCICIO 13 – GeneradorQR – Usuario – CódigoQR
// ===============================================
class UsuarioQR {
    private final String nombre;
    private final String email;
    public UsuarioQR(String nombre, String email) { this.nombre = nombre; this.email = email; }
    public String getNombre() { return nombre; }
}

class CodigoQR {
    private final String valor;
    private final UsuarioQR usuario; // unidireccional
    public CodigoQR(String valor, UsuarioQR usuario) { this.valor = valor; this.usuario = usuario; }
}

class GeneradorQR {
    public void generar(String valor, UsuarioQR usuario) {
        CodigoQR qr = new CodigoQR(valor, usuario); // dependencia de creación
        System.out.println("QR generado para " + usuario.getNombre());
    }
}

// ===============================================
// EJERCICIO 14 – EditorVideo – Proyecto – Render
// ===============================================
class Proyecto {
    private final String nombre;
    private final int duracionMin;
    public Proyecto(String nombre, int duracionMin) { this.nombre = nombre; this.duracionMin = duracionMin; }
    public String getNombre() { return nombre; }
}

class Render {
    private final String formato;
    private final Proyecto proyecto; // unidireccional
    public Render(String formato, Proyecto proyecto) { this.formato = formato; this.proyecto = proyecto; }
}

class EditorVideo {
    public void exportar(String formato, Proyecto proyecto) {
        Render r = new Render(formato, proyecto); // dependencia de creación
        System.out.println("Render " + formato + " listo para " + proyecto.getNombre());
    }
}

// ===============================================
// FIN DEL TP_UML_SEBASTIÁN
// ===============================================
