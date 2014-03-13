package ql_obj_alg.operation.evaluator;

import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.modules.FormFrame;
import ql_obj_alg.user_interface.widgets.IWidget;
import ql_obj_alg.user_interface.widgets.ObservableWidget;

public class ValueEnvironment {

	private Map<String,Value> questions;
	private Map<String, ObservableWidget> registry = new HashMap<String,ObservableWidget>();
	
	public ValueEnvironment(){
		questions = new HashMap<String,Value>();
	}
	
	public Value getQuestionValue(String id){
		return questions.get(id);
	}

	public void setQuestionValue(String id, Value v){
		questions.put(id,v);
	}	
	
	private void initObservable(String name) {
		if (!registry.containsKey(name)) {
			registry.put(name, new ObservableWidget());
		}
	}

	
	public ObservableWidget getObservable(String name) {
		initObservable(name);
		return registry.get(name);
	}

	
	public void notifyObservers(final String id) {
		ObservableWidget obs = this.getObservable(id);
		obs.setChanged();
		obs.notifyObservers();
	}
	
	public void createVisibilityObservers(final String id,final FormFrame frame, 
			final IWidget widget, final Conditions conditions) {
		for(String dep : conditions.dependencies()){
			this.getObservable(dep).addObserver(new VisibilityObserver(id, frame, widget, this, conditions));
		}
	}

	public void createValueObservers(final String id, final IDepsAndEvalE e, final FormFrame frame, final IWidget widget) {
		for(String dep : e.deps()){
			this.getObservable(dep).addObserver(new ValueObserver(id, e, frame, widget,this));		
		}
	}
}

