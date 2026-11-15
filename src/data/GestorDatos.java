package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    List<Tour> tours = new ArrayList<>();

    /**
     * Constructor vacio
     */
    public GestorDatos() {
    }

    /**
     * Constructor dada lista existente
     * @param tours Lista de Tours existente
     */
    public GestorDatos(List<Tour> tours) {
        this.tours = tours;
    }

    /**
     * Constructor dado archivo csv
     * @param path
     */
    public GestorDatos(String path) {
        leerDatos(path);
    }

    /**
     * Dado una ruta a un archivo csv, lee un Tour por linea.
     *
     * @param rutaArchivo Ruta al archivo csv que contiene los Tours a agregar
     */
    public void leerDatos(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while((linea = br.readLine()) != null) {
                try {
                    String[] partes = linea.strip().split(";");
                    if (partes.length < 3) { continue; }

                    String tipo = partes[0];
                    String nombre = partes[1];
                    String ciudad = partes[2];
                    Double precio = Double.parseDouble(partes[3]);

                    Tour tour = new Tour(tipo, nombre, ciudad, precio);
                    tours.add(tour);
                } catch(NumberFormatException e) {
                    System.out.println("Error al leer precio: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo: " +  e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " +  e.getMessage());
        }
    }

    /**
     * Filtrar Tours por precio
     * @param base Lista de Tours a filtrar, si es null se usa la lista interna
     * @param precio Precio por el cual filtrar
     * @param soloMayores Solo retorna Tours con precio mayor al margen
     * @return Lista de Tours filtrada por Precio
     */
    public List<Tour> filtrarPorPrecio(List<Tour> base, Double precio, boolean soloMayores) {
        List<Tour> resultado = new ArrayList<>();

        // Si el usuario no pasa una base, usamos la nuestra
        if (base == null) { base = tours; }

        for (Tour tour : base) {
            if(soloMayores) {
                if(tour.getPrecio() >= precio) {
                    resultado.add(tour);
                }
            } else {
                if(tour.getPrecio() <= precio) {
                    resultado.add(tour);
                }
            }
        }

        return resultado;
    }

    /**
     * Filtrar Tours dado un tipo
     * @param base Lista de Tours a filtrar, si es null se usa la lista interna
     * @param tipo Tipo para filtrar
     * @param invertir Solo retornar Tours que no corresponden al Tipo.
      * @return Lista de Tours filtrada por Tipo
     */
    public List<Tour> filtrarPorTipo(List<Tour> base, String tipo, boolean invertir) {
        List<Tour> resultado = new ArrayList<>();

        // Si el usuario no pasa una base, usamos la nuestra
        if (base == null) { base = tours; }

        for(Tour tour : base) {
            if (tour.getTipo().equalsIgnoreCase(tipo)) {
                if (!invertir) {
                    // Lo agregamos ya que es el mismo tipo Y no estamos invirtiendo
                    resultado.add(tour);
                }
            } else {
                if (invertir)  {
                    // Ya que estamos invirtiendo, lo agregamos PORQUE no es el mismo tipo
                    resultado.add(tour);
                }
            }
        }

        return resultado;
    }

    /**
     * Getter de la lista de Tours
     * @return Lista de Tours
     */
    public List<Tour> getTours() {
        return tours;
    }

    /**
     * Setter de la lista de Tours
     * @param tours Lista que reemplazará a la actual
     */
    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    /**
     * Metodo para imprimir el gestor de Tours
     * @return Representacion textual del gestor
     */
    @Override
    public String toString() {
        return "GestorDatos{" +
                "tours=" + tours +
                '}';
    }
}
