package aTakoSobie;
//przy klikni�ciu rozpocz�ciu po�aru / ska�eniu. implementuj� setX(4 - po�ar, 6 - ska�enie) 
//warto�ci te przechowuj� w getX() oraz zmiennaX() aby potem manewrowa� mi�dzy warunkami algorytmu
// czy to ma by� las, czy te� woda kt�re b�d� zmienia� kolor 
	public class Algorytm {
		static int b;
		
		public static void setX(int a){
			b=a;
		}
	    static int getX(){
			return b;
		}
	    static public int zmiennaX(){
	    	if(getX()==4)
	    	{
	    	    return 1;
	    	}
	    	else
	    	{
	    		return 3;
	    	}
	    }

}