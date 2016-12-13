package com.crossover.trip.reservation.routes;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.crossover.trip.reservation.services.SearchRoomService;


public class SearchRoomRouteBuilder extends RouteBuilder {

	/**
	 * Configure the routes to access the micro service.
	 * Define the mapping between the service's URL and the bean to process the business functions.
	 * Among the operations, the service allows:
	 * <ul>
	 * 		<li>Search a rooms available by certaing criteria.</li>
	 * </ul>
	 */
	  @Override
	  public void configure() throws Exception {
	    from("direct:getRooms")
	    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
	    .setExchangePattern(ExchangePattern.InOut)
	    .unmarshal().json(JsonLibrary.Jackson)
	    .bean(new SearchRoomService(), "searchRooms");
	    
	    // add HTTP interface
	    from("jetty:http://0.0.0.0:{{port}}/getRooms")
	    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
	    .setExchangePattern(ExchangePattern.InOut)
	    .to("direct:getRooms");
	  }

}
