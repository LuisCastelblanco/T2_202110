package model.logic;

import java.sql.Date;

public class VideoYoutube implements Comparable<VideoYoutube>{
	
	//Atributos
	
	private String video_id;
	private String trending_date;
	private String title;
	private String channel_title;
	private int category_id;
	private String publish_time;
	private String tags;
	private int views;
	private int likes;
	private int dislikes;
	private int comment_count;
	private String link;
	private boolean comment_activate;
	private boolean ratings_disabled;
	private boolean video_removed;
	private String description;
	private String country;
	
	
	public VideoYoutube(String id, String trending, String titulo, String canal , int categoria, String publicacion, String tag, int view, int losLikes, int losDislikes, int contadorCom , String elLink , boolean comen , boolean rating , boolean videoRem , String descrip, String pais ) {
	 id= video_id;
	 trending= trending_date;
	 titulo= title;
	 canal = channel_title;
	 categoria = category_id;
	 publicacion= publish_time;
	 tag = tags;
	 view = views;
	 losLikes= likes;
	 losDislikes= dislikes;
	 contadorCom = comment_count;
	 elLink = link;
	 comen= false;
	 rating = false;
	 videoRem  = false;
	 descrip = description;
	 pais = country;
		
	}
	 
	
	public String darId(){
		return video_id;
	}
	
	public String darTrending (){
		return trending_date;
	}
	
	public String darTitulo(){
		return title;
	}
	
	public String darCanal (){
		return channel_title;
	}
	
	public int darCategoria(){
		return category_id;
	}
	public  String darFechaPublicacion (){
		return publish_time;
	}
	
	public String dartags(){
		return tags;
	}
	
	public int darLikes (){
		return likes;
	}
	
	public int darDislikes(){
		return dislikes;
	}
	public int darContadorComenntarios (){
		return comment_count;
	}

	public String darLink () {
		return link;
	}
	
	public boolean darComentarioActivado (){
		return comment_activate;
	}
	
	public boolean darRatingDisable (){
		return ratings_disabled;
	}
	
	public boolean darVideoRemove(){
		return video_removed;
	}
	
	public String darDescripcion (){
		return description;
	}
	
	public String darPais(){
		return country;
	}
	
	public String datosBasicos( )
	{
		return ""+ video_id + ", "+ title + ", " + channel_title + ", " + publish_time + ", " + views +  ", " + description ;
	}

		@Override
		public int compareTo(VideoYoutube otro) {
			
			
			return 0;
		}


}
