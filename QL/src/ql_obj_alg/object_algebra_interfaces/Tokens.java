package ql_obj_alg.object_algebra_interfaces;

import ql_obj_alg.pgen.Skip;
import ql_obj_alg.pgen.Token;
import ql_obj_alg.types.Type;
import ql_obj_alg.types.TypeFactory;

public interface Tokens {
	
	@Token("'\"' (('\\\\' [btnr\"\\\\]) | .)*? '\"'")
	public static String string(String x) {
		// todo: unescaping
		return x.substring(1, x.length() - 1);
	}
	
	@Token("[0-9]+")
	public static int integer(String x) {
		return Integer.parseInt(x);
	}
	
	@Token("'true'|'false'")
	public static boolean bool(String x) {
		return Boolean.parseBoolean(x);
	}
	
	@Token("[a-zA-Z][a-zA-Z0-9]*")
	public static String id(String x) {
		return x;
	}
	
	@Token("'boolean'|'string'|'integer'") 
	public static Type type(String x) {
		return TypeFactory.createType(x);
	}
	
	@Token("[ \\t\\r\\n]+") @Skip
	void ws();
	
	@Token("'//' .*? '\\n'") @Skip
	void comment();

}
