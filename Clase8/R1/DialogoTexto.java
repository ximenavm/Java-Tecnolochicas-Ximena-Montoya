// DialogoTexto.java
public class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(String texto) {
        System.out.println("🎭 Narrador: " + texto);
    }
}
