// Clase Pasajero
class Pasajero {
    private String nombre;
    private String pasaporte;

    public Pasajero(String nombre, String pasaporte) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }
}

// Clase Vuelo
class Vuelo {
    private final String codigoVuelo;
    private String destino;
    private String horaSalida;
    private Pasajero asientoReservado;

    public Vuelo(String codigo, String destino, String horaSalida) {
        this.codigoVuelo = codigo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null;
    }

    public boolean reservarAsiento(Pasajero p) {
        if (asientoReservado == null) {
            this.asientoReservado = p;
            return true;
        }
        return false;
    }

    public boolean reservarAsiento(String nombre, String pasaporte) {
        if (asientoReservado == null) {
            this.asientoReservado = new Pasajero(nombre, pasaporte);
            return true;
        }
        return false;
    }

    public void cancelarReserva() {
        this.asientoReservado = null;
    }

    public String obtenerItinerario() {
        String pasajeroInfo = (asientoReservado != null) ? asientoReservado.getNombre() : "[Sin reserva]";
        return "Código: " + codigoVuelo + "\n" +
               "Destino: " + destino + "\n" +
               "Salida: " + horaSalida + "\n" +
               "Pasajero: " + pasajeroInfo;
    }
}

// Clase Principal
public class Principal {
    public static void main(String[] args) {
        // Crear un pasajero y un vuelo
        Pasajero pasajero1 = new Pasajero("Ana Martínez", "AB123456");
        Vuelo vuelo1 = new Vuelo("UX123", "París", "14:30");

        // Reservar el asiento en el vuelo
        if (vuelo1.reservarAsiento(pasajero1)) {
            System.out.println("Reserva realizada con éxito.");
        } else {
            System.out.println("No se pudo realizar la reserva.");
        }

        // Mostrar el itinerario
        System.out.println("\n Itinerario del vuelo:");
        System.out.println(vuelo1.obtenerItinerario());

        // Cancelar la reserva
        System.out.println("\n Cancelando reserva...");
        vuelo1.cancelarReserva();

        // Mostrar nuevamente el itinerario
        System.out.println("\n Itinerario del vuelo:");
        System.out.println(vuelo1.obtenerItinerario());

        // Reservar un asiento en el vuelo usando nombre y pasaporte
        if (vuelo1.reservarAsiento("Mario Gonzalez", "CD789012")) {
            System.out.println("\n Reserva realizada con éxito.");
        } else {
            System.out.println("\n No se pudo realizar la reserva.");
        }

        // Mostrar el itinerario final
        System.out.println("\n Itinerario del vuelo:");
        System.out.println(vuelo1.obtenerItinerario());
    }
}

