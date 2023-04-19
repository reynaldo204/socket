import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String HOST = "localhost";
        //Puerto del servidor

        final int PUERTO = 7000;
        DataInputStream in;
        DataOutputStream out;

        try {
            //Creo el socket para conectarme con el cliente
            Socket socketCliente = new Socket(HOST, PUERTO);
            //connexiones de los fujos en entrada y salida
            in = new DataInputStream(socketCliente.getInputStream());
            out = new DataOutputStream(socketCliente.getOutputStream());
            String telefono;

            // pide o solicita el numero de telefono de la persona
            while (true) {
                System.out.println("Digite el numero telefonico");
                telefono = sc.nextLine();
                //Envio un mensaje al cliente
                out.writeUTF(telefono);

                //Recibo el mensaje del servidor
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                socketCliente.close();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
