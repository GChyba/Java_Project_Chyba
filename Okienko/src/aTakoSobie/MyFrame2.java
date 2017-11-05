package aTakoSobie;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
//------------------------------------------------------------------------------
//-------------------------Tworzenie 2-giej siatki------------------------------
//------------------------------------------------------------------------------
public class MyFrame2 extends JFrame {	
	
	static JButton buttons[][] = new JButton[10][10];
	static int [][] tablica= new int [10][10];
	
	
	public MyFrame2() {
	}
	
	
	void ramka2(){
	//	super("Symulator po¿aru v0.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 550);
        setLocation(0,150);
        siatka();
        setVisible(true);
	}
//------------------------------------------------------------------------------
//-----------tworzenie tablicy [X][Y] wraz z guzikami (pokolorawnymi)-----------
//------------------------------------------------------------------------------
	void siatka(){
		setLayout(new GridLayout(10,10));
		for(int x=0; x<10; x++)
		{
			for(int y=0; y<10; y++)
			{
				int z =((int)(Math.random()*3) + 1);
				JButton btn = new JButton();
				add(btn);
				buttons[x][y] = btn;
				tablica[x][y] = z;
				if(z == 1)
				{
					btn.setBackground(Color.GREEN);
				}
			
				if(z == 2)
				{
					btn.setBackground(Color.DARK_GRAY);
				}
			
				if(z == 3)
				{
					btn.setBackground(Color.BLUE);
				}			
			}
		}
	}
//------------------------------------------------------------------------------
//------------------------//Algorytm komórkowy (worframa)//---------------------
//------------------------//jeœli [x,y]=4, podmieñ kolor-//---------------------
//--------//a nastêpnie sprawdŸ, czy inne do oko³a, s¹ liczbami 1[las]//--------
//------------------//jeœli tak - podmieñ kolor na czerwony//-------------------
//------------------------------------------------------------------------------

	
	void algorytm(){
		
		MyFrame frame = new MyFrame(); // mo¿liwoœæ wczytania tablicy z zainicjowanym po¿arem/ska¿eniem
		Algorytm algorytm = new Algorytm(); // czytanie zmiennych ustanowionych po klikniêciu "po¿ar"/ "skaŸ wodê"
		int [][] Tab = frame.Tab(); // zapisana tablica z inicjowanym po¿arem/ska¿eniem
		Sleep spanie = new Sleep(); // odstêpy sekundowe miêdzy wykryciem po¿aru/ska¿enia

			for(int x=1; x<9; x++)
			{
				for(int y=1; y<9; y++)
				{	
					if(Tab[x][y]==Algorytm.getX())
					{
							//buttons[x][y].setBackground(Color.RED);					
						for(int j=-1;j<2;j++)
						{
							for(int k=-1;k<2;k++)
							{
								if(Tab[x+j][y+k] == Algorytm.zmiennaX())
								{
									switch(Algorytm.zmiennaX()){
									case 1:
										buttons[x][y].setBackground(Color.RED);
										System.out.println("Ogieñ wykryty w tablicy: " + x+y);
										buttons[x+j][y+k].setBackground(Color.RED);
										Tab[x+j][y+k]= Algorytm.getX();
										spanie.sleep(1000);
										break;
									case 3:
										buttons[x][y].setBackground(Color.YELLOW);
										System.out.println("wykryto zatrucie wody: " + x+y);
										buttons[x+j][y+k].setBackground(Color.YELLOW);
										Tab[x+j][y+k]= Algorytm.getX();
										spanie.sleep(1000);
										break;
									default:
										System.out.println("error error");
									}
								}
							}
						}
					}
				}
			}
			
	}
	
	// zwracamy tablicê z jej zawartoœci¹, aby j¹ u¿yæ w MyFrame, w celu
	//
	public int[][] getTablica(){
		return tablica;
	}
}
