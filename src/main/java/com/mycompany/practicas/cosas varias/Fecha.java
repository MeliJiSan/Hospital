import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    public static void main(String[] args) {
        // 1. Obtener la fecha actual
        LocalDate hoy = LocalDate.now();

        // 2. Dar formato a la fecha
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = hoy.format(formateador);

        // 3. Operar con fechas (ej. sumar 5 días)
        LocalDate fechaFutura = hoy.plusDays(5);
        
        System.out.println("Hoy: " + fechaFormateada);
        System.out.println("En 5 dias: " + fechaFutura.format(formateador));
    }
}