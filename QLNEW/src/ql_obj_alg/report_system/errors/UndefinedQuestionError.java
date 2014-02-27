package ql_obj_alg.report_system.errors;

public class UndefinedQuestionError extends GenError{
	String variable;
	
	public UndefinedQuestionError(String variable){
		this.variable = variable;
	}
	
	public String toString(){
		return "Duplicated variable: "+variable;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof UndefinedQuestionError){
			UndefinedQuestionError error = (UndefinedQuestionError) obj;
			
			if(this.variable == error.variable || (this.variable != null && this.variable.equals(error.variable)))
				return true;
		}
		return false;
	}

}
