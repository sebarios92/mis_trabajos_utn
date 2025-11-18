package tp_uml;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class TP_UML {

    public static void main(String[] args) {

        // ==== DEMO EJERCICIO 1 – Pasaporte / Foto / Titular ====
        Titular t = new Titular("Juan Pérez", "12345678");
        Pasaporte p = new Pasaporte(
                "AR-0001",
                LocalDate.now(),
                new byte[]{1, 2, 3},
                "JPG",
                t
        );
        System.out.println("Número de pasaporte del titular: " +
                t.getPasaporte().getNumero());

        // ==== DEMO EJERCICIO 14 – Proyecto / Render / EditorVideo ====
        Proyecto proyecto = new Proyecto("Video Presentación TP", 5);
        EditorVideo editor = new EditorVideo("ShotCut", "1.0");
        Render render = editor.exportar("1080p", 30, proyecto);
        // (No usamos la variable 'render' más, la creamos para mostrar la dependencia)
    }
}

// ===============================================
// EJERCICIO 1 – Pasaporte – Foto – Titular
// Composición: Pasaporte -> Foto
// Asociación bidireccional: Pasaporte <-> Titular
// ===============================================

class Foto {
    private byte[] imagen;
    private String formato;

    public Foto(byte[] imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public String getFormato() {
        return formato;
    }
}

class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // relación bidireccional SOLO con Pasaporte

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }
}

class Pasaporte {
    private String numero;
    private LocalDate fechaEmision;
    private Foto foto;          // COMPOSICIÓN
    private Titular titular;    // BIDIRECCIONAL 1:1

    public Pasaporte(String numero, LocalDate fechaEmision,
                     byte[] imagenFoto, String formatoFoto,
                     Titular titular) {

        this.numero = numero;
        this.fechaEmision = fechaEmision;

        // COMPOSICIÓN: se crea la Foto DENTRO del Pasaporte
        this.foto = new Foto(imagenFoto, formatoFoto);

        this.titular = titular;

        // BIDIRECCIONALIDAD: el titular apunta al Pasaporte
        titular.setPasaporte(this);
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public Foto getFoto() {
        return foto;
    }

    public Titular getTitular() {
        return titular;
    }
}

// ===============================================
// EJERCICIO 2 – Celular – Batería – Usuario
// (Agregación: Celular -> Bateria; asociación 1:1 con UsuarioCel)
// ===============================================

class Bateria {
    private final String modelo;
    private final int capacidad; // mAh

    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
}

class UsuarioCel {
    private final String nombre;
    private final String dni;
    private Celular celular;

    public UsuarioCel(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }
}

class Celular {
    private final String imei;
    private final String marca;
    private final String modelo;
    private Bateria bateria;     // agregación
    private UsuarioCel usuario;  // asociación 1:1 bidireccional

    public Celular(String imei, String marca, String modelo) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void asignarBateria(Bateria b) {
        this.bateria = b;
    }

    public void asignarUsuario(UsuarioCel u) {
        this.usuario = u;
        u.setCelular(this);
    }
}

// ===============================================
// EJERCICIO 3 – Libro – Autor – Editorial
// (Asociación unidireccional Libro -> Autor, Libro -> Editorial)
// ===============================================

class Autor {
    private final String nombre;
    private final String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
}

class Editorial {
    private final String nombre;
    private final String direccion;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}

class Libro {
    private final String titulo;
    private final String isbn;
    private final Autor autor;          // asociación unidireccional
    private final Editorial editorial;  // agregación

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }
}

// ===============================================
// EJERCICIO 4 – TarjetaDeCredito – Cliente – Banco
// (Agregación: TarjetaDeCredito -> Banco, bidireccional con Cliente)
// ===============================================

class Banco {
    private final String nombre;
    private final String cuit;

    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
}

class Cliente {
    private final String nombre;
    private final String dni;
    private TarjetaDeCredito tarjeta;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public TarjetaDeCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
}

class TarjetaDeCredito {
    private final String numero;
    private final LocalDate fechaVencimiento;
    private Cliente cliente;       // bidireccional
    private final Banco banco;     // agregación

    public TarjetaDeCredito(String numero, LocalDate fechaVencimiento, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.banco = banco;
    }

    public void asignarCliente(Cliente c) {
        this.cliente = c;
        c.setTarjeta(this);
    }
}

// ===============================================
// EJERCICIO 5 – Computadora – PlacaMadre – Propietario
// (Composición: Computadora -> PlacaMadre; bidireccional con Propietario)
// ===============================================

class PlacaMadre {
    private final String modelo;
    private final String chipset;

    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }
}

class Propietario {
    private final String nombre;
    private final String dni;
    private Computadora computadora;

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setComputadora(Computadora c) {
        this.computadora = c;
    }

    public Computadora getComputadora() {
        return computadora;
    }
}

class Computadora {
    private final String marca;
    private final String numeroSerie;
    private final PlacaMadre placaMadre;   // composición
    private final Propietario propietario; // bidireccional

    public Computadora(String marca, String numeroSerie,
                       PlacaMadre placaMadre, Propietario propietario) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placaMadre = placaMadre;
        this.propietario = propietario;
        propietario.setComputadora(this);
    }
}

// ===============================================
// EJERCICIO 6 – Reserva – ClienteRes – Mesa
// (Asociación unidireccional Reserva -> ClienteRes, Reserva -> Mesa)
// ===============================================

class ClienteRes {
    private final String nombre;
    private final String telefono;

    public ClienteRes(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}

class Mesa {
    private final int numero;
    private final int capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
}

class Reserva {
    private final LocalDate fecha;
    private final LocalTime hora;
    private final ClienteRes cliente; // unidireccional
    private final Mesa mesa;          // agregación

    public Reserva(LocalDate fecha, LocalTime hora,
                   ClienteRes cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
}

// ===============================================
// EJERCICIO 7 – Vehículo – Motor – Conductor
// (Agregación Vehiculo -> Motor; bidireccional con Conductor)
// ===============================================

class Motor {
    private final String tipo;
    private final String numeroSerie;

    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }
}

class Conductor {
    private final String nombre;
    private final String licencia;
    private Vehiculo vehiculo;

    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo v) {
        this.vehiculo = v;
    }
}

class Vehiculo {
    private final String patente;
    private final String modelo;
    private final Motor motor;       // agregación
    private Conductor conductor;

    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
    }

    public void asignarConductor(Conductor c) {
        this.conductor = c;
        c.setVehiculo(this);
    }
}

// ===============================================
// EJERCICIO 8 – Documento – FirmaDigital – UsuarioFirm
// (Composición Documento -> FirmaDigital; agregación con UsuarioFirm)
// ===============================================

class UsuarioFirm {
    private final String nombre;
    private final String email;

    public UsuarioFirm(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}

class FirmaDigital {
    private final String codigoHash;
    private final LocalDateTime fecha;
    private final UsuarioFirm usuario;   // agregación

    public FirmaDigital(String codigoHash, LocalDateTime fecha, UsuarioFirm usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }
}

class Documento {
    private final String titulo;
    private final String contenido;
    private final FirmaDigital firma;    // composición

    public Documento(String titulo, String contenido, FirmaDigital firma) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firma = firma;
    }
}

// ===============================================
// EJERCICIO 9 – CitaMedica – Paciente – Profesional
// (Asociación unidireccional CitaMedica -> Paciente / Profesional)
// ===============================================

class Paciente {
    private final String nombre;
    private final String obraSocial;

    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }
}

class Profesional {
    private final String nombre;
    private final String especialidad;

    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
}

class CitaMedica {
    private final LocalDate fecha;
    private final LocalTime hora;
    private final Paciente paciente;        // unidireccional
    private final Profesional profesional;  // unidireccional

    public CitaMedica(LocalDate fecha, LocalTime hora,
                      Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }
}

// ===============================================
// EJERCICIO 10 – CuentaBancaria – ClaveSeguridad – TitularCta
// (Composición CuentaBancaria -> ClaveSeguridad; bidireccional con TitularCta)
// ===============================================

class ClaveSeguridad {
    private final String codigo;
    private final LocalDateTime ultimaModificacion;

    public ClaveSeguridad(String codigo, LocalDateTime ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }
}

class TitularCta {
    private final String nombre;
    private final String dni;
    private CuentaBancaria cuenta;

    public TitularCta(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCuenta(CuentaBancaria c) {
        this.cuenta = c;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }
}

class CuentaBancaria {
    private final String cbu;
    private final double saldo;
    private final ClaveSeguridad clave; // composición
    private final TitularCta titular;   // bidireccional

    public CuentaBancaria(String cbu, double saldo,
                          ClaveSeguridad clave, TitularCta titular) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = clave;
        this.titular = titular;
        titular.setCuenta(this);
    }
}

// ===============================================
// EJERCICIO 11 – Reproductor – CancionMus – ArtistaMus
// (Asociación unidireccional CancionMus -> ArtistaMus; dependencia ReproductorMus)
// ===============================================

class ArtistaMus {
    private final String nombre;
    private final String genero;

    public ArtistaMus(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }
}

class CancionMus {
    private final String titulo;
    private final ArtistaMus artista; // unidireccional

    public CancionMus(String titulo, ArtistaMus artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArtistaMus getArtista() {
        return artista;
    }
}

class ReproductorMus {
    public void reproducir(CancionMus c) {
        System.out.println("Reproduciendo: " + c.getTitulo()
                + " de " + c.getArtista().getNombre());
    }
}

// ===============================================
// EJERCICIO 12 – Impuesto – Contribuyente – Calculadora
// (Asociación unidireccional Impuesto -> Contribuyente; dependencia Calculadora -> Impuesto)
// ===============================================

class Contribuyente {
    private final String nombre;
    private final String cuil;

    public Contribuyente(String nombre, String cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }
}

class Impuesto {
    private final double monto;
    private final Contribuyente contribuyente; // unidireccional

    public Impuesto(double monto, Contribuyente contribuyente) {
        this.monto = monto;
        this.contribuyente = contribuyente;
    }

    public double getMonto() {
        return monto;
    }
}

class Calculadora {
    public void calcular(Impuesto imp) {
        System.out.println("Total a pagar: " + imp.getMonto());
    }
}

// ===============================================
// EJERCICIO 13 – GeneradorQR – UsuarioQR – CodigoQR
// (Asociación unidireccional CodigoQR -> UsuarioQR; dependencia GeneradorQR)
// ===============================================

class UsuarioQR {
    private final String nombre;
    private final String email;

    public UsuarioQR(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }
}

class CodigoQR {
    private final String valor;
    private final UsuarioQR usuario; // unidireccional

    public CodigoQR(String valor, UsuarioQR usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }
}

class GeneradorQR {
    public CodigoQR generar(String valor, UsuarioQR usuario) {
        System.out.println("QR generado para " + usuario.getNombre());
        return new CodigoQR(valor, usuario);
    }
}

// ===============================================
// EJERCICIO 14 – Proyecto – Render – EditorVideo
// Asociación unidireccional: Render -> Proyecto
// Dependencia de creación: EditorVideo usa Proyecto y crea Render
// ===============================================

class Proyecto {
    private String nombre;
    private int duracionMin;

    public Proyecto(String nombre, int duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMin() {
        return duracionMin;
    }
}

class Render {
    private String resolucion;
    private int fps;
    private Proyecto proyecto;   // Asociación unidireccional

    public Render(String resolucion, int fps, Proyecto proyecto) {
        this.resolucion = resolucion;
        this.fps = fps;
        this.proyecto = proyecto;
    }
}

class EditorVideo {
    private String nombre;
    private String version;

    public EditorVideo(String nombre, String version) {
        this.nombre = nombre;
        this.version = version;
    }

    // Dependencia: usa Proyecto y Render, pero NO los guarda como atributos
    public Render exportar(String resolucion, int fps, Proyecto proyecto) {
        System.out.println("Exportando proyecto '" + proyecto.getNombre()
                + "' a " + resolucion + " @" + fps + "fps");
        return new Render(resolucion, fps, proyecto);
    }
}
