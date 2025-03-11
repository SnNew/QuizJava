package org.example;
import java.util.Scanner;

public class Auto {
    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;
    private String estado;
    private String placa;
    private static Auto[] listaAutos = new Auto[10];

    public Auto() {
    }


    public Auto(String marca, String modelo, int anio, double kilometraje, String estado, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.placa = placa;
    }

    public static Auto[] getListaAutos() {
        return listaAutos;
    }

    public static void setListaAutos(Auto[] listaAutos) {
        Auto.listaAutos = listaAutos;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public String getEstado() {
        return estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void mostrarDetalles() {
        System.out.println("\nInformación del auto");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Año: " + anio);
        System.out.println("Kilometraje" + kilometraje);
        System.out.println("Estado" + estado);
    }

    public void actualizarKilometraje(double nuevoKilometraje) {
        if (nuevoKilometraje > this.kilometraje) {
            this.kilometraje = nuevoKilometraje;
            System.out.println("Kilometraje actualizado correctamente.");
        } else {
            System.out.println("El nuevo kilometraje debe ser mayor al actual.");
        }
    }

    public boolean esAntiguo(int anioActual) {
        return (anioActual - anio) > 15;
    }

    public boolean necesitaMantenimiento() {
        return kilometraje > 100000;
    }

    public double calcularConsumoCombustible(double distanciaRecorrida, double rendimiento) {
        return distanciaRecorrida / rendimiento;
    }

    public double combustibleRestante(double capacidadTanque, double distanciaRecorrida, double rendimiento) {
        double consumido = calcularConsumoCombustible(distanciaRecorrida, rendimiento);
        double restante = capacidadTanque - consumido;
        return restante > 0 ? restante : 0;
    }

    public static void registrarAuto(Scanner scanner) {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Año: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Kilometraje: ");
        double kilometraje = Double.parseDouble(scanner.nextLine());
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        for (int i = 0; i < listaAutos.length; i++) {
            if (listaAutos[i] == null) {
                listaAutos[i] = new Auto(marca, modelo, anio, kilometraje, estado, placa);
                System.out.println("Auto registrado correctamente!");
                return;
            }
        }
        System.out.println("No se pueden registrar más autos.");
    }
    public static void listarAutos() {
        boolean hayAutos = false;
        System.out.println("\n----- LISTA DE AUTOS -----");
        for (Auto auto : listaAutos) {
            if (auto != null) {
                System.out.println("Marca: " + auto.marca + " Modelo: " + auto.modelo);
                hayAutos = true;
            }
        }
        if (!hayAutos) {
            System.out.println("No hay autos registrados.");
        }
    }
}
