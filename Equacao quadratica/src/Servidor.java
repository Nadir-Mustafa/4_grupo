import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class Servidor {
    static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Aguardando Cliente");
            Socket socket = serverSocket.accept();
            System.out.println("Servidor Acedido");
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            int valorA = dis.readInt();
            int valorB = dis.readInt();
            int valorC = dis.readInt();


            int Delta = ((valorB * valorB) - 4 * valorA * valorC);

            if (Delta < 0) {
                System.out.println("Delta = " + Delta + "\n  Nao existem raizes pR Numeros negaticos");
                System.exit(-1);
            }

            System.out.println("Delta =" + Delta);
            dos.writeInt(Delta);

            double x1 = ((-valorB + Math.sqrt(Delta)) / (2 * valorA));
            double x2 = ((-valorB - Math.sqrt(Delta)) / (2 * valorA));


            dos.writeDouble(x1);
            dos.writeDouble(x2);

        } catch (IOException E) {
            System.out.println(E.getMessage());
        }


    }


}