package com.drm.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.drm.generated.ObjectFactory;
import com.drm.generated.QueryType;

public class ReqResBuilder {
  public static final String QUERY = "<query><and><match field=\"a\" value=\"b\"/>"
      + "<match field=\"c\"><value>d</value><value>e</value></match>"
      + "</and></query>";
  
  public static String getQuery(QueryType queryType) throws Exception {
    JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
    Marshaller marshaller = context.createMarshaller();
    StringWriter sw = new StringWriter();
    marshaller.marshal(new ObjectFactory().createQuery(queryType), sw);
    
    return sw.toString();
  }
  
  public static QueryType getQueryType(String query) throws Exception {
    JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    StringReader sr = new StringReader(query);
    
    @SuppressWarnings("unchecked")
    JAXBElement<QueryType> obj = (JAXBElement<QueryType>)unmarshaller.unmarshal(sr);
    return obj.getValue();
  }
}
