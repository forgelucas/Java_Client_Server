package lab4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(7890);
            while (true) {
                byte[] buffer = new byte[1000];
                DatagramPacket requisicao = new DatagramPacket(buffer, buffer.length);
                socket.receive(requisicao);
                String mensagem = new String(requisicao.getData(), 0, requisicao.getLength());
                String[] partes = mensagem.split(":");
                if (partes.length == 3) {
                    String operacao = partes[0];
                    int primeiroValor = Integer.parseInt(partes[1]);
                    int segundoValor = Integer.parseInt(partes[2]);
                    int resultado = 0;

                    if (operacao.equals("som")) {
                        resultado = primeiroValor + segundoValor;
                    }
                    else if (operacao.equals("sub")) {
                        resultado = primeiroValor - segundoValor;
                    }
                    else if (operacao.equals("mul")) {
                        resultado = primeiroValor * segundoValor;
                    }
                    else if (operacao.equals("div")) {
                        if (segundoValor != 0) {
                            resultado = primeiroValor / segundoValor;
                        } else {
                            resultado = 0;
                        }
                    }
                    else if (operacao.equals("pctg")) {
                        resultado = (primeiroValor * 100) / segundoValor;
                    }
                    String resposta = "" +resultado;
                    System.out.println("Resultado: " + resultado);
                    DatagramPacket respostaPacket = new DatagramPacket(resposta.getBytes(), resposta.length(),
                            requisicao.getAddress(), requisicao.getPort());
                    socket.send(respostaPacket);
                } else {
                    System.out.println("Mensagem inválida: " + mensagem);
                }
            }
        } catch (SocketException ex) {
            System.out.println("Socket: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IO: " + ex.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
