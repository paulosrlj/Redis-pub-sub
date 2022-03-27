package br.com.ifpb.socket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ChannelPublish {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o seu nome de usuário: ");
		String nome = sc.nextLine();

		RedisServer server = new RedisServer(nome);
		server.connectRedis();

		System.out.println("Caso deseje sair do chat, digite 'quit'");
		while (true) {
			String msg = sc.nextLine();
			if (msg.toLowerCase().equals("quit"))
				break;

			server.publishMessage(formatarMensagem(msg, nome));
		}

		server.closeConnection();
		sc.close();
	}

	public static String formatarMensagem(String mensagem, String nome) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat nowDate = new SimpleDateFormat("HH:mm:ss");

		return "[" + nowDate.format(cal.getTime()) + "]" + "[" + nome + "]: " + mensagem;
	}
}
