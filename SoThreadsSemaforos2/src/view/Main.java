package view;

import java.util.concurrent.Semaphore;

import controller.ThreadsCozinha;

public class Main {

	public static void main(String[] args) {
			int permissao = 1;
			Semaphore semaforo = new Semaphore(permissao);
			
			for ( int i = 0; i < 5; i++) {
				ThreadsCozinha m = new ThreadsCozinha(i, semaforo);
				m.start();
			}
			
		
		
		
	}

}
