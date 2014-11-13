
public class PowerOfNumber {
	
	public double getPower(double number, int power) {
		
		if(power == 0) {
			return 1;
		}
		
		if(power < 0) {
			assert number!= 0;
			return 1/getPower(number,-power);
		}
		
		double half = getPower(number, power/2);
		return half * half * ((power % 2 ==1 )? number : 1);
	}

}
