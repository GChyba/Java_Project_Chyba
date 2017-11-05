package aTakoSobie;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener{

	public JButton Bttp,Bttsw;
	static int [][] Tab= new int [10][10]; //przeniesienie tablicy z zaimplementowanym ogniem/ska¿eniem
	
	Sleep spanie = new Sleep(); //odstêp czasowy
	Algorytm algorytm = new Algorytm(); //czytanie zmiennych i wykorzystywanie ich do kierowania algorytmem
	
    MyFrame2 guziki = new MyFrame2();
	int[][] Tablica = guziki.getTablica(); //przekopiowanie tablicy z MyFrame2
	

	//Wczytujemy MyFrame2, aby móc u¿yæ metody, w której znajduje siê nam ca³y zapisany wynik
	//now¹ statyczn¹ tablice tworzymy, aby przenieœæ natomiast jej zmienion¹ zawartoœæ (z ogniem)
	// spowrotem stamt¹d, sk¹d j¹ wzieliœmy (Go Home Gi!)
	
	public MyFrame() {
	}
	
	void ramka(){
		// Ustawienia poczatkowe okienka, wielkosc, mo¿liwoœæ wyjœcia i tym podobne
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(200, 150);
        setLocation(600,150);
        przycisk();
        setVisible(true);
	}
	// a tu tworzmy przyciski "Po¿ar" "zgaœ wodê" oraz "Ska¿ wodê" oraz nadajemy im
	// od razu interakcjê
    void przycisk(){
    	setLayout(new GridLayout(2,1));
    	Bttp = new JButton("Po¿ar");
    	Bttsw = new JButton("skaŸ wodê");
    	
    	add(Bttp);
    	add(Bttsw);
    	
		Bttp.addActionListener(this);
		Bttsw.addActionListener(this);
	
    	Bttp.setBackground(Color.RED);
    	Bttsw.setBackground(Color.YELLOW);
		
	}
    // a tutaj ustawiamy co siê dzieje, gdy klikniemy w ka¿dy w wybranych przycisków
    // oraz importowana tablica z MyFrame2 z zapisanymi wynikami rozstawienia guzików
    // nie inter aktywnych, które s³u¿¹ za nasz "teren" (w trakcie pracy)
		
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			// Szukamy w zakresie 1-9 dla [x,y] liczbê 1, która oznacza "las",
			// gdy j¹ znajdujemy, inicjujemy ogieñ (4), i jednoczeœnie zapisujemy t¹ 4 
			// do Tablicy, któr¹ nastêpnie eksportujemy do naszego algorytmu..
			
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
			
				//Wywo³anie algorytmu symulatora, ¿e las zamienia siê w ogieñ, gdy
				// ten zostanie wykryty obok niego.
			
			for(int XX=0;XX<25;XX++)
			{
				guziki.algorytm();
			}			
		}		
		
			// Ten robi co samo co ogieñ, z tym ¿e to jest ska¿enie wody
		
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

		//zapisujemy sobiê tablicê z tym wynikiem "4", aby j¹ przenieœæ spowrotem
		// stamt¹d, sk¹d j¹ wzieliœmy do MyFrame2
		
	   public int [][] Tab(){
	   	return Tablica;
	   }

}

