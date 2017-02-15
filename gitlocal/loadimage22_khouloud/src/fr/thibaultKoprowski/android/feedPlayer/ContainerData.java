package fr.thibaultKoprowski.android.feedPlayer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;

public class ContainerData {	
	
	static public Context context;
	
	public ContainerData() {

	}

	
	public static ArrayList<Feed> getFeeds(){
		// On passe par une classe factory pour obtenir une instance de sax
		SAXParserFactory fabrique = SAXParserFactory.newInstance();
		SAXParser parseur = null;
		ArrayList<Feed> feeds = null;
		try {
			// On "fabrique" une instance de SAXParser
			parseur = fabrique.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		// On défini l'url du fichier XML
		URL url = null;
		try {
			url = new URL("/thibault-/jg)^mkokkkèèèprowski.fr/feed");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		/* 
		 * Le handler sera gestionnaire du fichier XML c'est à dire que c'est lui qui sera chargé
		 * des opérations de parsing. On vera cette classe en détails ci après.
		*/
		DefaultHandler handler = new ParserXMLHandler();
		try {
			// On parse le fichier XML
			try {
				parseur.parse(url.openConnection().getInputStream(), handler);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// On récupère directement la liste des feeds
			feeds = ((ParserXMLHandler) handler).getData();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// On la retourne l'array list
		return feeds;
	}

}
