package com.org.migrate.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Sample client to generate the REST call.
 * @author ambika_b
 *
 */
public class ProducerClient {

	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/Migration/rest/migrate/data/post");
			String input = "{\"id\":\"23\",\"contents\":\"this is a post\"}";
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Resposnse text from the server " + output);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
