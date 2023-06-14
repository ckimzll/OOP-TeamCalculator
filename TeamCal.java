import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TeamCal extends JFrame implements ActionListener {
	private boolean isInputF1Active = true;
    StringBuffer	sb1 = new StringBuffer();
    StringBuffer	sb2 = new StringBuffer();
    JPanel			inputpanel, buttonpanel;
    JTextField		inputF1, inputF2, outputF;
    JLabel			valuelb1, valuelb2, area;
    JButton			circle, triangle, rectangle;  // choose figure
    String []		buttons_name = { "0", "7", "8", "9", "4", "5", "6", "1", "2", "3" };  // number
    JButton []		buttons = new JButton[buttons_name.length];
    JButton			bequal, bC, bdot, bDEL, b; // =, C, ., DEL

    public TeamCal(){
		// set Font
		Font font = new Font("Arial", Font.BOLD, 15);

		// choose figure button components
		circle = new JButton("CIRCLE");
		circle.addActionListener(this);
		triangle = new JButton("TRIANGLE");
		triangle.addActionListener(this);
		rectangle = new JButton("RECTANGLE");
		rectangle.addActionListener(this);

		// input&output
		valuelb1 = new JLabel("value1");
		valuelb2 = new JLabel("value2");
		inputF1 = new JTextField();
		inputF2 = new JTextField();
		area = new JLabel("AREA");
		outputF = new JTextField();

		circle.setBackground(Color.white);
		circle.setForeground(Color.black);
		circle.setFont(font);
        triangle.setBackground(Color.white);
        triangle.setForeground(Color.black);
        triangle.setFont(font);
        rectangle.setBackground(Color.white);
        rectangle.setForeground(Color.black);
        rectangle.setFont(font);

        valuelb1.setFont(font);
        valuelb2.setFont(font);
        area.setFont(font);

        // button panel
        buttonpanel = new JPanel(new GridLayout(5, 3, 10, 10));

        // numeric button components
        for(int i = 0; i < buttons_name.length; i++) {
			buttons[i] = new JButton(buttons_name[i]);
            buttons[i].setBackground(Color.black);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(font);
            buttons[i].addActionListener(this); // add button ActionListener
        }

        // =, C, ., DEL button components
        bequal = new JButton("=");
        bC = new JButton("C");
        bdot = new JButton(".");
        bDEL = new JButton("DEL");
        b = new JButton("");

		bequal.setBackground(Color.gray);
        bC.setBackground(Color.red);
        bdot.setBackground(Color.gray);
        bDEL.setBackground(Color.red);
        b.setBackground(Color.black);

        bequal.setForeground(Color.white);
        bC.setForeground(Color.white);
        bdot.setForeground(Color.white);
        bDEL.setForeground(Color.white);

        bequal.setFont(font);
        bC.setFont(font);
        bdot.setFont(font);
        bDEL.setFont(font);

        // add ActionListener button
        bequal.addActionListener(this);
        bC.addActionListener(this);
        bdot.addActionListener(this);
        bDEL.addActionListener(this);

        // add labels and textfields at Panel
		// input-> enter value, output-> print value(area)
        inputpanel = new JPanel();
        inputpanel.setLayout(null);
        circle.setBounds(10, 15, 140, 30);
        triangle.setBounds(10, 55, 140, 30);
        rectangle.setBounds(10, 95, 140, 30);
        valuelb1.setBounds(170, 15, 100, 30);
        valuelb2.setBounds(170, 55, 100, 30);
        area.setBounds(170, 95, 100, 30);
        inputF1.setBounds(230, 15, 140, 30);
        inputF2.setBounds(230, 55, 140, 30);
        outputF.setBounds(230, 95, 140, 30);
 
        inputpanel.add(circle);
        inputpanel.add(triangle);
        inputpanel.add(rectangle);
        inputpanel.add(valuelb1);
        inputpanel.add(valuelb2);
        inputpanel.add(area);
        inputpanel.add(inputF1);
        inputpanel.add(inputF2);
        inputpanel.add(outputF);

        // add buttons at Panel
        buttonpanel.add(bC);
        buttonpanel.add(b);
		buttonpanel.add(bDEL);
   
        for(int i = 1; i < buttons_name.length; i++) {
			buttonpanel.add(buttons[i]);
        }
		buttonpanel.add(bdot);
        buttonpanel.add(buttons[0]);
        buttonpanel.add(bequal);

        // JPanel location
        inputpanel.setBounds(5, 5, 375, 150);
        buttonpanel.setBounds(7, 150, 370, 305);

        // set JFrame
        setLayout(null);
        add(inputpanel);
        add(buttonpanel);

        setTitle("Team 6 Calculator");
        setVisible(true);
        setSize(400, 500);
        setResizable(false); // no size change
		
		inputF2.addMouseListener(new MouseAdapter() { // Mouse event
			@Override
			public void mouseClicked(MouseEvent e) {
				isInputF1Active = false;
			}});
		inputF1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isInputF1Active = true;
			}});
	}
		
	public void actionPerformed(ActionEvent e) {
		String input1 = inputF1.getText();
		String input2 = inputF2.getText();
		if (e.getSource() == triangle) { // triangle setText
			if(inputF2.getText().equals("0")) {
				inputF1.setText("");
				inputF2.setText("0");
				outputF.setText("");
			} else {
				inputF1.setText("");
				inputF2.setText("");
				outputF.setText("");
			}
			sb1.setLength(0);
			sb2.setLength(0);
			valuelb1.setText("Base"); // Label text change
			valuelb2.setText("Height"); // Label text change
			inputF2.setText("");
			inputF1.setText("");
			outputF.setText("");

		} else if (e.getSource() == rectangle) { // rectangle setText
			if(inputF2.getText().equals("0")) {
				inputF1.setText("");
				inputF2.setText("0");
				outputF.setText("");
			} else {
				inputF1.setText("");
				inputF2.setText("");
				outputF.setText("");
			}
			sb1.setLength(0);
			sb2.setLength(0);
			valuelb1.setText("Width"); // Label text change
			valuelb2.setText("Height"); // Label text change
			inputF2.setText("");
			inputF1.setText("");
			outputF.setText("");

		} else if (e.getSource() == circle) { // circle setText
			if(inputF2.getText().equals("0")) {
				inputF1.setText("");
				inputF2.setText("0");
				outputF.setText("");
			} else {
				inputF1.setText("");
				inputF2.setText("");
				outputF.setText("");
			}
			sb1.setLength(0);
			sb2.setLength(0);
			valuelb1.setText("Radius"); // Label text change
			valuelb2.setText(""); // Label text change -> only radius
			inputF2.setText("0"); // set null value
			inputF1.setText("");
			outputF.setText("");

		}else if (e.getSource() == bequal) { // input calculation for output(area)
			double dinput1 = Double.parseDouble(inputF1.getText());
			double dinput2 = Double.parseDouble(inputF2.getText());
			double result = 0.0; // both integers and decimals
            
			if (isInputF1Active) {
				if (valuelb1.getText().equals("Radius") && valuelb2.getText().isEmpty()) {
					result = Math.PI * dinput1 * dinput1;
				} else if (valuelb1.getText().equals("Base") && valuelb2.getText().equals("Height")) {
					result = 0.5 * dinput1 * dinput2;
				} else if (valuelb1.getText().equals("Width") && valuelb2.getText().equals("Height")) {
					result = dinput1 * dinput2;
				} 
			} else if (!isInputF1Active) {
				if (valuelb1.getText().equals("Radius") && valuelb2.getText().isEmpty()) {
					result = Math.PI * dinput1 * dinput1;
				} else if (valuelb1.getText().equals("Base") && valuelb2.getText().equals("Height")) {
					result = 0.5 * dinput1 * dinput2;
				} else if (valuelb1.getText().equals("Width") && valuelb2.getText().equals("Height")) {
					result = dinput1 * dinput2;
				}          
			}

			if (!Double.isNaN(result)) { // invalid
				outputF.setText(String.valueOf(result));
			} else {
				outputF.setText("Invalid input");
			}

		} else if (e.getSource() == bC) { // clear text
			if(inputF2.getText().equals("0")) {
				inputF1.setText("");
				inputF2.setText("0");
				outputF.setText("");
			} else {
				inputF1.setText("");
				inputF2.setText("");
				outputF.setText("");
			}
			sb1.setLength(0);
			sb2.setLength(0);

		} else if(e.getSource() == bDEL) { // delete one letter
			if (!input1.isEmpty() && isInputF1Active) {
				inputF1.setText(input1.substring(0, input1.length() - 1));
				sb1.setLength(input1.length() - 1);
			} else if (!input2.isEmpty() && !isInputF1Active) {
				inputF2.setText(input2.substring(0, input2.length() - 1));
				sb2.setLength(input2.length() - 1);
			}
			outputF.setText(""); // clear output
      
		} else if (e.getSource() == bdot) { // input decimals
			if (isInputF1Active) {
				inputF1.setText(input1 + ".");
			} else if (!isInputF1Active) {
				inputF2.setText(input2 + ".");
			}

		} else if (e.getActionCommand().equals("1") || e.getActionCommand().equals("2") || e.getActionCommand().equals("3") ||
			e.getActionCommand().equals("4") || e.getActionCommand().equals("5") || e.getActionCommand().equals("6") ||
			e.getActionCommand().equals("7") || e.getActionCommand().equals("8") || e.getActionCommand().equals("9") ||
			e.getActionCommand().equals("0")) { // input number
			String s = e.getActionCommand();
			if (isInputF1Active) {
				inputF1.setText(input1 + s);
			} else {
				inputF2.setText(input2 + s);
			}	
		}
	}
}















