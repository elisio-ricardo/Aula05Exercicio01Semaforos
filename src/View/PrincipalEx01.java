package View;

import java.util.concurrent.Semaphore;

import Controller.Servidor;

public class PrincipalEx01 {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int id = 1; id < 22; id ++) {
			Thread bDCalc = new Servidor(id, semaforo);
			bDCalc.start();
		}
	}
}
