/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.examples.undertow.layout.innerlayout;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.plugins.jquerylayout.layout.BorderLayout;
import com.jwebmp.plugins.jqueryui.tabs.JQUITabContent;
import com.jwebmp.plugins.jqueryui.tabs.JQUITabs;

public class InnerScreen
		extends BorderLayout
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


		getWest().addHeader("Layout JQUI Tabs Demo");

		getSouth().addHeader("Inner South Header 1");
		/*getSouth().addHeader("Inner South Header 2");
		getSouth().addHeader("Inner South Header 3");
		getSouth().addFooter("Inner South Footer 1");
		getSouth().addFooter("Inner South Footer 2");
		getSouth().addFooter("Inner South Footer 3");*/

		addTabsDemo();

	}

	private void addTabsDemo()
	{
		JQUITabs<?> tabs = new JQUITabs<>();
		tabs.setID("tabsDemo");
		tabs.asMe()
		    .addTab("Tab 1", new JQUITabContent());
		tabs.asMe()
		    .addTab("Tab 2", new JQUITabContent());
		tabs.asMe()
		    .addTab("Tab 3", new JQUITabContent());
		getSouth().getContentDiv()
		          .add(tabs);
	}

}
