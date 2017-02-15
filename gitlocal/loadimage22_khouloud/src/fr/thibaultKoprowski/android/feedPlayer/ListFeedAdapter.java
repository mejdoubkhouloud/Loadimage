package fr.thibaultKoprowski.android.feedPlayer;

import java.util.ArrayList;

import com.example.loadimage.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListFeedAdapter extends BaseAdapter {

	// les donn�es � afficher
	private ArrayList<Feed> feeds;
	
	// * Le LayoutInflater permet de parser un layout XML et de 
	// * te transcoder en IHM Android. Pour respecter l'interface 
	// * BaseAdapter 
	 
	private LayoutInflater inflater;
	
	public ListFeedAdapter(Context context,ArrayList<Feed> feeds) {
		inflater = LayoutInflater.from(context);
		this.feeds = feeds;
		
	}
	
	// * il nous faut sp�cifier la m�thode "count()". 
	// * Cette m�thode permet de conna�tre le nombre d'items pr�sent 
	// * dans la liste. Dans notre cas, il faut donc renvoyer le nombre
	// * de personnes contenus dans "mListP".
	
//	@Override
//	public int getCount() {
//		return feeds.size();
//	}

	
	 // Permet de retourner un objet contenu dans la liste
	
	@Override
	public Object getItem(int index) {
		return feeds.get(index);
	}

	@Override
	public long getItemId(int index) {
		return this.feeds.get(index).getId();
		
	}

	
	 // * Voici la partie la plus complexe de la classe
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		// * Le param�tre "convertView" permet de recycler les �lements 
		// * de notre liste. En effet, l'op�ration pour convertir un layout 
		// * XML en IHM standard est tr�s couteuse pour la plateforme Android. 
		// * On nous propose ici de r�utiliser des occurences cr��es qui ne sont 
		// * plus affich�es. Donc si ce param�tre est "null" alors, il faut "inflater" 
		// * notre layout XML, sinon on le r�utilise
		FeedView fv;		
		
		if (convertView == null) {
			fv = new FeedView();
			convertView = inflater.inflate(R.layout.feed_view, null);

			fv.creator = (TextView)convertView.findViewById(R.id.creator);			
			fv.title = (TextView)convertView.findViewById(R.id.title);
			fv.pubDate = (TextView)convertView.findViewById(R.id.pub_date);
			convertView.setTag(fv);

		} else {
			fv = (FeedView) convertView.getTag();
		}						
		fv.creator.setText(feeds.get(position).getCreator());
		fv.pubDate.setText(feeds.get(position).getPubDate());
		fv.title.setText(feeds.get(position).getTitle());
		
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
