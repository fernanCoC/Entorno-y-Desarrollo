import java.util.ArrayList;
import java.util.Scanner;



    class ProgramaAutenticacion {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    iniciarSesion(scanner);
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        boolean usuarioEncontrado = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.nombre.equals(nombreUsuario) && usuario.contraseña.equals(contraseña)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario.nombre + "!");
                usuarioEncontrado = true;
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuario no encontrado o contraseña incorrecta. Inténtelo de nuevo.");
        }
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        boolean usuarioExistente = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.nombre.equals(nombreUsuario)) {
                usuarioExistente = true;
                break;
            }
        }

        if (usuarioExistente) {
            System.out.println("El nombre de usuario ya está en uso. Inténtelo con otro.");
        } else {
            System.out.print("Ingrese contraseña: ");
            String contraseña = scanner.nextLine();

            Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);
            listaUsuarios.add(nuevoUsuario);

            System.out.println("Registro exitoso. Ahora puede iniciar sesión con su nuevo usuario.");
        }
    }
}

