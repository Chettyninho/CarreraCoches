package Carrera;

import java.util.ArrayList;
import java.util.Random;

public class Coche extends Thread {
	// Herramientas
	Random random = new Random();
	ArrayList<Coche> clasificacionCarrera = new ArrayList<>();
	ControlCarrera cc = new ControlCarrera(clasificacionCarrera);

	// variables que no cambiaran
	int dorsal;
	int totalVueltas;
	// variables que cambiaran
	int posicion = 1;
	int vueltas = 1;
	double tiempoPorVuelta;
	long tiempoEnMilisegundos;
	// long tiempoTotalMilisegundos = 0;

	// constructor
	public Coche(int dorsal, ArrayList<Coche> clasificacionCarrera, int totalVueltas) {
		this.dorsal = dorsal;
		this.totalVueltas = totalVueltas;
		this.clasificacionCarrera = clasificacionCarrera;
	}

//	public long getTiempoTotalMilisegundos() {
//		return tiempoTotalMilisegundos;
//	}
//
//	public void setTiempoTotalMilisegundos(long tiempoTotalMilisegundos) {
//		this.tiempoTotalMilisegundos = tiempoTotalMilisegundos;
//	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getVueltas() {
		return vueltas;
	}

	public void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public double getTiempoPorVuelta() {
		return tiempoPorVuelta;
	}

	public void setTiempoPorVuelta(double tiempoPorVuelta) {
		this.tiempoPorVuelta = tiempoPorVuelta;
	}

	public long getTiempoEnMilisegundos() {
		return tiempoEnMilisegundos;
	}

	public void setTiempoEnMilisegundos(long tiempoEnMilisegundos) {
		this.tiempoEnMilisegundos = tiempoEnMilisegundos;
	}

	public void run() {

		while (vueltas < totalVueltas) {
			tiempoPorVuelta = cc.generarTiempoPorVuelta();

			tiempoEnMilisegundos = (long) (tiempoPorVuelta * 1000);
			// this.tiempoTotalMilisegundos += tiempoEnMilisegundos;

			try {
				Thread.sleep(tiempoEnMilisegundos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.vueltas++;
			// pasarle el nombre(dorsal) y vueltas que lleva para comparar y el que mas
			// vueltas lleve va primero.
			cc.cambiarPosiciones(clasificacionCarrera);
		}
	}
}
