package rubinstein.clock;

public class ClockThread extends Thread {
	Clock clock = new Clock();

	public ClockThread(Clock clock) {
		this.clock = clock;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			clock.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
