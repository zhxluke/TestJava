package com.lcb.visitor;

import java.util.Collection;

public interface Visitor {
	void visitString(StringElement stringE);

	void visitFloat(FloatElement floatE);

	void visitCollection(Collection<Visitable> collection);
}
