public class Client {

    private String nombre;
    private int[] carroCompra;



    public Client(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int[] getCarroCompra() {
        return carroCompra;
    }



    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

}
