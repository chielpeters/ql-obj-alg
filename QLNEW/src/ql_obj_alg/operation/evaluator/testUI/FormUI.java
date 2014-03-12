package ql_obj_alg.operation.evaluator.testUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.operation.user_interface.modules.FormFrame;
import ql_obj_alg.operation.user_interface.modules.Widgets;

public class FormUI implements IFormAlg<IDepsAndEvalE,ICreate,ICreateF>{

	@Override
	public ICreateF form(final String id, final ICreate s) {
		return new ICreateF(){

			@Override
			public void create(final ValueEnvironment valEnv) {
				Widgets widgets = new Widgets();
				final FormFrame frame = new FormFrame(id);
				s.create(frame, widgets, valEnv);
				JButton Submit = new JButton("Submit");
				Submit.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println(valEnv.toJsonString());
					}
				});
				frame.addButton(Submit);
				
				frame.render();
				
			}
			
		};
	}

	@Override
	public ICreateF forms(final List<ICreateF> listForms) {
		return new ICreateF(){

			@Override
			public void create(ValueEnvironment valEnv) {
				for(ICreateF form : listForms){
					form.create(valEnv);
				}
			}
			
		};
	}

}
