package ql_obj_alg.operation.evaluator.value;

public class VUndefined extends VBase{

	@Override 
	public Boolean getBoolean(){
		return new Boolean(false);
	}
	@Override
	public Value div(Value v) {
		return new VUndefined();
	}

	@Override
	public Value div(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value div(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value div(VString v) {
		return new VUndefined();
	}

	@Override
	public Value div(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value add(Value v) {
		return new VUndefined();
	}

	@Override
	public Value add(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value add(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value add(VString v) {
		return new VUndefined();
	}

	@Override
	public Value add(VUndefined v) {
		return new VUndefined();
	}


	@Override
	public Value min(Value v) {
		return new VUndefined();
	}

	@Override
	public Value min(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value min(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value min(VString v) {
		return new VUndefined();
	}

	@Override
	public Value min(VUndefined v) {
		return new VUndefined();
	}


	@Override
	public Value lt(Value v) {
		return new VUndefined();
	}

	@Override
	public Value lt(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value lt(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value lt(VString v) {
		return new VUndefined();
	}

	@Override
	public Value lt(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value leq(Value v) {
		return new VUndefined();
	}

	@Override
	public Value leq(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value leq(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value leq(VString v) {
		return new VUndefined();
	}

	@Override
	public Value leq(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value gt(Value v) {
		return new VUndefined();
	}

	@Override
	public Value gt(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value gt(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value gt(VString v) {
		return new VUndefined();
	}

	@Override
	public Value gt(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value geq(Value v) {
		return new VUndefined();
	}

	@Override
	public Value geq(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value geq(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value geq(VString v) {
		return new VUndefined();
	}

	@Override
	public Value geq(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value eq(Value v) {
		return new VUndefined();
	}

	@Override
	public Value eq(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value eq(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value eq(VString v) {
		return new VUndefined();
	}

	@Override
	public Value eq(VUndefined v) {
		return new VBoolean(true);
	}

	@Override
	public Value neq(Value v) {
		return new VUndefined();
	}

	@Override
	public Value neq(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value neq(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value neq(VString v) {
		return new VUndefined();
	}

	@Override
	public Value neq(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value and(Value v) {
		return new VUndefined();
	}

	@Override
	public Value and(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value and(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value and(VString v) {
		return new VUndefined();
	}

	@Override
	public Value and(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value or(Value v) {
		return new VUndefined();
	}

	@Override
	public Value or(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value or(VBoolean v) {
		return v;
	}

	@Override
	public Value or(VString v) {
		return new VUndefined();
	}

	@Override
	public Value or(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value mul(Value v) {
		return new VUndefined();
	}

	@Override
	public Value mul(VInteger v) {
		return new VUndefined();
	}

	@Override
	public Value mul(VBoolean v) {
		return new VUndefined();
	}

	@Override
	public Value mul(VString v) {
		return new VUndefined();
	}

	@Override
	public Value mul(VUndefined v) {
		return new VUndefined();
	}

	@Override
	public Value not() {
		return new VBoolean(true);
	}

}
