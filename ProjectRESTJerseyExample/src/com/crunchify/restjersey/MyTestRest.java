package com.crunchify.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/mytest")
public class MyTestRest {
	
	@GET
	@Produces("text/plain")
	public String simpleString(){
		return "it is a Standart rec. for url my";
	} 
	
	
	@Path("/{name}")
	@GET
	@Produces("text/plain")
	public String dayHello(@PathParam("name") String name){
		return "Hello diar : " + name; 
	}
	
//+	
	@Path("/number/{value}")
	@GET
	@Produces("text/plain")
	public String incValue(@PathParam("value") float value){
		return "New value inc on 1 ! " + value++;
	}
	
	@Path("/add/{value}")
	@GET
	@Produces("text/plain")
	public String addValue(@PathParam("value") float value){
		return "New value add 5 ! " + value+5;
	}
	
	
	@Path("/xml")
	@GET
	@Produces("application/xml")
	public String xmlParam(){
		String xmlS = "<ctofservice>" + "<celsius>" + 10 + "</celsius>"
				+ "<ctofoutput>" + 15 + "</ctofoutput>" + "</ctofservice>";
		return xmlS;
	}
	
	@Path("/xml/{c}")
	@GET
	@Produces("application/xml")
	public String xmlParamV(@PathParam("c") float c){
		String xmlS = "<ctofservice>" + "<celsius>" + 10 + "</celsius>"
				+ "<ctofoutput>" + (c+10) + "</ctofoutput>" + "</ctofservice>";
		return xmlS;
	}
	 
	
	@Path("/xml/book")
	@GET
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public Book getBook(){
		return new Book();
	}
	
	@Path("/xml/book/{Author}/{Title}/{ISBN}")
	@GET
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public Book setAndGetBook(	@PathParam("Author") 	String Author,
								@PathParam("Title") 	String Title,
								@PathParam("ISBN") 		String ISBN){
		
		return getBooks(Author,Title,ISBN);
	}
		 
	@GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
	  public Book getBookJson() {
		Book book = getBooks("JsonA","JsonT","2556");
		  return book;
	  }
	
	  
	  
	  @Path("/json/{sameTask}")
	  @GET
	  @Produces("application/json") 
	  public Response getBookJsonRes(@PathParam("sameTask") float sameTask)throws JSONException{
		  JSONObject jsonObject = new JSONObject();
		  jsonObject.put("Send", sameTask);
		  jsonObject.put("Add to 2", sameTask+2);
		  String dd = jsonObject + "";
		  return Response.status(200).entity(dd).build();
		  
	  }
	  private Book getBooks(String Author, String Title , String ISBN){
	        Book book = new Book();
	        book.setAuthor(Author);
	        book.setTitle(Title);
	        book.setISBN(ISBN);
	        return book;
	    }
//*/	
	

}
