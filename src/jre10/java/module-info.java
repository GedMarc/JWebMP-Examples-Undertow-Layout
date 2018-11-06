open module com.jwebmp.examples.undertow.layoutdemo {

	requires com.jwebmp.plugins.jqlayout;
	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.logmaster;

	requires undertow.core;
	requires undertow.servlet;
	requires java.logging;
	requires javax.servlet.api;
}