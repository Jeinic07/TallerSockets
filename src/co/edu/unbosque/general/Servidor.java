package co.edu.unbosque.general;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

class Servidor implements Runnable {

	private static File file;
	private static Scanner sc;
	private ArrayList<String> answers;

	private int puerto = 5000;
	private boolean servidorActivo = true; // Bandera para controlar el estado del servidor

	public Servidor(int puerto) {
		this.puerto = puerto;
		file = new File("src/co/edu/unbosque/general/Respuestas.txt");
		answers = new ArrayList<>();
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error: The file 'Answers.txt' was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: The file 'Answers.txt' couldn't be opened. Check permissions.");
			e.printStackTrace();
		}
		while (sc.hasNext()) {
			answers.add(sc.nextLine());
		}
	}

	@Override
	public void run() {
		ServerSocket servidor;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor iniciado");

			while (servidorActivo) { // Verifica la bandera antes de aceptar nuevas conexiones
				Socket sc = servidor.accept();
				System.out.println("Cliente conectado");

				DataInputStream in = new DataInputStream(sc.getInputStream());
				DataOutputStream out = new DataOutputStream(sc.getOutputStream());

				String mensaje = in.readUTF();
				String respuesta = procesarPregunta(mensaje);
				out.writeUTF(respuesta);

				sc.close();
				System.out.println("Cliente desconectado");

				if (!servidorActivo) {
					break; // Rompe el ciclo si el servidor debe desconectarse
				}
			}

			System.out.println("Servidor desconectado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String procesarPregunta(String pregunta) {
		switch (pregunta.toLowerCase()) {
		case "1": {
			return answers.get(1).toString();
		}
		case "2": {
			return answers.get(2).toString();
		}
		case "3": {
			return answers.get(3).toString();
		}
		case "4": {
			return answers.get(4).toString();
		}
		case "5": {
			return answers.get(5).toString();
		}
		case "6": {
			return answers.get(6).toString();
		}
		case "7": {
			return answers.get(7).toString();
		}
		case "8": {
			return answers.get(8).toString();
		}
		case "9": {
			return answers.get(9).toString();
		}
		case "10": {
			return answers.get(10).toString();
		}
		case "11":
			servidorActivo = false; // Cambia la bandera para desconectar el servidor
			return answers.get(21).toString();

		default:
			return  answers.get(0).toString();
		}
	}
}