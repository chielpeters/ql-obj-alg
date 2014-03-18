package ql_obj_alg.user_interface.widgets;

import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import ql_obj_alg.operation.evaluator.value.VBoolean;
import ql_obj_alg.operation.evaluator.value.VUndefined;
import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;

public class BooleanWidget implements IWidget{

	String id;
	JLabel label;
	JCheckBox checkBox;
	
	public BooleanWidget(String id, String label){
		this.id = id;
		
		this.checkBox = new JCheckBox();	
		this.label = new JLabel(label);
		this.label.setLabelFor(this.checkBox);
	}
	
	public boolean isAnswerable(){
		return checkBox.isEnabled();
	}
	
	@Override
	public Value getValue(){
		if(checkBox.isVisible()){
			return new VBoolean(checkBox.isSelected());
		}
		return new VUndefined();
	}
	
	@Override
	public void setVisible(boolean visible){
		checkBox.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		checkBox.setEnabled(false);
		frame.addLabel(label);
		frame.addField(checkBox);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		checkBox.setEnabled(true);
		frame.addLabel(label);
		frame.addField(checkBox);
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof BooleanWidget){
			return equals((BooleanWidget) obj);
		}
		return false;
	}

	@Override
	public int hashCode(){
		return id.hashCode();
	}

	@Override
	public void setValue(Value v) {
		checkBox.setSelected(v.getBoolean());
	}

	@Override
	public void addActionListener(ActionListener al) {
		checkBox.addActionListener(al);
	}

	@Override
	public boolean equals(BooleanWidget other) {
		if(this.id == other.id || (this.id != null && this.id.equals(other.id)))
			return true;
		return false;
	}

	@Override
	public boolean equals(IntegerWidget other) {
		return false;
	}

	@Override
	public boolean equals(StringWidget other) {
		return false;
	}
}
