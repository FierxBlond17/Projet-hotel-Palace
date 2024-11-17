import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();

        // Ejemplo de check-in
        hotel.checkIn(0, 0, 2); // Check-in de 2 huéspedes en la primera habitación del primer piso
        hotel.checkIn(1, 2, 1); // Check-in de 1 huésped en la tercera habitación del segundo piso
        hotel.checkIn(2, 4, 2); // Check-in de 2 huéspedes en la quinta habitación del tercer piso

        // Mostrar estado inicial del hotel
        hotel.mostrarEstadoHotel();

        // Calcular y mostrar el total de huéspedes en todo el hotel
        int totalHuespedes = hotel.calcularTotalHuespedes();
        System.out.println("Total de huéspedes en el hotel: " + totalHuespedes);

        // Calcular y mostrar el total de huéspedes por piso
        List<Integer> huespedesPorPiso = hotel.calcularHuespedesPorPiso();
        System.out.println("\nHuéspedes por piso:");
        for (int i = 0; i < huespedesPorPiso.size(); i++) {
            System.out.println("Piso " + (i + 1) + ": " + huespedesPorPiso.get(i) + " huéspedes");
        }

        // Determinar y mostrar el piso más ocupado
        int pisoMasOcupado = hotel.obtenerPisoMasOcupado();
        System.out.println("\nEl piso más ocupado es el piso " + pisoMasOcupado);
    }
}
