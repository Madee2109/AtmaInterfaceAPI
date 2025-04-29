package org.bte.bean;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean ( name = "PrimefacesMedia" )
@SessionScoped
public class PrimefacesMedia {

	 private StreamedContent image;
	 
	 public void clear(){
		 image = null;
	 }
	 public void write(String filename,String contenttype,InputStream media_stream){
		 image =  new DefaultStreamedContent().builder().name("result.pdf").contentType(contenttype).stream(()->media_stream).build();
			
	 }
	 public StreamedContent getImage() {
			
				   
			 return image;  
			
		}
	 
	 public void setImage(StreamedContent image) {
			this.image = image;
		}

}
