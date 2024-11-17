class Habitacion {
    private String categoria;
    private int numeroHuespedes;

    public Habitacion(String categoria) {
        this.categoria = categoria;
        this.numeroHuespedes = 0; // Inicialmente no hay huéspedes
    }

    public String getCategoria() {
        return categoria;
    }

    public int getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public boolean checkIn(int huespedes) {
        if (numeroHuespedes + huespedes <= 2) {
            numeroHuespedes += huespedes;
            return true;
        } else {
            return false; // No se puede agregar más huéspedes
        }
    }

    public void checkOut() {
        numeroHuespedes = 0; // Todos los huéspedes salen de la habitación
    }
}