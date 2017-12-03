package calc_engine;

public class ResultPresenter extends Operand {
	public void operate(){
		try {
		Operand.cg.display.setText(String.valueOf(Operand.S1.pop()));
		}
		catch(java.util.EmptyStackException e){
			System.out.println("Error: Not enough elements in stack");
		}
	}
}
