package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println(" \n Menú interactivo ");
            System.out.println("1. Registrar Auto");
            System.out.println("2. Listar Autos");
            System.out.println("3. Mostrar detalles de un Auto");
            System.out.println("4. Actualizar kilometraje de un Auto");
            System.out.println("5. Ver si el Auto es antiguo");
            System.out.println("6. Ver si el Auto necesita mantenimiento");
            System.out.println("7. Calcular consumo de combustible");
            System.out.println("8. Calcular combustible restante");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    Auto.registrarAuto(scanner);
                    break;
                case 2:
                    Auto.listarAutos();
                    break;
                case 3:
                    System.out.print("Ingrese la placa del auto: ");
                    String placa = scanner.nextLine();
                    Auto auto = buscarAutoPorPlaca(placa);
                    if (auto != null) {
                        auto.mostrarDetalles();
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la placa del auto: ");
                    placa = scanner.nextLine();
                    auto = buscarAutoPorPlaca(placa);
                    if (auto != null) {
                        System.out.print("Ingrese el nuevo kilometraje: ");
                        double nuevoKilometraje = Double.parseDouble(scanner.nextLine());
                        auto.actualizarKilometraje(nuevoKilometraje);
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la placa del auto: ");
                    placa = scanner.nextLine();
                    auto = buscarAutoPorPlaca(placa);
                    if (auto != null) {
                        if (auto.esAntiguo(2025)) {
                            System.out.println("El auto es antiguo.");
                        } else {
                            System.out.println("El auto no es antiguo.");
                        }
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese la placa del auto: ");
                    placa = scanner.nextLine();
                    auto = buscarAutoPorPlaca(placa);
                    if (auto != null) {
                        if (auto.necesitaMantenimiento()) {
                            System.out.println("El auto necesita mantenimiento.");
                        } else {
                            System.out.println("El auto no necesita mantenimiento.");
                        }
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese la placa del auto: ");
                    placa = scanner.nextLine();
                    auto = buscarAutoPorPlaca(placa);
                    if (auto != null) {
                        System.out.print("Ingrese la distancia recorrida en km: ");
                        double distancia = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese el rendimiento del vehículo en km/l: ");
                        double rendimiento = Double.parseDouble(scanner.nextLine());
                        double consumo = auto.calcularConsumoCombustible(distancia, rendimiento);
                        System.out.println("El auto consumió " + consumo + " litros de combustible.");
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese la placa del auto: ");
                    placa = scanner.nextLine();
                    auto = buscarAutoPorPlaca(placa);
                    if (auto != null) {
                        System.out.print("Ingrese la capacidad del tanque en litros: ");
                        double capacidad = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese la distancia recorrida en km: ");
                        double distanciaRecorrida = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese el rendimiento del vehículo en km/l: ");
                        double rendimientoTanque = Double.parseDouble(scanner.nextLine());
                        double combustibleRestante = auto.combustibleRestante(capacidad, distanciaRecorrida, rendimientoTanque);
                        System.out.println("Combustible restante: " + combustibleRestante + " litros.");
                    } else {
                        System.out.println("Auto no encontrado.");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }

    public static Auto buscarAutoPorPlaca(String placa) {
        for (Auto auto : Auto.getListaAutos()) {
            if (auto != null && auto.getPlaca().equals(placa)) {
                return auto;
            }
        }
        return null;
    }
}