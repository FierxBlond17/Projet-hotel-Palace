import java.util.*;

class Hotel {
    private List<List<Habitacion>> pisos;

    public Hotel() {
        pisos = new ArrayList<>();
        String[] categorias = {"Económica", "Estándar", "Premium"};

        Random random = new Random();

        // Configuración del hotel con 5 pisos y 5 habitaciones por piso
        for (int i = 0; i < 5; i++) {
            List<Habitacion> piso = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String categoria = categorias[random.nextInt(categorias.length)];
                piso.add(new Habitacion(categoria));
            }
            pisos.add(piso);
        }
    }

    public boolean checkIn(int piso, int habitacion, int huespedes) {
        if (piso >= 0 && piso < pisos.size() && habitacion >= 0 && habitacion < pisos.get(piso).size()) {
            return pisos.get(piso).get(habitacion).checkIn(huespedes);
        }
        return false; // Parámetros de piso o habitación inválidos
    }

    public void checkOut(int piso, int habitacion) {
        if (piso >= 0 && piso < pisos.size() && habitacion >= 0 && habitacion < pisos.get(piso).size()) {
            pisos.get(piso).get(habitacion).checkOut();
        }
    }

    // Método para calcular el total de huéspedes en todo el hotel
    public int calcularTotalHuespedes() {
        int totalHuespedes = 0;
        for (List<Habitacion> piso : pisos) {
            for (Habitacion habitacion : piso) {
                totalHuespedes += habitacion.getNumeroHuespedes();
            }
        }
        return totalHuespedes;
    }

    // Método para calcular el total de huéspedes por piso
    public List<Integer> calcularHuespedesPorPiso() {
        List<Integer> totalHuespedesPorPiso = new ArrayList<>();
        for (List<Habitacion> piso : pisos) {
            int totalHuespedes = 0;
            for (Habitacion habitacion : piso) {
                totalHuespedes += habitacion.getNumeroHuespedes();
            }
            totalHuespedesPorPiso.add(totalHuespedes);
        }
        return totalHuespedesPorPiso;
    }

    // Método para determinar el piso con más huéspedes
    public int obtenerPisoMasOcupado() {
        List<Integer> totalHuespedesPorPiso = calcularHuespedesPorPiso();
        int pisoMasOcupado = 0;
        int maxHuespedes = 0;

        for (int i = 0; i < totalHuespedesPorPiso.size(); i++) {
            if (totalHuespedesPorPiso.get(i) > maxHuespedes) {
                maxHuespedes = totalHuespedesPorPiso.get(i);
                pisoMasOcupado = i;
            }
        }

        return pisoMasOcupado + 1; // +1 porque los pisos se cuentan desde 1
    }

    public void mostrarEstadoHotel() {
        for (int i = 0; i < pisos.size(); i++) {
            System.out.println("Piso " + (i + 1) + ":");
            for (int j = 0; j < pisos.get(i).size(); j++) {
                Habitacion habitacion = pisos.get(i).get(j);
                System.out.println("  Habitación " + (j + 1) + " - Categoría: " + habitacion.getCategoria() +
                        ", Huéspedes: " + habitacion.getNumeroHuespedes());
            }
        }
    }
}
