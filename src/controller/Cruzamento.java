package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {

	private int idCarro;
	private Semaphore semaforo;

	public Cruzamento(int idCarro, Semaphore semaforo) {
		this.semaforo = semaforo;
		this.idCarro = idCarro;
	}

	@Override
	public void run() {
		try {
			Choose();
			semaforo.acquire();
			Pass();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	public void Choose() {
		switch (idCarro) {
		case 0:
			System.out.println("#" + idCarro + " quer avan�ar a Norte");
			break;

		case 1:
			System.out.println("#" + idCarro + " quer avan�ar a Sul");
			break;

		case 2:
			System.out.println("#" + idCarro + " quer avan�ar a Leste");
			break;

		case 3:
			System.out.println("#" + idCarro + " quer avan�ar a Oeste");
			break;
		}
	}

	private void Pass() {
		int tempo = (int) ((Math.random() * 1000) + 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(idCarro + " passou!");
	}

}