package ql_obj_alg.object_algebra_interfaces;

public interface IExpAlg<E>{

	@Syntax("'(' _ ')'")
	E bracket(E e);
	
	@Syntax("INT")
	E lit(int x);
	
	@Syntax("BOOL")
	E bool(boolean b);
	
	@Syntax("STRING")
	E string(String s);
	
	@Syntax("ID")
	E var(String varName);
	
	@Syntax("'!' _") @Precedence(200)
	E not(E exp);
	
	@Syntax("_ '*' _") @Precedence(100)
	E mul(E lhs, E rhs);
	
	@Syntax("_ '/' _") @Precedence(100)
	E div(E lhs, E rhs);
	
	@Syntax("_ '+' _") @Precedence(90)
	E add(E lhs, E rhs);
	
	@Syntax("_ '-' _") @Precedence(90)
	E sub(E lhs, E rhs);
	
	@Syntax("_ '==' _") @Precedence(80)
	E eq(E lhs, E rhs);
	
	@Syntax("_ '!=' _") @Precedence(80)
	E neq(E lhs, E rhs);
	
	@Syntax("_ '<' _") @Precedence(80)
	E lt(E lhs, E rhs);
	
	@Syntax("_ '<=' _") @Precedence(80)
	E leq(E lhs, E rhs);
	
	@Syntax("_ '>' _") @Precedence(80)
	E gt(E lhs, E rhs);
	
	@Syntax("_ '>=' _") @Precedence(80)
	E geq(E lhs, E rhs);
	
	@Syntax("_ '&&' _") @Precedence(70)
	E and(E lhs, E rhs);
	
	@Syntax("_ '||' _") @Precedence(60)
	E or(E lhs, E rhs);
}
