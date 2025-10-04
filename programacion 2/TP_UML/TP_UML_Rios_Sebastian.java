// ===============================================
// TP UML – RÍOS SEBASTIÁN
// ===============================================

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

// ------------------------------------------------
// EJERCICIO 1 – Pasaporte – Foto – Titular
// ------------------------------------------------
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
    private Foto foto;          // composición
    private Titular titular;    // asociación bidireccional 1:1
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

// ------------------------------------------------
// EJERCICIO 2 – Celular – Batería – Usuario
// ------------------------------------------------
class Bateria {
    private String modelo;
    private int capacidad;
    public Bateria(String modelo, int capacidad) { this.modelo = modelo; this.capacidad = capacidad; }
}

class UsuarioCel {
    private String nombre;
    private String dni;
    private Celular celular;
    public UsuarioCel(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public Celular getCelular() { return celular; }
    public void setCelular(Celular celular) { this.celular = celular; }
}

class Celular {
    private String imei, marca, modelo;
    private Bateria bateria;     // agregación
    private UsuarioCel usuario;  // asociación 1:1 bidireccional
    public Celular(String imei, String marca, String modelo) {
        this.imei = imei; this.marca = marca; this.modelo = modelo;
    }
    public void asignarBateria(Bateria b) { this.bateria = b; }
    public void asignarUsuario(UsuarioCel u) { this.usuario = u; u.setCelular(this); }
}

// ------------------------------------------------
// EJERCICIO 3 – Libro – Autor – Editorial
// ------------------------------------------------
class Autor {
    private String nombre, nacionalidad;
    public Autor(String nombre, String nacionalidad) { this.nombre = nombre; this.nacionalidad = nacionalidad; }
}

class Editorial {
    private String nombre, direccion;
    public Editorial(String nombre, String direccion) { this.nombre = nombre; this.direccion = direccion; }
}

class Libro {
    private String titulo, isbn;
    private Autor autor;          // asociación unidireccional
    private Editorial editorial;  // agregación
    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo; this.isbn = isbn; this.autor = autor; this.editorial = editorial;
    }
}

// ------------------------------------------------
// EJERCICIO 4 – TarjetaDeCredito – Cliente – Banco
// ------------------------------------------------
class Banco {
    private String nombre, cuit;
    public Banco(String nombre, String cuit) { this.nombre = nombre; this.cuit = cuit; }
}

class Cliente {
    private String nombre, dni;
    private TarjetaDeCredito tarjeta;
    public Cliente(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public TarjetaDeCredito getTarjeta() { return tarjeta; }
    public void setTarjeta(TarjetaDeCredito tarjeta) { this.tarjeta = tarjeta; }
}

class TarjetaDeCredito {
    private String numero;
    private LocalDate fechaVencimiento;
    private Cliente cliente;  // bidireccional
    private Banco banco;      // agregación
    public TarjetaDeCredito(String numero, LocalDate fechaVencimiento, Banco banco) {
        this.numero = numero; this.fechaVencimiento = fechaVencimiento; this.banco = banco;
    }
    public void asignarCliente(Cliente c) { this.cliente = c; c.setTarjeta(this); }
}

// ------------------------------------------------
// EJERCICIO 5 – Computadora – PlacaMadre – Propietario
// ------------------------------------------------
class PlacaMadre {
    private String modelo, chipset;
    public PlacaMadre(String modelo, String chipset) { this.modelo = modelo; this.chipset = chipset; }
}

class Propietario {
    private String nombre, dni;
    private Computadora computadora;
    public Propietario(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public void setComputadora(Computadora c) { this.computadora = c; }
    public Computadora getComputadora() { return computadora; }
}

class Computadora {
    private String marca, numeroSerie;
    private PlacaMadre placaMadre;   // composición
    private Propietario propietario; // bidireccional
    public Computadora(String marca, String numeroSerie, PlacaMadre placaMadre, Propietario propietario) {
        this.marca = marca; this.numeroSerie = numeroSerie; this.placaMadre = placaMadre;
        this.propietario = propietario; propietario.setComputadora(this);
    }
}

// ------------------------------------------------
// EJERCICIO 6 – Reserva – Cliente – Mesa
// ------------------------------------------------
class ClienteRes {
    private String nombre, telefono;
    public ClienteRes(String nombre, String telefono) { this.nombre = nombre; this.telefono = telefono; }
}

class Mesa {
    private int numero, capacidad;
    public Mesa(int numero, int capacidad) { this.numero = numero; this.capacidad = capacidad; }
}

class Reserva {
    private LocalDate fecha;
    private LocalTime hora;
    private ClienteRes cliente; // unidireccional
    private Mesa mesa;          // agregación
    public Reserva(LocalDate fecha, LocalTime hora, ClienteRes cliente, Mesa mesa) {
        this.fecha = fecha; this.hora = hora; this.cliente = cliente; this.mesa = mesa;
    }
}

// ------------------------------------------------
// EJERCICIO 7 – Vehículo – Motor – Conductor
// ------------------------------------------------
class Motor {
    private String tipo, numeroSerie;
    public Motor(String tipo, String numeroSerie) { this.tipo = tipo; this.numeroSerie = numeroSerie; }
}

class Conductor {
    private String nombre, licencia;
    private Vehiculo vehiculo;
    public Conductor(String nombre, String licencia) { this.nombre = nombre; this.licencia = licencia; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo v) { this.vehiculo = v; }
}

class Vehiculo {
    private String patente, modelo;
    private Motor motor;       // agregación
    private Conductor conductor;
    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = patente; this.modelo = modelo; this.motor = motor;
    }
    public void asignarConductor(Conductor c) { this.conductor = c; c.setVehiculo(this); }
}

// ------------------------------------------------
// EJERCICIO 8 – Documento – FirmaDigital – Usuario
// ------------------------------------------------
class UsuarioFirm {
    private String nombre, email;
    public UsuarioFirm(String nombre, String email) { this.nombre = nombre; this.email = email; }
}

class FirmaDigital {
    private String codigoHash;
    private LocalDateTime fecha;
    private UsuarioFirm usuario;   // agregación
    public FirmaDigital(String codigoHash, LocalDateTime fecha, UsuarioFirm usuario) {
        this.codigoHash = codigoHash; this.fecha = fecha; this.usuario = usuario;
    }
}

class Documento {
    private String titulo, contenido;
    private FirmaDigital firma;    // composición
    public Documento(String titulo, String contenido, FirmaDigital firma) {
        this.titulo = titulo; this.contenido = contenido; this.firma = firma;
    }
}

// ------------------------------------------------
// EJERCICIO 9 – CitaMédica – Paciente – Profesional
// ------------------------------------------------
class Paciente {
    private String nombre, obraSocial;
    public Paciente(String nombre, String obraSocial) { this.nombre = nombre; this.obraSocial = obraSocial; }
}

class Profesional {
    private String nombre, especialidad;
    public Profesional(String nombre, String especialidad) { this.nombre = nombre; this.especialidad = especialidad; }
}

class CitaMedica {
    private LocalDate fecha;
    private LocalTime hora;
    private Paciente paciente;       // unidireccional
    private Profesional profesional;  // unidireccional
    public CitaMedica(LocalDate fecha, LocalTime hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha; this.hora = hora; this.paciente = paciente; this.profesional = profesional;
    }
}

// ------------------------------------------------
// EJERCICIO 10 – CuentaBancaria – ClaveSeguridad – Titular
// ------------------------------------------------
class ClaveSeguridad {
    private String codigo;
    private LocalDateTime ultimaModificacion;
    public ClaveSeguridad(String codigo, LocalDateTime ultimaModificacion) {
        this.codigo = codigo; this.ultimaModificacion = ultimaModificacion;
    }
}

class TitularCta {
    private String nombre, dni;
    private CuentaBancaria cuenta;
    public TitularCta(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public void setCuenta(CuentaBancaria c) { this.cuenta = c; }
    public CuentaBancaria getCuenta() { return cuenta; }
}

class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad clave; // composición
    private TitularCta titular;   // bidireccional
    public CuentaBancaria(String cbu, double saldo, ClaveSeguridad clave, TitularCta titular) {
        this.cbu = cbu; this.saldo = saldo; this.clave = clave; this.titular = titular; titular.setCuenta(this);
    }
}

// ------------------------------------------------
// EJERCICIO 11 – Reproductor – Canción – Artista
// ------------------------------------------------
class Artista {
    private String nombre, genero;
    public Artista(String nombre, String genero) { this.nombre = nombre; this.genero = genero; }
    public String getNombre() { return nombre; }
}

class Cancion {
    private String titulo;
    private Artista artista; // unidireccional
    public Cancion(String titulo, Artista artista) { this.titulo = titulo; this.artista = artista; }
    public String getTitulo() { return titulo; }
    public Artista getArtista() { return artista; }
}

class Reproductor {
    public void reproducir(Cancion c) {
        System.out.println("Reproduciendo: " + c.getTitulo() + " de " + c.getArtista().getNombre());
    }
}

// ------------------------------------------------
// EJERCICIO 12 – Impuesto – Contribuyente – Calculadora
// ------------------------------------------------
class Contribuyente {
    private String nombre, cuil;
    public Contribuyente(String nombre, String cuil) { this.nombre = nombre; this.cuil = cuil; }
}

class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // unidireccional
    public Impuesto(double monto, Contribuyente contribuyente) { this.monto = monto; this.contribuyente = contribuyente; }
    public double getMonto() { return monto; }
}

class Calculadora {
    public void calcular(Impuesto imp) {
        System.out.println("Total a pagar: " + imp.getMonto());
    }
}

// ------------------------------------------------
// EJERCICIO 13 – GeneradorQR – Usuario – CódigoQR
// ------------------------------------------------
class UsuarioQR {
    private String nombre, email;
    public UsuarioQR(String nombre, String email) { this.nombre = nombre; this.email = email; }
    public String getNombre() { return nombre; }
}

class CodigoQR {
    private String valor;
    private UsuarioQR usuario; // unidireccional
    public CodigoQR(String valor, UsuarioQR usuario) { this.valor = valor; this.usuario = usuario; }
}

class GeneradorQR {
    public void generar(String valor, UsuarioQR usuario) {
        CodigoQR qr = new CodigoQR(valor, usuario); // dependencia de creación
        System.out.println("QR generado para " + usuario.getNombre());
    }
}

// ------------------------------------------------
// EJERCICIO 14 – EditorVideo – Proyecto – Render
// ------------------------------------------------
class Proyecto {
    private String nombre;
    private int duracionMin;
    public Proyecto(String nombre, int duracionMin) { this.nombre = nombre; this.duracionMin = duracionMin; }
    public String getNombre() { return nombre; }
}

class Render {
    private String formato;
    private Proyecto proyecto; // unidireccional
    public Render(String formato, Proyecto proyecto) { this.formato = formato; this.proyecto = proyecto; }
}

class EditorVideo {
    public void exportar(String formato, Proyecto proyecto) {
        Render r = new Render(formato, proyecto); // dependencia de creación
        System.out.println("Render " + formato + " listo para " + proyecto.getNombre());
    }
}

// ===============================================
// FIN DEL TP UML – RÍOS SEBASTIÁN
// ===============================================
