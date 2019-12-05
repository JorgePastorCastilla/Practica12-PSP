import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Client cliente1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Client cliente2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });
        Client cliente3 = new Client("Client 3", new int[] { 2, 3, 3, 1, 2, 6 });
        Client cliente4 = new Client("Client 4", new int[] { 6, 2, 5, 9, 1 });
        Client cliente5 = new Client("Client 5", new int[] { 9, 2, 1, 1, 1 });
        Client cliente6 = new Client("Client 6", new int[] { 1, 1, 1, 1, 1 });
        Client cliente7 = new Client("Client 7", new int[] { 3, 5, 3, 5, 6, 3 });
        Client cliente8 = new Client("Client 8", new int[] { 1, 1, 1 });

        long initaltime = System.currentTimeMillis();

        Caixa caja1 = new Caixa("Paqui",cliente1,initaltime);
        Caixa caja2 = new Caixa("Carmen",cliente2,initaltime);

        caja1.start();
        caja2.start();


    }

}
