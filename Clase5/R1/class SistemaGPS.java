class SistemaGPS {
    public void localizar() {
        System.out.println("📍 GPS: Ubicación actual detectada.");
    }
}

class Sirena {
    public void activarSirena() {
        System.out.println("🔊 Sirena: Activada.");
    }
}

class Operador {
    private String nombre;

    public Operador(String nombre) {
        this.nombre = nombre;
    }

    public void reportarse() {
        System.out.println("👷 Operador " + nombre + " reportándose.");
    }
}
