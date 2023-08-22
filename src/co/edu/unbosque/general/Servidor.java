package co.edu.unbosque.general;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Servidor implements Runnable {

    private int puerto = 5000;
    private boolean servidorActivo = true; // Bandera para controlar el estado del servidor

    public Servidor(int puerto) {
        this.puerto = puerto;
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
            case "1":
                return "¡Hola! ¿En qué puedo ayudarte hoy?";
            case "2":
                return "Puedes llamarme Bot. ¿Cómo estás?";
            case "3":
                return "Soy un programa de computadora, así que no tengo preferencias de color. ¿Tú tienes uno?";
            case "¿qué tiempo hace hoy?":
                return "Lo siento, no tengo acceso a información en tiempo real. ¿Hay algo más en lo que pueda asistirte?";
            case "cuéntame un chiste":
                return "Claro, aquí tienes uno: ¿Qué hace una abeja en el gimnasio? ¡Zum-ba!";
            case "¿cuál es el sentido de la vida?":
                return "Esa es una pregunta profunda. Algunos creen que es 42, según 'El Guía del Autoestopista Galáctico'.";
            case "¿puedes bailar?":
                return "No tengo un cuerpo físico, así que no puedo bailar, pero puedo ayudarte a encontrar videos de baile.";
            case "¿qué opinas sobre los gatos?":
                return "No tengo opiniones personales, pero muchas personas adoran a los gatos por su ternura y personalidades únicas.";
            case "¿puedes cantar una canción?":
                return "Claro, aquí tienes una línea de una canción: 'Vuela, vuela, sube, sube, que llegarás a lo más alto'.";
            case "¿cómo estás hoy?":
                return "Soy un programa informático, así que no tengo emociones, pero estoy aquí para ayudarte.";
            case "11":
            	servidorActivo = false; // Cambia la bandera para desconectar el servidor
                return "Se terminó el programa :3";
            	
            default:
                return "Lo siento, no entiendo tu pregunta. ¿Puedes reformularla?";
        }
    }
}