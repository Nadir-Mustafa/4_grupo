import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 12345)) {
            Funcao(socket);

        } catch (IOException E) {
            System.out.println(E.getMessage());
        }
    }

    public static void Funcao(Socket socket) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        int valorA;

        System.out.println("====Funcao Quadratica=======");
        System.out.println("Ax^2 + Bx + C = 0");

        System.out.println("Digite o valor de A: ");
        valorA = Teclado.nextInt();
        dos.writeInt(valorA);


        if (valorA == 0) {
            System.out.println("Erro" + "Digite um valor diferente de 0");
            Funcao(socket); }

        System.out.println("Digite o valor de B: ");
        int valorB = Teclado.nextInt();
        dos.writeInt(valorB);

        System.out.println("Digite o valor de C: ");
        int valorC = Teclado.nextInt();
        dos.writeInt(valorC);

        System.out.println("Delta = " + dis.readInt());

        System.out.println("x1 = " + dis.readDouble());
        System.out.println("x2 = " + dis.readDouble());

    }

}
