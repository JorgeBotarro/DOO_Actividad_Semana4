import data.GestorDatos;
import model.Tour;

/**
 * Punto de entrada del app de Llanquihue Tour
 */
void main() {
    GestorDatos gd = new GestorDatos("src/resources/data.txt");

    // Mostrar todos los tours
    System.out.println("========================================");
    System.out.println("Todos los Tours: ");
    System.out.println("========================================");
    List<Tour> tours = gd.getTours();
    for (Tour tour : tours) {
        System.out.println("\t" + tour.toString());
    }

    // Solo mostrar tours menores que 19_000.0
    System.out.println("========================================");
    System.out.println("Todos los Tours menores que 19000.0: ");
    System.out.println("========================================");
    List<Tour> toursPorPrecio = gd.filtrarPorPrecio(tours, 19_000.0, false);
    for (Tour tour : toursPorPrecio) {
        System.out.println("\t" + tour.toString());
    }

    // Solo mostrar tours menores que 19_000 Y de tipo Deportivo
    System.out.println("========================================");
    System.out.println("Todos los Deportivos menores que 19000.0");
    System.out.println("========================================");
    List<Tour> toursDeportivos = gd.filtrarPorTipo(toursPorPrecio, "Deportivo", false);
    for (Tour tour : toursDeportivos) {
        System.out.println("\t" + tour.toString());
    }
}
