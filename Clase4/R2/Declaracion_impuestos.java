import java.util.Objects;

// Record para DeclaracionImpuestos
record DeclaracionImpuestos(String rfcContribuyente, double montoDeclarado) { }

// Clase CuentaFiscal
class CuentaFiscal {
    private final String rfc;
    private double saldoDisponible;

    public CuentaFiscal(String rfc, double saldoDisponible) {
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.rfc = rfc;
        this.saldoDisponible = saldoDisponible;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public boolean validarRFC(DeclaracionImpuestos declaracion) {
        return Objects.equals(this.rfc, declaracion.rfcContribuyente());
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crear una declaración de impuestos
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("XAXX010101000", 8700.0);

        // Crear una cuenta fiscal
        CuentaFiscal cuenta = new CuentaFiscal("XAXX010101000", 9500.0);

        // Mostrar la información de ambos
        System.out.println("📄 Declaración enviada por RFC: " + declaracion.rfcContribuyente() + " por $" + declaracion.montoDeclarado());
        System.out.println("🏦 Cuenta fiscal registrada con RFC: " + cuenta.getRfc() + ", saldo disponible: $" + cuenta.getSaldoDisponible());

        // Validar si el RFC coincide y mostrar el resultado
        boolean rfcValido = cuenta.validarRFC(declaracion);
        System.out.println("✅ ¿RFC válido para esta cuenta?: " + rfcValido);

        // Crear una segunda cuenta fiscal con un RFC diferente para probar la validación
        CuentaFiscal cuenta2 = new CuentaFiscal("RFC_DIFERENTE", 10000.0);
        boolean rfcValido2 = cuenta2.validarRFC(declaracion);
        System.out.println("❌ ¿RFC válido para la segunda cuenta?: " + rfcValido2);
    }
}

