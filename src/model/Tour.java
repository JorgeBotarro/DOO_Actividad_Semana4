package model;

/**
 * Datos del Tour
 */
public class Tour {
    private String tipo;
    private String nombre;
    private String ciudad;
    private Double precio;

    /**
     * Constructor vacio
     */
    public Tour() {
    }

    /**
     * Constructor completo
     *
     * @param tipo Tipo de Tour
     * @param nombre Nombre del Tour
     * @param ciudad Ciudad del Tour
     * @param precio Precio del Tour
     */
    public Tour(String tipo, String nombre, String ciudad, Double precio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.precio = precio;
    }

    /**
     * Getter del Tipo de Tour (Turismo, Deportivo, Musical, Empresarial, etc)
     * @return Tipo de Tour
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del Tipo de Tour (Turismo, Deportivo, Musical, Empresarial, etc)
     * @param tipo Tipo de Tour
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter del Nombre del Tour
     * @return Nombre del Tour
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del Nombre del Tour
     * @param nombre Nuevo Nombre del Tour
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la Ciudad del Tour
     * @return Ciudad del Tour
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Setter de la Nueva Ciudad del Tour
     * @param ciudad Nueva Ciudad del Tour
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Getter del Precio del Tour por persona
     * @return Precio por persona del Tour
     */
    public Double getPrecio() {
        return precio;
    }
    /**
     * Setter del Nuevo Precio del Tour por persona
     * @param precio Nuevo Precio por persona del Tour
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Metodo para imprimir el Tour
     * @return Representación textual del Tour
     */
    @Override
    public String toString() {
        return "Tour{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", precio=" + precio +
                '}';
    }
}
