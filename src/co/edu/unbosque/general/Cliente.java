package co.edu.unbosque.general;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Cliente implements Runnable {

    private int puerto = 5000;
    

    public Cliente(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            // Crear el socket para conectarse con el servidor
            Socket sc = new Socket("127.0.0.1", puerto);

            // Configurar streams de entrada y salida
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            
            while (true) {
        
                     // Mostrar lista de preguntas
                     System.out.println("Lista de preguntas:");
                     System.out.println("1. ¡Hola!");
                     System.out.println("2. ¿Cuál es tu nombre?");
                     System.out.println("3. ¿Cuál es tu color favorito?");
                     System.out.println("4. ¿Qué tiempo hace hoy?");
                     System.out.println("5. Cuéntame un chiste.");
                     System.out.println("6. ¿Cuál es el sentido de la vida?");
                     System.out.println("7. ¿Puedes bailar?");
                     System.out.println("8. ¿Qué opinas sobre los gatos?");
                     System.out.println("9. ¿Puedes cantar una canción?");
                     System.out.println("10. ¿Cómo estás hoy?");
                     System.out.println("11. Salir");
                     System.out.print("Selecciona una opción: ");
                     
                   
            	
                // Leer mensaje del usuario
                
                String mensajeUsuario = scanner.nextLine();

                // Enviar mensaje al servidor
                out.writeUTF(mensajeUsuario);

                // Recibir y mostrar respuesta del servidor
                String respuesta = in.readUTF();
                System.out.println("Bot: " + respuesta);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}