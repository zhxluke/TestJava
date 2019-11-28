package com.lcb.visitor;

import java.util.Collection;
import java.util.Iterator;

public class MyVisitor implements Visitor {

	public void visitString(StringElement stringE) {
		System.out.println("'" + stringE.getValue() + "'");
	}

	public void visitCollection(Collection<Visitable> collection) {
		Iterator<Visitable> iterator = collection.iterator();
		while (iterator.hasNext()) {
			iterator.next().accept(this);
		}
	}

	public void visitFloat(FloatElement floatE) {
		System.out.println(floatE.getValue().toString() + "f");
	}
}
