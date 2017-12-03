package calc_engine;

public class Subtracter extends Operand{
	public void operate(){
		try {
			Double s1 = Operand.S1.pop();
			Double sum = Operand.S1.pop() - s1;
			Operand.S1.push(sum);
		}
		catch(java.util.EmptyStackException e){
			System.out.println("Error: Not enough elements in stack");
		}
	}
}
