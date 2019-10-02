package created;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HtmlGenerator
{
	public static void Generate() throws Exception
	{
		// Input xml data file

		Unmarsh.unHtml(); //validacao do afterProcess
		
		String xmlInput = "afterProcessor.xml";
		FileInputStream xml = new FileInputStream(xmlInput);

		String xslInput = "catalog_to_html.xsl";
		FileInputStream xsl = new FileInputStream(xslInput);

		String htmlOutput = "html.html";
		FileOutputStream os = new FileOutputStream(htmlOutput);

		TransformerFactory tFactory = TransformerFactory.newInstance();

		StreamSource styleSource = new StreamSource(xsl);
		Transformer transformer = tFactory.newTransformer(styleSource);

		StreamSource xmlSource = new StreamSource(xml);
		StreamResult result = new StreamResult(os);
		transformer.transform(xmlSource, result);
	}
}
