import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.Inet4Address;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cliente UDP");
        DatagramSocket aSocket = null;
        System.out.println("Digite a operação (operacao:n1:n2): ");
        String mensagem = sc.next(); //som:3:4 /mul:3:4 / div:3:4 / sub:3:4 / pctg:20:100
        byte[] m = mensagem.getBytes();
        int tamanho = mensagem.length();
        try{
            InetAddress endereco = InetAddress.getByName("localhost");
            int porta = 7890;
            DatagramPacket pacoteMensagem = new DatagramPacket(m, tamanho, endereco, porta);
            aSocket = new DatagramSocket();
            aSocket.send(pacoteMensagem);
            byte[] buffer = new byte[1000];
            pacoteMensagem = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(pacoteMensagem);
            String rep = new String(pacoteMensagem.getData(), 0, pacoteMensagem.getLength());
            System.out.print("Resposta: " + rep);

        }catch(SocketException e){
            System.out.println("Socket: " + e.getMessage());
        }catch(IOException e){
            System.out.println("IO: " + e.getMessage());
        }finally{
            if(aSocket != null){
                aSocket.close();
            }
        }
    }
}
