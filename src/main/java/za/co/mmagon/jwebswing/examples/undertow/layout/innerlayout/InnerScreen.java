package za.co.mmagon.jwebswing.examples.undertow.layout.innerlayout;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.BorderLayout;

public class InnerScreen extends BorderLayout
{
	/**
	 * Sets a component as a border layout container
	 *
	 * @param component
	 */
	public InnerScreen(ComponentHierarchyBase component)
	{
		super(component);
		//ID needed for inner layout specs
		component.setID("innerLayout");

		getNorth().addHeader("Inner North Header 1");
		getNorth().addHeader("Inner North Header 2");
		getNorth().addHeader("Inner North Header 3");
		getNorth().getContentDiv()
				.add("North Content Div");
		getNorth().addFooter("Inner North Footer 1");
		getNorth().addFooter("Inner North Footer 2");
		getNorth().addFooter("Inner North Footer 3");

		getEast().addHeader("Inner East Header 1");
		getEast().addHeader("Inner East Header 2");
		getEast().addHeader("Inner East Header 3");
		getEast().addFooter("Inner East Footer 1");
		getEast().addFooter("Inner East Footer 2");
		getEast().addFooter("Inner East Footer 3");

		getWest().addHeader("Inner West Header 1");
		getWest().addHeader("Inner West Header 2");
		getWest().addHeader("Inner West Header 3");
		getWest().addFooter("Inner West Footer 1");
		getWest().addFooter("Inner West Footer 2");
		getWest().addFooter("Inner West Footer 3");

		getSouth().addHeader("Inner South Header 1");
		getSouth().addHeader("Inner South Header 2");
		getSouth().addHeader("Inner South Header 3");
		getSouth().addFooter("Inner South Footer 1");
		getSouth().addFooter("Inner South Footer 2");
		getSouth().addFooter("Inner South Footer 3");

	}


}
