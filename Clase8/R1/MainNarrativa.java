public class MainNarrativa {
    private final TransicionHistoria transicion;
    private final GestorDialogo dialogo;
    private final LogicaDecision logica;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo dialogo, LogicaDecision logica) {
        this.transicion = transicion;
        this.dialogo = dialogo;
        this.logica = logica;
    }

    public void iniciarEscena() {
        dialogo.mostrarDialogo("Te encuentras frente a una cueva oscura...");
        String decision = logica.tomarDecision();
        transicion.siguienteEscena(decision);
    }

    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision logica = new DecisionBinaria();

        MainNarrativa narrativa = new MainNarrativa(transicion, dialogo, logica);
        narrativa.iniciarEscena();
    }
}
