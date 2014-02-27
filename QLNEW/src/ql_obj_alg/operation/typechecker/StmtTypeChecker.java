package ql_obj_alg.operation.typechecker;


import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import ql_obj_alg.object_algebra_interfaces.IStmtAlg;
import ql_obj_alg.report_system.error_reporting.ErrorReporting;
import ql_obj_alg.types.Type;

public class StmtTypeChecker extends ExprTypeChecker implements
		IStmtAlg<IExpType, ITypeCheck> {
	
	Set<String> labels = new HashSet<String>();

	
	public StmtTypeChecker(Map<String, Type> memory, ErrorReporting report) {
		super(memory, report);
	}

	@Override
	public ITypeCheck iff(final IExpType cond, final ITypeCheck b) {
		return new ITypeCheck(){
			public void check(){
				Type t = cond.type(); 
				if(!t.isBoolean()){
						report.addError("Wrong type in if-then condition, expected boolean, got "+t.toString()+".");
				}
				b.check();
			}
		};
	}

	@Override
	public ITypeCheck iffelse(final IExpType cond, final ITypeCheck b1,
			final ITypeCheck b2) {
		return new ITypeCheck(){
			public void check(){
				Type t = cond.type(); 
				if(!t.isBoolean()){
						report.addError("Wrong type in if-then-else condition, expected boolean, got "+t.toString()+".");
				}
				b1.check();
				b2.check();
			}
		};
	}

	@Override
	public ITypeCheck comb(final List<ITypeCheck> stmtList) {
		return new ITypeCheck(){
			public void check(){
				for(ITypeCheck stmt : stmtList){
					stmt.check();
				}
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final Type type) {
		return new ITypeCheck(){
			public void check(){
				Type t = memory.get(id);
				if(t == null) 
					assert(false) : "Missing question with id "+id+" from memory.";
				if(!t.equals(type)){
					report.addError("Conflicting types of question "+ id + ", initially declared "+t.toString()+", redeclared "+type.toString()+".");
				}
				if(labels.contains(label)){
					report.addWarning("Duplicate label: "+label);
				}
				else
					labels.add(label);
			}
		};
	}

	@Override
	public ITypeCheck question(final String id, final String label, final Type type,
			final IExpType e) {
		return new ITypeCheck(){
			public void check(){

				ITypeCheck ordQuestion = question(id,label,type);
				ordQuestion.check();

				Type exprType = e.type(); 
				if(!exprType.equals(type)){
					report.addError("Conflicting type in question "+id+" assignment, expecting "+type.toString()+", got "+ exprType.toString() + ".");
				}

			}
		};
	}

}
