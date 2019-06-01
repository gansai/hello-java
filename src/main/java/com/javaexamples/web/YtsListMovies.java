package com.javaexamples.web;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class YtsListMovies {

	public static void main(String[] args) {
		try{
			URL url = new URL("https://yts.to/api/v2/list_movies.xml?quality=3D");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");


			if (conn.getResponseCode() != 200)
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

/*			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String apiOutput = br.readLine();
			apiOutput = br.readLine();
			System.out.println(apiOutput);
*/
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = null;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			Document doc = dBuilder.parse(conn.getInputStream());
			doc.getDocumentElement().normalize();

			System.out.println("root of xml file " + doc.getDocumentElement().getNodeName());
			NodeList nodes = doc.getElementsByTagName("movie");

			for (int i = 0; i < nodes.getLength(); i++) 
			{
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("==========================");
					System.out.println("Movie Title: " + getValue("title", element));
					System.out.println("Movie Year: " + getValue("year", element));
					System.out.println("Movie Language " + getValue("language", element));
					System.out.println("Movie Rating " + getValue("rating", element));
					System.out.println("Size in bytes " + getValue("size_bytes", element));
				}
			}
			/*while (apiOutput !=null)
			{
				System.out.println(apiOutput);
				apiOutput = br.readLine();				
			}*/

			conn.disconnect();


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			e.printStackTrace();
		}
	}

	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
}

