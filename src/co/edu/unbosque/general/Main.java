package co.edu.unbosque.general;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el servidor en un hilo separado
        Servidor servidor = new Servidor(12345);
        Thread serverThread = new Thread(servidor);
        serverThread.start();

        // Esperar a que el servidor esté listo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Crear un cliente para interactuar con el chat bot
        Cliente cliente = new Cliente(12345);
        Thread clientThread = new Thread(cliente);
        clientThread.start();
    }
}