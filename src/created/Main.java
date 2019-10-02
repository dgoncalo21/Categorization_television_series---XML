package created;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import generatedProcess.*;
import generatedSelec.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Main
{
	public static void main(String[] args) throws Exception
	{

		// BLOCO SELECTOR

		JAXBContext jc = JAXBContext.newInstance(Scatalog.class);
		List<String> selector = Selector.Select(); //obter o input do user
		Scatalog newCatalog = new Scatalog(); //novo objecto
		List<Serie> novaLista = serieSelec.Select(selector); // lista de series restringido
		newCatalog.setSerie(novaLista); // associar ao objecto a nova lista

		
		// Marshal do que sai do Selector
		File abc = new File("afterSelector.xml");
		Marshaller jaxbMarshaller = jc.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(newCatalog, abc);
		// jaxbMarshaller.marshal(newCatalog, System.out);

		// BLOCO PROCESSOR
		ACatalog postProc = Processor.Process(); //obter o objeto processado

		
		//Marshal do que sai do processor
		File def = new File("afterProcessor.xml");
		JAXBContext jc2 = JAXBContext.newInstance(ACatalog.class);
		Marshaller jaxbMarshaller2 = jc2.createMarshaller();
		jaxbMarshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller2.marshal(postProc, def);

		
		// BLOCO HTMLViewer
		HtmlGenerator.Generate();

	}
}
