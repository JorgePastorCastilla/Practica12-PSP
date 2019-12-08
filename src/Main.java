import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        /*
        Client cliente1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Client cliente2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });
        Client cliente3 = new Client("Client 3", new int[] { 2, 3, 3, 1, 2, 6 });
        Client cliente4 = new Client("Client 4", new int[] { 6, 2, 5, 9, 1 });
        Client cliente5 = new Client("Client 5", new int[] { 9, 2, 1, 1, 1 });
        Client cliente6 = new Client("Client 6", new int[] { 1, 1, 1, 1, 1 });
        Client cliente7 = new Client("Client 7", new int[] { 3, 5, 3, 5, 6, 3 });
        Client cliente8 = new Client("Client 8", new int[] { 1, 1, 1 });
        */

        Client cliente1 = new Client("Client 1", new int[] { 1, 1, 1, 1, 1, 1 });
        Client cliente2 = new Client("Client 2", new int[] { 1, 1, 1, 1, 1 });
        Client cliente3 = new Client("Client 3", new int[] { 1, 1, 1, 1, 1, 1 });
        Client cliente4 = new Client("Client 4", new int[] { 1, 1, 1, 1, 1 });
        Client cliente5 = new Client("Client 5", new int[] { 1, 1, 1, 1, 1 });
        Client cliente6 = new Client("Client 6", new int[] { 1, 1, 1, 1, 1 });
        Client cliente7 = new Client("Client 7", new int[] { 1, 1, 1, 1, 1, 1 });
        Client cliente8 = new Client("Client 8", new int[] { 1, 1, 1 });

        long initaltime = System.currentTimeMillis();
        //Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(2);
        Caixa caja1 = new Caixa("Caja1",cliente1,initaltime,semaphore2);
        Caixa caja2 = new Caixa("Caja2",cliente2,initaltime,semaphore2);

        caja1.start();
        caja2.start();

        List<Client> clientes = new ArrayList<Client>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        clientes.add(cliente6);
        clientes.add(cliente7);
        clientes.add(cliente8);


        for(int index = 2;index < 8; index++){
            //WAITING = ESPERANDO
            //TERMINATED = HA TERMINADO Y ESTA LIBRE
            //TIMED_WAITING = ESTA ESPERANDO
            //System.out.println("caja1 state : " + caja1.getState());
            String caja1State = "caja1 state : " + caja1.getState();
            String caja2State = "caja2 state : " + caja2.getState();
            if(caja1.getState().toString() == "TERMINATED"){
                caja1.setCliente(clientes.get(index));
                caja1.run();
            }else if (caja2.getState().toString() == "TERMINATED") {
                caja2.setCliente(clientes.get(index));
                caja2.start();
            }else{
                index--;
            }
        }
        /*
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("caja1 state : " + caja1.getState());
            System.out.println("caja2 state : " + caja2.getState());
            if(false){
                System.out.println("caja1 interrupted");
            }
            if(caja2.semaphore.isFair()){
                System.out.println("caja2 interrupted");
            }
        }*/


    }

}
