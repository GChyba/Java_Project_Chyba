package aTakoSobie;
//zastanawiam si� nad wyrzuceniem tego, bo mi nie dzia�a jak powinno, ale ujdzie.
public class Sleep {

	public Sleep() {
	}

	void sleep(int a){
		try{
			
			 Thread.sleep(a);
			}
			catch (InterruptedException e) {}
	}
}
