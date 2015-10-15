package com.crunchify.restjersey;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "book")
public class Book {
	Date publishDate = new Date();
    String author = "non";
    String title = "non";
    String ISBN = "non";
 
    public Date getPublishDate() {
    	
        return publishDate;
    }
 
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getISBN() {
        return ISBN;
    }
 
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}


