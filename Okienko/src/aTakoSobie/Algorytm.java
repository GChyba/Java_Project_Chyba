package aTakoSobie;
//przy klikniêciu rozpoczêciu po¿aru / ska¿eniu. implementujê setX(4 - po¿ar, 6 - ska¿enie) 
//wartoœci te przechowujê w getX() oraz zmiennaX() aby potem manewrowaæ miêdzy warunkami algorytmu
// czy to ma byæ las, czy te¿ woda które bêd¹ zmieniaæ kolor 
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