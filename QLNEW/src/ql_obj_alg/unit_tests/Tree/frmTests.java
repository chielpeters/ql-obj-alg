package ql_obj_alg.unit_tests.Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import ql_obj_alg.operation.builder.IBuildF;
import ql_obj_alg.parsers.antlr4_generated_parser.QLParser;
import ql_obj_alg.parsers.parser.Parser;
import ql_obj_alg.report_system.parse_error_strategy.BailErrorStrategy;
import ql_obj_alg.unit_tests.Tree.test_algebra.ITest;
import ql_obj_alg.unit_tests.Tree.test_algebra.Tester;

import org.antlr.v4.runtime.RecognitionException;

public class frmTests{

	@Test(expected=RecognitionException.class)
	public void testEmptyForm() {
		ITest formAlg = getTestAlgebraObject("form testform { }");
		assertTrue(formAlg.isForm().isTrue());
	}
	
	private static ITest getTestAlgebraObject(String expr){
		IBuildF exprBuilder = getFormTree(expr);
		Tester tester = new Tester();
		return exprBuilder.build(tester,tester,tester);		
	}
	
	private static IBuildF getFormTree(String expr){
		QLParser qlParser = getParser(expr);
		return qlParser.form().frm;
	}
	
	private static QLParser getParser(String expr) {
		QLParser qlParser = Parser.parse(Parser.getInputStream(expr));
		qlParser.setErrorHandler(new BailErrorStrategy());		
		//Errors printing removed for the null pointer exceptions
		qlParser.removeErrorListeners();
		return qlParser;
	}
}