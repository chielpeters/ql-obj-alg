package ql_obj_alg.operation.cyclic_dependencies;

import ql_obj_alg.operation.cyclic_dependencies.graph_operations.FillDependencyGraph;

public interface IDependencyGraph {
	void dependencies(FillDependencyGraph dependencyGraph);
}
