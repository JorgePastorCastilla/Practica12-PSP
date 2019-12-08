import java.util.concurrent.Semaphore;

public class Caixa extends Thread{

    String nombre;
    Client cliente;
    long initialTime;
    Semaphore semaphore;

    public Caixa(String nombre,Client cliente,long initialTime, Semaphore semaphore) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
        this.semaphore = semaphore;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        procesarCompra(this.cliente,this.initialTime);
    }

    public void procesarCompra(Client client, long timeStamp) {
        try {

            semaphore.acquire();
            System.out.println("La cajera " + this.nombre +
                    " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + client.getNombre() +
                    " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+ "seg");
            for (int i = 0; i < client.getCarroCompra().length; i++) {
                this.esperarXsegundos(client.getCarroCompra()[i]);
//                System.out.println("Procesado el producto " + (i + 1) +
//                        " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
            }
            System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " +
                    client.getNombre() + " EN EL TIEMPO: " +
                    (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
