package pl.edu.pjwstk.project.services;

public final class Singleton {

	private int quantityOfCars;

	private Singleton() {
	}

	private static Singleton instance;

	public static Singleton getInstance() {

		if (instance == null)
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		return instance;
	}

	public void reduceCars() {
		this.quantityOfCars--;
	}


	public void raiseNumberOfCars() {
		this.quantityOfCars++;
	}


	public int getQuantity() {
		return this.quantityOfCars;
	}
}