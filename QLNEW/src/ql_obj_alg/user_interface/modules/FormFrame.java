package ql_obj_alg.user_interface.modules;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JPanel labelPane;
	JPanel fieldPane;
	JPanel buttonPane;

	public FormFrame(String id) {
		super(id);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        labelPane = new JPanel(new GridLayout(0,1));
        fieldPane = new JPanel(new GridLayout(0,1));
        buttonPane = new JPanel(new GridLayout(0,1));
        getContentPane().add(labelPane, BorderLayout.CENTER);
        getContentPane().add(fieldPane, BorderLayout.LINE_END);
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button clicked");
			}
		});
		buttonPane.add(Submit);

	}
	
	public void addLabel(JLabel label){
		labelPane.add(label);
	}
	
	public void addField(JComponent field){
		fieldPane.add(field);
	}

	public void render() {
        pack();
        setVisible(true);		
	}


}
