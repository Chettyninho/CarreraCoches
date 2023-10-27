package Carrera;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ControlCarrera {
	private Random random;
	private ArrayList<Coche> clasificacionCarrera = new ArrayList<>();
	//private ArrayList<Coche> clasificacionCarreraOriginal = new ArrayList<>();
	
	public ControlCarrera(ArrayList<Coche> clasificacionCarrera) {
		this.clasificacionCarrera = clasificacionCarrera;
		//this.clasificacionCarreraOriginal.addAll(clasificacionCarrera); // Copia la lista original
		this.random = new Random();
	}

	public double generarTiempoPorVuelta() {
		double tpv = 0.5 + (random.nextDouble() * 2.5);
		return tpv;
	}


	public synchronized void cambiarPosiciones(ArrayList<Coche> clasificacionCarrera) {
	    // Ordenar la lista de coches por el número de vueltas en orden descendente
	    clasificacionCarrera.sort(Comparator.comparingInt(Coche::getVueltas).reversed());

	    int posicionActual = 1; // Comenzamos con la primera posición
	    int vueltasAnteriores = 0; // Inicializamos con un valor negativo

	    for (Coche coche : clasificacionCarrera) {
	        int vueltasActuales = coche.getVueltas();

	        if (vueltasActuales != vueltasAnteriores) {
	            // Si el número de vueltas actual es diferente al anterior, asignar una nueva posición
	            coche.setPosicion(posicionActual);
	        }

	        if (posicionActual < 5) {
	            // Incrementar la posición solo si no hemos alcanzado la posición máxima (5)
	            posicionActual++;
	        }

	        vueltasAnteriores = vueltasActuales;
	    }
	}


}
