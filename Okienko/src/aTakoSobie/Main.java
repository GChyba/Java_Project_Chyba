package aTakoSobie;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
// Nic szczeg�lnego tutaj, wywo�anie okienek
			   MyFrame okienko = new MyFrame();
			   okienko.ramka();
			   
			   MyFrame2 okienko2 = new MyFrame2();
			   okienko2.ramka2();
			}
		});
	}

}
