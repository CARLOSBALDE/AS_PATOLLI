package ServerCliente;

import as_patolli.*;
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.SwingWorker;

public class ServidorTCP {
    public Gamepanel gp;
    public ServidorTCP controlador = null;
    public int nplayer = 0, fondo = 0, nfichas = 0;
    public int CanClientes = 0;
    private static final int MAX_CLIENTES = 4;
    private static final int MAX_CLIENTES_ACTIVOS = 2;
    public String anfitrion ;
    boolean clientenuevo = false;
    public int turno = 0;
    
    ArrayList<String> Nombres = new ArrayList<>();
    // Agrega un cerrojo para controlar la concurrencia
    private final ReentrantLock lock = new ReentrantLock();

    private final List<ObjectOutputStream> outputStreams = new ArrayList<>();
    public static void main(String[] args) {

    }


    
   public ServidorTCP (Gamepanel gp) {
        this.gp = gp;
    }
    

    public ServidorTCP getControlador() {
        if (controlador == null) {
            return controlador = new ServidorTCP(gp);
        }
        return controlador;
    }

    public int getNplayer() {
        return nplayer;
    }

    public void setNplayer(int nplayer) {
        this.nplayer = nplayer;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public int getNfichas() {
        return nfichas;
    }

    public void setNfichas(int nfichas) {
        this.nfichas = nfichas;
    }

    public void iniciar() {
        String[] args = new String[2];
        main(args);
    }

    public void iniciarServidor() {
        // Deshabilita el botón mientras el servidor se está iniciando

        // Inicia el servidor en segundo plano utilizando SwingWorker
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simula el inicio del servidor (puedes reemplazar esto con tu código real del servidor)

                // Crear un pool de hilos con capacidad para MAX_CLIENTES_ACTIVOS
                ExecutorService pool = Executors.newFixedThreadPool(MAX_CLIENTES_ACTIVOS);

                try {
                    // Crear un servidor en el puerto 12345
                    ServerSocket serverSocket = new ServerSocket(12345);
                    System.out.println("Servidor esperando conexiones...");

                    // Bucle para aceptar hasta MAX_CLIENTES conexiones
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        // Esperar a que un cliente se conecte
                        Socket socket = serverSocket.accept();
                        System.out.println("Cliente conectado desde " + socket.getInetAddress());

                        // Crear un objeto de manejador de cliente y ejecutarlo en el pool de hilos
                        pool.execute(new ClienteHandler(socket));
                    }

                    // Cerrar el pool de hilos después de haber aceptado MAX_CLIENTES conexiones
                    pool.shutdown();

                    // Cerrar el serverSocket
                    serverSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

        };

        // Ejecuta el SwingWorker
        worker.execute();
    }

    public void Ruletera(){
                   
        for (int i = 0; i < outputStreams.size(); i++) {
            
            if(outputStreams.get(i)==null){
                removeClient(outputStreams.get(i));
            }
            System.out.println(outputStreams.get(i));
        }
    }
    
    class ClienteHandler implements Runnable {

        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStreams.add(outputStream);
                CanClientes++;
                clientenuevo = true;
            } catch (IOException e) {
                   e.printStackTrace();
                
            }
        }

        @Override
        public void run() {
            try {
                lock.lock();  // Adquirir el cerrojo antes de ejecutar el código crítico
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                    while (true) {
                        String json = (String) inputStream.readObject();
                        System.out.println("Objeto JSON recibido desde " + socket.getInetAddress() + ": " + json);
                        ObjetoJson objetoJson = new Gson().fromJson(json, ObjetoJson.class);
                        String respuesta = "";
                        if (CanClientes > 1 && clientenuevo == true) {
                            respuesta = "/" + nfichas + "/" + fondo + "/" + CanClientes + "/" + anfitrion;
                            clientenuevo = false;
                        } 
                        else if (gp.GAME==true){
                            
                        }
                        
                        if(gp.GameThread==null ){
                        respuesta="start";
                            
                            
                        }
                        
                        for (ObjectOutputStream outputStream : outputStreams) {
                            outputStream.writeObject(respuesta);
                            outputStream.flush();
                        }
                    }
                       
                   
                } finally {
                    lock.unlock();  // Liberar el cerrojo después de ejecutar el código crítico
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            
        }
    }
    
    
    
    public   void removeClient(ObjectOutputStream outputStream) {
    outputStreams.remove(outputStream);
    CanClientes--;

    // Notificar a los demás clientes sobre la desconexión
    String mensajeDesconexion = "/DESCONEXION/" + CanClientes + "/";
    for (ObjectOutputStream otherOutputStream : outputStreams) {
        try {
            otherOutputStream.writeObject(mensajeDesconexion);
            otherOutputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

}