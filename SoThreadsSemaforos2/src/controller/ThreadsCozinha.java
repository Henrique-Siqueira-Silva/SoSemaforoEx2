package controller;

import java.util.concurrent.Semaphore;

public class ThreadsCozinha extends Thread {

	private int id;
	private Semaphore semaforo;
	private static int posicao;

	public ThreadsCozinha(int idcarro, Semaphore permissao) {
		id = idcarro;
		semaforo = permissao;
	}

	@Override
	public void run() {
		Cozinhando();
		try {
			semaforo.acquire();
			Entregando();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			semaforo.release();
		}

	}

	private void Cozinhando() {
		if (id % 2 == 0 ) {
			int tempo = (int) Math.random() *301 + 500;
			int tempopercorrido = 0;
			try {
				while (tempopercorrido < tempo) {
					System.out.println("Sopa de cebola	 porcentagem = "+(int)((100*tempopercorrido)/tempo)+ "%");
					tempopercorrido += +100;
					sleep(100);
				}
				System.out.println("Sopa de cebola pronta #"+id+ " PRONTA!");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if( id % 2 ==1) {
			int tempo = (int) Math.random() *601 + 600;
			int tempopercorrido = 0;
			try {
				while (tempopercorrido < tempo) {
					System.out.println("Lazanha	 porcentagem = "+(int)((100*tempopercorrido)/tempo)+ "%");
					tempopercorrido += +100;
					sleep(100);
				}
				System.out.println("Lazanha #"+id+ " PRONTA!");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void Entregando() {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
