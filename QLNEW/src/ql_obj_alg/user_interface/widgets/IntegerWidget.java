package ql_obj_alg.user_interface.widgets;

import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import ql_obj_alg.operation.evaluator.value.VInteger;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;

public class IntegerWidget implements IWidget{

	String id;
	JLabel label;
	JFormattedTextField field;
	
	public IntegerWidget(String id, String label){
		this.id = id;
		
		this.field = new JFormattedTextField(NumberFormat.getNumberInstance());
		this.field.setColumns(15);
		this.label = new JLabel(label);
		this.label.setLabelFor(this.field);
	}
	
	public boolean isAnswerable(){
		return field.isEnabled();
	}
	
	@Override
	public Value getValue(){
		if(isUndefined()){
			return new VUndefined();
		}
		else
			return new VInteger(Integer.parseInt(field.getText()));
	}
	
	@Override
	public boolean isUndefined() {
		return field.getText() == null || field.getText().equals("");
	}

	@Override
	public void setVisible(boolean visible){
		field.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		field.setEnabled(false);
		frame.addField(field);
		frame.addLabel(label);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		field.setEnabled(true);
		frame.addField(field);
		frame.addLabel(label);
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof IntegerWidget){
			IntegerWidget w = (IntegerWidget) obj;
			
			if(this.id == w.id || (this.id != null && this.id.equals(w.id)))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
	@Override
	public void setValue(Value v) {
		field.setValue(v.getInteger());
	}

	@Override
	public void addActionListener(ActionListener al) {
		field.addActionListener(al);
	}
}