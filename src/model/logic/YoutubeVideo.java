package model.logic;

import java.util.Date;

public class YoutubeVideo implements Comparable<YoutubeVideo>{
	
	//Atributos
	
	private String video_id;
	private Date trending_date;
	private String title;
	private String channel_title;
	private int category_id;
	 
	public int compareTo(YoutubeVideo o,YoutubeVideo y) {
		
		if( o.trending_date.compareTo(y.trending_date)<1){
			
		}
	}

}


