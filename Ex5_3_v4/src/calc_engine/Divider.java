package calc_engine;

public class Divider extends Operand {
	public void operate(){
		try {
			Double s1 = Operand.S1.pop();
			Double product = Operand.S1.pop()/ s1;		
			Operand.S1.push(product);
		}
		catch(ArithmeticException e) {
			System.out.println("Error: Divide by zero");
		}
		catch(java.util.EmptyStackException e){
			System.out.println("Error: Not enough elements in stack");
		}
	}
}
