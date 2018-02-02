package za.co.mmagon.jwebswing.examples.undertow.layout;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.examples.undertow.layout.outerlayout.OuterScreen;
import za.co.mmagon.logger.LogFactory;
import za.co.mmagon.logger.handlers.ConsoleSTDOutputHandler;

import javax.servlet.ServletException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LayoutDemo extends Page
{
	private static final Logger log = LogFactory.getLog("UndertowHelloWorld");

	public LayoutDemo()
	{
		super("Layout Demo 1.6");
		OuterScreen screen = new OuterScreen(getBody());
		AngularPageConfigurator.setRequired(true);
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

	/**
	 * This part runs the web site :)
	 *
	 * @param args
	 *
	 * @throws ServletException
	 */
	public static void main(String[] args) throws ServletException
	{
		Handler[] handles = Logger.getLogger("")
				                    .getHandlers();
		for (Handler handle : handles)
		{
			handle.setLevel(Level.FINE);
		}
		LogFactory.setDefaultLevel(Level.FINE);
		Logger.getLogger("")
				.addHandler(new ConsoleSTDOutputHandler(true));
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
				                  .addHttpListener(6002, "localhost")
				                  .setHandler(jwebSwingHandler)
				                  .build();
		server.start();
	}
}
