package calc_engine;

import calc_gui.*;
import java.util.Stack;

public class Calc {
	public static Stack<Double> st = new Stack<Double>();
	
	public static void main(String[] args){
		Operand op = new Operand();
		Adder add = new Adder();
		Subtracter sub = new Subtracter();
		Multiplier mul = new Multiplier();
		Divider div = new Divider();
		ResultPresenter rp = new ResultPresenter();
		CalculatorGui cg = new CalculatorGui(op, add, sub, mul, div, rp);
		op.setCalculatorGui(cg);
		op.setStack(st);
	}
}
