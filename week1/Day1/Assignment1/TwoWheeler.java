package week1.Day1.Assignment1;

public class TwoWheeler {
	
	int noOfWheels = 2;
	short noOfMirrors = 2;
	long chassisNumber = -9988776655443333L;
	boolean isPunctured = false;
	String bikeName = "Yamaha";
	double runningKM = 4000.34444;
	
	public static void main(String[] args) {
		
		TwoWheeler obj = new TwoWheeler();
		System.out.println ("No. Of Wheels"+ " = " + obj.noOfWheels);
		System.out.println ("No. Of Mirrors"+ " = " + obj.noOfMirrors);
		System.out.println ("chassisNumber"+ " = " + obj.chassisNumber);
		System.out.println ("Is TwoWheeler Punctured"+ " = " + obj.isPunctured);
		System.out.println ("Bike Name"+ " = " + obj.bikeName);
		System.out.println ("Running KM"+ " = " + obj.runningKM);
		
	}

}
