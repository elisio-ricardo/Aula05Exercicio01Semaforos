package Controller;

import java.util.concurrent.Semaphore;

public class Servidor extends Thread {

	private int id;
	private Semaphore semaforo;

	public Servidor(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		Calculos();
		try {
			semaforo.acquire();
			bancoDados();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			Calculos();
		}
		try {
			semaforo.acquire();
			bancoDados();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void Calculos() {
		double tempo;
		int num = 0;
		if (id % 3 == 1) {
			num = 1;
		} else if (id % 3 == 2) {
			num = 2;
		} else if (id % 3 == 0) {
			num = 3;
		}
		switch (num) {
		case (1):
			tempo = ((Math.random() * 800) + 200);
			System.out.println("Calculando o tipo A o ID " + id);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case (2):
			tempo = ((Math.random() * 800) + 200);
			System.out.println("Calculando o tipo B o ID " + id);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case (3):
			tempo = ((Math.random() * 800) + 200);
			System.out.println("Calculando o tipo C o ID " + id);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private void bancoDados() {
		double tempo;
		int num = 0;
		if (id % 3 == 1) {
			num = 1;
		} else if (id % 3 == 2) {
			num = 2;
		} else if (id % 3 == 0) {
			num = 3;
		}
		switch (num) {
		case (1):
			tempo = 1000;
			System.out.println("Transação BDa do ID " + id);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case (2):
			tempo = 1500;
			System.out.println("Transação BDb do ID " + id);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case (3):
			tempo = 1500;
			System.out.println("Transação BDc do ID " + id);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
