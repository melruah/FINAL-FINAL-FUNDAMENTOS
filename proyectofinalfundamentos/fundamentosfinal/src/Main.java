
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        ColeccionDatos coleccionDatos = new ColeccionDatos("Medellin.csv");
        new ArrayList();
        new Main();
        Scanner sc = new Scanner(System.in);
        int validacion ;
        boolean ciclo = true;

        while(ciclo) {
            System.out.println("|-|-|-|-|-|-|-|-|BIENVENIDO AL MENÚ|-|-|-|-|-|-|-|-|-|-|-|-|-|");
            System.out.println("|-|-|-|-|     1 PARA LEER EL ARCHIVO                 |-|-|-|-|");
            System.out.println("|-|-|-|-|     2 PARA CREAR UN ARCHIVO                |-|-|-|-|");
            System.out.println("|-|-|-|-|     3 PARA REALIZAR PROMEDIO DE TMAX       |-|-|-|-|");
            System.out.println("|-|-|-|-|     4 PARA REALIZAR SUMA  DE  TMIN         |-|-|-|-|");
            System.out.println("|-|-|-|-|     5 PASAR SACAR EL MAYOR DE TAVG         |-|-|-|-|");
            System.out.println("|-|-|-|-|     6 PASAR SACAR EL MENOR DE TAVG         |-|-|-|-|");
            System.out.println("|-|-|-|-|     7 PARA SALIR DEL PROGRAMA              |-|-|-|-|");
            System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|- |-|-|-|-|");
            validacion = sc.nextInt();
            switch(validacion) {
            case 1:
                coleccionDatos.setColeccionDatos();
                break;
            case 2:
                coleccionDatos.crearCSVNuevo();
                break;
            case 3:
                System.out.println("El promedio de Tmax es: " + coleccionDatos.avgTmax());
                break;
            case 4:
                System.out.println("La suma de Tmin es: " + coleccionDatos.sumTmin());
                break;
            case 5:
                System.out.println("El mayor Tavg es: " + coleccionDatos.maxTavg());
                break;
            case 6:
                System.out.println("El menor Tavg es: " + coleccionDatos.minTavg());
                break;
            case 7:
                System.out.println("Gracias por usar el programa ");
                ciclo = false;
            }
        }

    }
}