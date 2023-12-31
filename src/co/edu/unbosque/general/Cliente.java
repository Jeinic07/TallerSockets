package co.edu.unbosque.general;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

class Cliente implements Runnable  {

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
                     System.out.println("Lista de preguntas:\n");
                     System.out.println("1. Hola!");
                     System.out.println("2. Cual es tu nombre?");
                     System.out.println("3. Cual es tu color favorito?");
                     System.out.println("4. Que tiempo hace hoy?");
                     System.out.println("5. Cuentame un chiste.");
                     System.out.println("6. Cual es el sentido de la vida?");
                     System.out.println("7. Puedes bailar?");
                     System.out.println("8. Que opinas sobre los gatos?");
                     System.out.println("9. Puedes cantar una cancion?");
                     System.out.println("10. Como estas hoy?");
                     System.out.println("11. Kanye West o Taylor Swift?");
                     System.out.println("12. Halo o Gears of war?");
                     System.out.println("13. Red velvet o Tres leches");
                     System.out.println("14. El maiz es un almidon?");
                     System.out.println("15. Java o PHP?");
                     System.out.println("16. Cuál es el nombre cientifico de el yarumo?");
                     System.out.println("17. Nombre dela azucar de la leche");
                     System.out.println("18. Cuál es el mejor album de Radiohead?");
                     System.out.println("19. De que está compuesta la maltosa?");
                     System.out.println("20. Para que sirve el terpeno?");
                     System.out.println("21. Salir\n");
                 
                     
                   
            	
                // Leer mensaje del usuario
                
                String mensajeUsuario = scanner.nextLine();
                
                if(mensajeUsuario.equalsIgnoreCase("salir")) {
                	 System.out.println("Cerrando cliente...");
                     break;
                	
                }
                // Enviar mensaje al servidor
                out.writeUTF(mensajeUsuario);

                // Recibir y mostrar respuesta del servidor
                String respuesta = in.readUTF();
                System.out.println("\nBot: " + respuesta+ "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}