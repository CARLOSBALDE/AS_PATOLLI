package ServerCliente;

import Logica.JUEGO;
import ServerCliente.ObjetoJson;
import as_patolli.CONFIGURARPARTIDA;
import as_patolli.Gamepanel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingWorker;

public class ClienteTCP {
    public Gamepanel gp;
    ClienteTCP controlador = null;
    public String Anfitrion = "";
    public int nplayer = 0;
    public int fondo = 0;
    public int nfichas = 0;
    public int codigo;
    public String nombre="";
    public boolean inicio = false;
    public int option =0;
    public int turno=0;
    public boolean clientenuevo=false;
   
    
    
 public String [] PrimerasRespuesta;
 public String respuesta="";
    public ClienteTCP(Gamepanel gp) {
this.gp = gp;
    }

    public ClienteTCP getControlador() {

        if (controlador == null) {
            controlador = new ClienteTCP(gp);
        }

        return controlador;
    }


    public static void main(String[] args) {

    }
    
    
//    public void enviarMensajeEspecial(String mensajeEspecial) {
//    // Crear un objeto JSON para enviar al servidor
//    ObjetoJson objetoJson = new ObjetoJson(nombre, codigo, mensajeEspecial);
//
//    // Enviar el objeto JSON al servidor
//    String json = new Gson().toJson(objetoJson);
//    outputStream.writeObject(json);
//
//    // Recibir la respuesta del servidor si es necesario
//    // respuesta = (String) inputStream.readObject();
//}

    
    
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void iniciarClienteAparte() {
        // Inicia el servidor en segundo plano utilizando ExecutorService
        executorService.execute(() -> {
            ClienteExe();
        });
    }

    public void detenerCliente() {
        // Detiene el ExecutorService para finalizar el hilo cuando sea necesario
        executorService.shutdown();
    }
    

    public void ClienteExe() {
        try {
            // Establecer la conexión con el servidor en el puerto 12345
            Socket socket = new Socket("localhost", 12345);

            // Crear objetos de entrada y salida
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
              
            System.out.println(option);
            if(option==1){
                   nombre=   gp.partida.nombre.getText();
            }else if(option==2){
                   nombre = gp.nombre;
            }
            
            // Crear un objeto JSON para enviar al servidor
            ObjetoJson objetoJson = new ObjetoJson(nombre, codigo);

            // Bucle para mantener la comunicación abierta
            while (true) {
                // Enviar el objeto JSON al servidor
                String json = new Gson().toJson(objetoJson);
                outputStream.writeObject(json);

                // Recibir la respuesta del servidor
                 respuesta = (String) inputStream.readObject();
           
               
               
               if(gp.GAME==false){
                       String[] partido =    respuesta.split("/");
                        if(inicio==false && partido.length-1!=0){
                    ProcesarRespuestas(respuesta); inicio=true;
                     System.out.println("Entro");
                 }
               }
//                for (int i = 0; i < partido.length; i++) {
//                    System.out.println(partido[i]);
//                }
                
               
                 if(respuesta=="start"){
//                     gp.GAME=true;
System.out.println("JUGANDO");
                                
                 }

                System.out.println("Respuesta del servidor: " + respuesta);

                // Esperar un tiempo antes de enviar el siguiente mensaje (opcional)
                Thread.sleep(2000);
            
            }

            // No se llega aquí en este ejemplo
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

   private void ProcesarRespuestas(String respuesta) {
    try {
         PrimerasRespuesta = respuesta.split("/");
        System.out.println(PrimerasRespuesta.length);
        Anfitrion = PrimerasRespuesta[4];
        
        fondo = Integer.parseInt(PrimerasRespuesta[2]);
        nfichas = Integer.parseInt(PrimerasRespuesta[1]);
        nplayer = Integer.parseInt(PrimerasRespuesta[3]);    
        
        for (int i = 0; i < PrimerasRespuesta.length; i++) {
            System.out.println(i+" "+PrimerasRespuesta[i]);   
        }
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Manejar la excepción según tus necesidades
        e.printStackTrace();
    }
}


    public void iniciarCliente() {
        // Deshabilita el botón mientras el servidor se está iniciando

        // Inicia el servidor en segundo plano utilizando SwingWorker
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                ClienteExe();

                return null;
            }

        };

        // Ejecuta el SwingWorker
        worker.execute();

    }

}
