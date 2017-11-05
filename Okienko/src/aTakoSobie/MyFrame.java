package aTakoSobie;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener{

	public JButton Bttp,Bttsw;
	static int [][] Tab= new int [10][10]; //przeniesienie tablicy z zaimplementowanym ogniem/ska�eniem
	
	Sleep spanie = new Sleep(); //odst�p czasowy
	Algorytm algorytm = new Algorytm(); //czytanie zmiennych i wykorzystywanie ich do kierowania algorytmem
	
    MyFrame2 guziki = new MyFrame2();
	int[][] Tablica = guziki.getTablica(); //przekopiowanie tablicy z MyFrame2
	

	//Wczytujemy MyFrame2, aby m�c u�y� metody, w kt�rej znajduje si� nam ca�y zapisany wynik
	//now� statyczn� tablice tworzymy, aby przenie�� natomiast jej zmienion� zawarto�� (z ogniem)
	// spowrotem stamt�d, sk�d j� wzieli�my (Go Home Gi!)
	
	public MyFrame() {
	}
	
	void ramka(){
		// Ustawienia poczatkowe okienka, wielkosc, mo�liwo�� wyj�cia i tym podobne
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(200, 150);
        setLocation(600,150);
        przycisk();
        setVisible(true);
	}
	// a tu tworzmy przyciski "Po�ar" "zga� wod�" oraz "Ska� wod�" oraz nadajemy im
	// od razu interakcj�
    void przycisk(){
    	setLayout(new GridLayout(2,1));
    	Bttp = new JButton("Po�ar");
    	Bttsw = new JButton("ska� wod�");
    	
    	add(Bttp);
    	add(Bttsw);
    	
		Bttp.addActionListener(this);
		Bttsw.addActionListener(this);
	
    	Bttp.setBackground(Color.RED);
    	Bttsw.setBackground(Color.YELLOW);
		
	}
    // a tutaj ustawiamy co si� dzieje, gdy klikniemy w ka�dy w wybranych przycisk�w
    // oraz importowana tablica z MyFrame2 z zapisanymi wynikami rozstawienia guzik�w
    // nie inter aktywnych, kt�re s�u�� za nasz "teren" (w trakcie pracy)
		
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			// Szukamy w zakresie 1-9 dla [x,y] liczb� 1, kt�ra oznacza "las",
			// gdy j� znajdujemy, inicjujemy ogie� (4), i jednocze�nie zapisujemy t� 4 
			// do Tablicy, kt�r� nast�pnie eksportujemy do naszego algorytmu..
			
		if(source==Bttp) {
			Algorytm.setX(4);
			outerloop:
				for(int i = 0; i < 100; i++)
				{

						int L =((int)(Math.random()*9) + 1);
						int P =((int)(Math.random()*9) + 1);
							if(Tablica[L][P] == Algorytm.zmiennaX())
							{
								Tablica[L][P] = 4;
								break outerloop;
							}			
			}
			
				//Wywo�anie algorytmu symulatora, �e las zamienia si� w ogie�, gdy
				// ten zostanie wykryty obok niego.
			
			for(int XX=0;XX<25;XX++)
			{
				guziki.algorytm();
			}			
		}		
		
			// Ten robi co samo co ogie�, z tym �e to jest ska�enie wody
		
		else if(source==Bttsw) {
			Algorytm.setX(6);
			outerloop:
				for(int i = 0; i < 100; i++)
				{
						int L =((int)(Math.random()*9) + 1);
						int P =((int)(Math.random()*9) + 1);
							if(Tablica[L][P] == Algorytm.zmiennaX())
							{
								Tablica[L][P] = 6;
								break outerloop;
							}	
					
					
				}
				for(int XX=0;XX<25;XX++)
				{
					guziki.algorytm();
				}	
		
		}
	}

		//zapisujemy sobi� tablic� z tym wynikiem "4", aby j� przenie�� spowrotem
		// stamt�d, sk�d j� wzieli�my do MyFrame2
		
	   public int [][] Tab(){
	   	return Tablica;
	   }

}

