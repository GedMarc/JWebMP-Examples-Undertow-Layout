package com.jwebmp.examples.undertow.layout.outerlayout;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.Div;
import com.jwebmp.examples.undertow.layout.innerlayout.InnerScreen;
import com.jwebmp.plugins.jquerylayout.layout.BorderLayout;

@SuppressWarnings("unchecked")
public class OuterScreen extends BorderLayout
{
	public OuterScreen(ComponentHierarchyBase base)
	{
		super(base);

		getNorth().getHeaders()
				.add(new Div<>("North Header"));
		getNorth().getContentDiv()
				.add("North Content Div");
		getNorth().getFooters()
				.add(new Div<>("North Footer"));


		getWest().getContentDiv()
				.add(new OuterWestScreen());
		getWest().addHeader("Outer West Header");
		getWest().addFooter("Outer West Footer");


		getSouth().getContentDiv()
				.add("Outer South Content");
		getSouth().addHeader("Outer South Header");
		getSouth().addFooter("Outer South Footer");
		getSouth().addFooter("Outer South Footer 2");
		getSouth().addFooter("Outer South Footer 3");


		getEast().getContentDiv()
				.add("Outer East Content");
		getEast().addHeader("Outer East Header");
		getEast().addFooter("Outer East Footer");

		Div innerContent = new Div();
		innerContent.addStyle("height", "100%");
		InnerScreen innerLayout = new InnerScreen(innerContent);
		getCenter().getContentDiv()
				.add(innerContent);
	}

}
