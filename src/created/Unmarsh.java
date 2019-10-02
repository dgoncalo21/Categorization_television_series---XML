package created;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import generatedSelec.Scatalog;
import generatedProcess.ACatalog;

public class Unmarsh
{

	public static Scatalog unCatal() throws Exception
	{
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("ficheiroxsd.xsd")); //atribuir o xsd ao objeto schema

		JAXBContext jc = JAXBContext.newInstance(Scatalog.class);

		Unmarshaller unmarshaller = jc.createUnmarshaller();
		unmarshaller.setSchema(schema); //passar o xsd para fazer a validacao do xml
		unmarshaller.setEventHandler(new Validator());
		Scatalog catalogo = (Scatalog) unmarshaller.unmarshal(new File("ficheiro.xml")); //unmarshal do xml para objeto
		return catalogo;
	}

	public static Scatalog unProcess() throws Exception
	{
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("ficheiroxsd.xsd"));

		JAXBContext jc = JAXBContext.newInstance(Scatalog.class);

		Unmarshaller unmarshaller = jc.createUnmarshaller();
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(new Validator());
		Scatalog catalogo = (Scatalog) unmarshaller.unmarshal(new File("afterSelector.xml"));
		return catalogo;
	}
	
	public static ACatalog unHtml() throws Exception
	{
		//apesar de dar return apenas serve para validar o xml
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("process.xsd"));

		JAXBContext jc = JAXBContext.newInstance(ACatalog.class);

		Unmarshaller unmarshaller = jc.createUnmarshaller();
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(new Validator());
		ACatalog catalogo = (ACatalog) unmarshaller.unmarshal(new File("afterProcessor.xml"));
		return catalogo;
	}

}