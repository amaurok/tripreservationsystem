package com.crossover.trip.reservation.routes;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.crossover.trip.reservation.services.PostRoomService;



public class PostRoomRouteBuilder extends RouteBuilder {

	/**
	 * Configure the routes to access the micro service.
	 * Define the mapping between the service's URL and the bean to process the business functions.
	 * Among the operations, the service allows:
	 * <ul>
	 * 		<li>Save a new room posted as available.</li>
	 * </ul>
	 */
	  @Override
	  public void configure() throws Exception {
	    from("direct:postRoom")
	    .setHeader(Exchange.HTTP_METHOD, constant("POST"))
	    .setExchangePattern(ExchangePattern.InOut)
	    .unmarshal().json(JsonLibrary.Jackson)
	    .bean(new PostRoomService(), "saveRoom");
	    
	    // add HTTP interface
	    from("jetty:http://0.0.0.0:{{port}}/postRoom")
	    .setHeader(Exchange.HTTP_METHOD, constant("POST"))
	    .setExchangePattern(ExchangePattern.InOut)
	    .to("direct:postRoom");
	  }

}
