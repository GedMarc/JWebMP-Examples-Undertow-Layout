/*
 * Copyright (C) 2017 GedMarc
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

package com.jwebmp.examples.undertow.layout;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.examples.undertow.layout.outerlayout.OuterScreen;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import javax.servlet.ServletException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LayoutDemo
		extends Page
{
	private static final Logger log = LogFactory.getLog("UndertowHelloWorld");

	public LayoutDemo()
	{
		super("Layout Demo 1.6");
		OuterScreen screen = new OuterScreen();
		screen.setFullScreen(true);
		screen.setID("OuterScreen");
		add(screen);
	}

	/**
	 * This part runs the web site :)
	 *
	 * @param args
	 *
	 * @throws ServletException
	 */
	public static void main(String[] args) throws ServletException
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		DeploymentInfo servletBuilder = Servlets.deployment()
		                                        .setClassLoader(LayoutDemo.class.getClassLoader())
		                                        .setContextPath("/")
		                                        .setDeploymentName("layoutdemo.war");
		DeploymentManager manager = Servlets.defaultContainer()
		                                    .addDeployment(servletBuilder);
		manager.deploy();

		GuiceContext.inject();

		HttpHandler jwebSwingHandler = manager.start();
		Undertow server = Undertow.builder()
		                          .addHttpListener(6002, "0.0.0.0")
		                          .setHandler(jwebSwingHandler)
		                          .build();
		server.start();
	}

	/**
	 * Not needed at all, but beautiful for post load ajax operations, local storage identifying etc
	 *
	 * @param call
	 * 		A request scoped call object
	 * @param response
	 * 		A request scoped response object
	 *
	 * @return
	 */
	@Override
	public AjaxResponse onConnect(AjaxCall call, AjaxResponse response)
	{
		if (call != null)
		{
			log.log(Level.FINER, "This is the call object : {0}", call);
		}
		return super.onConnect(call, response);
	}
}
