package com.crossover.trip.reservation.routes;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.crossover.trip.reservation.services.SearchTripPackagesService;


public class SearchTripPackagesRouteBuilder extends RouteBuilder {

	/**
	 * Configure the routes to access the micro service.
	 * Define the mapping between the service's URL and the bean to process the business functions.
	 * Among the operations, the service allows:
	 * <ul>
	 * 		<li>Search trip programs by certain criteria.</li>
	 * </ul>
	 */
	  @Override
	  public void configure() throws Exception {
	    from("direct:getTripPackages")
	    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
	    .setExchangePattern(ExchangePattern.InOut)
	    .unmarshal().json(JsonLibrary.Jackson)
	    .bean(new SearchTripPackagesService(), "searchTripPackages");
	    // add HTTP interface
	    from("jetty:http://0.0.0.0:{{port}}/getTripPackages")
	    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
	    .setExchangePattern(ExchangePattern.InOut)
	    .to("direct:getTripPackages");
	  }

}
