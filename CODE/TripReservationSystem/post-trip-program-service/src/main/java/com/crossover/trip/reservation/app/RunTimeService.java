package com.crossover.trip.reservation.app;

import org.apache.camel.main.Main;

import com.crossover.trip.reservation.routes.PostTripProgramRouteBuilder;

/**
 * Create a new runtime instance of the PostTripProgramService.
 *
 */
public class RunTimeService {

	private Main main;

	  public static void main(String[] args) throws Exception {
	    RunTimeService app = new RunTimeService();
	    final String port = (args.length == 1 ? args[0] : "8765");
	    app.boot(port);
	  }

	  /**
	   * Boot the new service instance.
	   * Setup the deployment features for the service, and add the routes.
	   * 
	   * @param port
	   * @throws Exception
	   */
	  public void boot(String port) throws Exception {
	    System.setProperty("port", port);

	    // create a Main instance
	    main = new Main();
	    // enable hangup support so you can press ctrl + c to terminate the JVM
	    main.enableHangupSupport();
	    // add routes
	    main.addRouteBuilder(new PostTripProgramRouteBuilder());

	    // run until you terminate the JVM
	    System.out.println(String.format("Starting Camel, using port %s. Use ctrl + c to terminate the JVM.", port));
	    main.run();
	  }

}
