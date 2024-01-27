/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerCliente;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ObtenerDireccionIPv4 {
 static InetAddress addr;
    public static void main(String[] args) {
        try {
            // Obtener todas las interfaces de red
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();

                // Filtrar las interfaces de red que son interfaces de loopback o están inactivas
                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                // Obtener las direcciones IP asociadas con la interfaz
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                
                while (addresses.hasMoreElements()) {
                     addr = addresses.nextElement();

                    // Filtrar las direcciones IPv4
                    if (addr.getAddress().length == 4) {
                        System.out.println("Interfaz: " + iface.getDisplayName());
                        System.out.println("Dirección IPv4: " + addr.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
    
        
    }
      public InetAddress getIPV4(){
          return addr;
      }
}
