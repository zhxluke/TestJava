package com.lcb.visitor;

import java.util.ArrayList;
import java.util.Collection;

public class TestVisitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		StringElement stringE = new StringElement("I am a String");
		visitor.visitString(stringE);
		Collection<Visitable> list = new ArrayList<Visitable>();
		list.add(new StringElement("I am a String1"));
		list.add(new StringElement("I am a String2"));
		list.add(new FloatElement(new Float(12)));
		list.add(new StringElement("I am a String3"));
		visitor.visitCollection(list);
	}

}
