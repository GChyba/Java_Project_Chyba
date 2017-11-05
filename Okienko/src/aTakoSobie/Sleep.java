package aTakoSobie;
//zastanawiam siê nad wyrzuceniem tego, bo mi nie dzia³a jak powinno, ale ujdzie.
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
