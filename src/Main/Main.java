package Main;

import java.util.ArrayList;
import java.util.Random;

import Carrera.Coche;

public class Main {

	public static void main(String[] args) {

//		Se debe simular una carrera de coches en un circuito cerrado.
//		La carrera constará de N pilotos, cada uno con su identificador asignado, siendo N una cantidad definida
//		en una variable (no hace falta pedir al usuario este valor, lo pondremos desde código).
//		Los N pilotos serán hilos independientes, y tienen que hacer un total de 10 vueltas.
//		En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
//		El hilo principal, una vez han salido los coches, va mostrando cada segundo cómo está actualmente el orden desde
//		el primero (el que toma la delantera) hasta el décimo (el que va último), indicando el identificador, las vueltas
//		que lleva y la posición de los participantes.
//		Ejemplo de mensaje que proyectaría el main en un segundo aleatorio dentro de toda la carrera:
//		Coche Vuelta Posición
//		==-------------------
//		C4 3 1
//		C2 3 2
//		C6 3 3
//		C10 2 4
//		C3 2 5
//		C1 1 6
//		C9 1 7
//		C8 1 8
//		C5 0 9
//		C7    0      10

		ArrayList<Coche> clasificacionCarrera = new ArrayList<>();
		Random random = new Random();

		int nCoches = 5;
		int totalVueltas = 10;

		for (int i = 0; i < (nCoches); i++) {
			int dorsalCoche = random.nextInt(100);
			int dorsal = dorsalCoche;
			Coche coche = new Coche(dorsal, clasificacionCarrera, totalVueltas);
			clasificacionCarrera.add(coche);
		}

		for (Coche coche : clasificacionCarrera) {
			coche.start();
		}

		int cochesTerminados = 0;
		while (cochesTerminados <= nCoches) {
			try {
				Thread.sleep(1000); // Esperar 1 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("  Coche     Vuelta      Posición     LapTime  ");
			System.out.println("╔══════════════════════════════════════════════╗");
			

			for (Coche coche : clasificacionCarrera) {
				System.out.println("  " + coche.getDorsal() + "          " + coche.getVueltas() + "            "
						+ coche.getPosicion() + "          " + String.format("%.3f", coche.getTiempoPorVuelta()));

				if (coche.getVueltas() == totalVueltas) {
					cochesTerminados++;
				}
			}
			System.out.println("╚══════════════════════════════════════════════╝");
		}
		
		

		int primero = 0;
		int segundo = 0;
		int tercero = 0;
		for (Coche coche : clasificacionCarrera) {
			if (coche.getPosicion() == 1) {
				primero = coche.getDorsal();
			}
			if (coche.getPosicion() == 2) {
				segundo = coche.getDorsal();
			}
			if (coche.getPosicion() == 3) {
				tercero = coche.getDorsal();
			}

		}
		
		System.out.println("\t╔═════════════════════════════╗");
		System.out.println("\t|             " + primero + "              |");
		System.out.println("\t|    " + segundo + "   ********            |");
		System.out.println("\t|********************    " + tercero + "   |");
		System.out.println("\t|*****************************|");
		System.out.println("\t╚═════════════════════════════╝\n\n");

		System.out.println("\t******************************");
		System.out.println("\t*     ¡Hasta la próxima!     *");
		System.out.println("\t*   ¡Vuelva pronto!, GAAS!!  *");
		System.out.println("\t******************************");

	}

}

//alberto pizarra:
//main debe hacer mientras que los hilos no hayan acabado , sleep 1 segundo y muestro.
