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
	private ArrayList<String> respuestas;

	private int puerto = 5000;
	private boolean servidorActivo = true; // Bandera para controlar el estado del servidor

	public Servidor(int puerto) {
		this.puerto = puerto;
		file = new File("src/co/edu/unbosque/general/Respuestas.txt");
		respuestas = new ArrayList<>();
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error: El archivo Respuestas.txt no fue encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error: El archivo Respuestas.txt no se pudo abrir, revisa los permisos.");
			e.printStackTrace();
		}
		while (sc.hasNext()) {
			respuestas.add(sc.nextLine());
		}
	}

	@Override
	public void run() {
		ServerSocket servidor;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor iniciado");
			System.out.println("Esperando cliente....\n");

			while (servidorActivo) { // Verifica la bandera antes de aceptar nuevas conexiones
				Socket sc = servidor.accept();
				System.out.println("Cliente conectado");

				DataInputStream in = new DataInputStream(sc.getInputStream());
				DataOutputStream out = new DataOutputStream(sc.getOutputStream());

				String mensaje = in.readUTF();
				String respuesta = procesarPregunta(mensaje);
				out.writeUTF(respuesta);

			
			}

			System.out.println("Servidor desconectado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String procesarPregunta(String pregunta) {
		switch (pregunta.toLowerCase()) {
		case "1": {
			return respuestas.get(1).toString();
		}
		case "2": {
			return respuestas.get(2).toString();
		}
		case "3": {
			return respuestas.get(3).toString();
		}
		case "4": {
			return respuestas.get(4).toString();
		}
		case "5": {
			return respuestas.get(5).toString();
		}
		case "6": {
			return respuestas.get(6).toString();
		}
		case "7": {
			return respuestas.get(7).toString();
		}
		case "8": {
			return respuestas.get(8).toString();
		}
		case "9": {
			return respuestas.get(9).toString();
		}
		case "10": {
			return respuestas.get(10).toString();
		}
		case "11": {
			return respuestas.get(11).toString();
		}
		case "12": {
			return respuestas.get(12).toString();
		}
		case "13": {
			return respuestas.get(13).toString();
		}
		case "14": {
			return respuestas.get(14).toString();
		}
		case "15": {
			return respuestas.get(15).toString();
		}
		case "16": {
			return respuestas.get(16).toString();
		}
		case "17": {
			return respuestas.get(17).toString();
		}
		case "18": {
			return respuestas.get(18).toString();
		}
		case "19": {
			return respuestas.get(19).toString();
		}
		case "20": {
			return respuestas.get(20).toString();
		}
		case "21": {
			servidorActivo = false; // Cambia la bandera para desconectar el servidor
			return respuestas.get(21).toString();
		}
		default: {

			return respuestas.get(0).toString();
		}

		}

	}
}