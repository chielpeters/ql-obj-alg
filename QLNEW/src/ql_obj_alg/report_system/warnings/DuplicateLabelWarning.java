package ql_obj_alg.report_system.warnings;

public class DuplicateLabelWarning extends Warning{
	String label;
	
	public DuplicateLabelWarning(String label){
		this.label = label;
	}
	
	public String toString(){
		return "Duplicated label: "+label;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof DuplicateLabelWarning){
			DuplicateLabelWarning warn = (DuplicateLabelWarning) obj;
			
			if(this.label == warn.label || (this.label != null && this.label.equals(warn.label)))
				return true;
		}
		return false;
	}

}
