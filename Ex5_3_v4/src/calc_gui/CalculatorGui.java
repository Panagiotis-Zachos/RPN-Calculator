package calc_gui;

import java.awt.*;
import java.awt.event.*;
import calc_engine.*;

public class CalculatorGui extends Frame{
	
	private static Operand op;
	private static Adder add;
	private static Subtracter sub;
	private static Multiplier mul;
	private static Divider div;
	private static ResultPresenter eq;
	public TextField display;
	private Button buttonEnter, buttonBackSpace, buttonClear, buttonAdd, buttonRes;
	private Button buttonSub, buttonMult, buttonDiv;
	private static Button[] buttons = new Button[10];
		
	private static final long serialVersionUID = 4004247206471717897L;
	
	public CalculatorGui(Operand op, Adder add, Subtracter sub, Multiplier mul, Divider div, ResultPresenter eq){
		super("Java Polish Reverse Calculator");
		this.setLayout(null);
		
		CalculatorGui.op = op;
		CalculatorGui.add = add;
		CalculatorGui.sub = sub;
		CalculatorGui.mul = mul;
		CalculatorGui.div = div;
		CalculatorGui.eq = eq;
		
		this.setLayout(null);
		this.setFont(new Font("Helvetica", Font.PLAIN, 14));
		this.setBackground(Color.DARK_GRAY);
		Dimension d = new Dimension();
		d.width = 283;
		d.height = 310;
		this.setSize(d);
		this.setLocation(50, 100);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);	// So that window is presented in the center of the screen
		
		this.addWindowListener(new WindowAdapter() {	
			public void windowClosing(WindowEvent we) {
	            	dispose();								
	            }
			}
		);
		
		display = new TextField("0", 14);
		display.setEditable(false);
		display.setBounds(13, 55, 257, 30);
		this.add(display);
		
		/* Digit Buttons Creation */
				
		int num = 1;
		for(int i=233; i >= 166; i -= 33) {
			for (int j = 64; j <= 144 ; j += 40) {
				ButtonCreate(j, i, num++, this);
			}
		}
		ButtonCreate(64, 265, 0, this);		// Create button for zero
		
		buttonBackSpace = new Button("BackSpace");
		buttonBackSpace.setBounds(185, 100, 75, 28 );
		buttonBackSpace.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.op.deleteLastDigit();
					}
				});
		this.add(buttonBackSpace);
		
		buttonEnter = new Button("Enter");
		buttonEnter.setBounds(204, 130, 56, 28 );
		buttonEnter.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.op.complete();;
					}
				});
		this.add(buttonEnter);
		
		buttonClear = new Button("C");
		buttonClear.setBounds(144, 100, 35, 28 );
		buttonClear.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.op.reset();
					}
				});
		buttonClear.setBackground(Color.red);
		this.add(buttonClear);
		
		buttonAdd = new Button("+");
		buttonAdd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.add.operate();
					}
				});
		this.add(buttonAdd);
		buttonAdd.setBounds(195, 265,35,28 );
		
		buttonRes = new Button("=");
		buttonRes.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.eq.operate();
					}
				});
		this.add(buttonRes);
		buttonRes.setBounds(235,265, 35, 28 );
		
		buttonSub = new Button("-");
		buttonSub.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.sub.operate();
					}
				});
		this.add(buttonSub);
		buttonSub.setBounds(195,232,35,28 );
		
		buttonDiv = new Button("/");
		buttonDiv.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.div.operate();
					}
				});
		this.add(buttonDiv);
		buttonDiv.setBounds(195,166, 35, 28);
		
		buttonMult = new Button("*");
		buttonMult.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CalculatorGui.mul.operate();
					}
				});
		this.add(buttonMult);
		buttonMult.setBounds(195,199, 35, 28);
		
	}
		
	private void ButtonCreate(int x, int y, int num, Frame f) {
		buttons[num] = new Button(Integer.toString(num));
		buttons[num].setBounds(x, y, 35, 28);	
		buttons[num].addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CalculatorGui.op.addDigit((char) (num + '0'));
					}
				}
				);
		f.add(buttons[num]);
	}
		
//	private class ButtonClickListener implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//	         String command = e.getActionCommand();  
//	         if( command.equals("BackSpace")) {
//	        	 op.deleteLastDigit();
//	         }
//	         else if( command.equals("Enter")) {
//	        	 op.complete();	 
//	         }
//	         else if( command.equals("C")) {
//	        	 op.reset();
//	         } 
//	         else if( command.equals("+")) { 
//	        	 add.operate();
//	         }
//	         else if( command.equals("*")) { 
//	        	 mul.operate();
//	         }
//	         else if( command.equals("-")) {
//	        	 sub.operate();
//	         }
//	         else if( command.equals("=")) {
//	        	 eq.operate();
//	         }
//	         else if( command.equals("/")) {
//	        	 div.operate();
//	         }     
//		}	
//	}
}