// TransicionSimple.java
public class TransicionSimple implements TransicionHistoria {
    @Override
    public void siguienteEscena(String decision) {
        if ("1".equals(decision)) {
            System.out.println("➡️ Has elegido explorar la cueva misteriosa.");
        } else {
            System.out.println("➡️ Has decidido regresar al pueblo.");
        }
    }
}
