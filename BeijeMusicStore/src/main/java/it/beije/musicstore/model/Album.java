//package it.beije.musicstore.model;
//
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "album")
//public class Album {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//	
//	@Column(name = "id_artist")
//	private Integer id_artist;
//	
//	@Column(name = "title")
//	private String title;
//	
//	@Column(name = "data")
//	private Date data;
//	
//	@Column(name = "genre")
//	private String genre;
//	
//	@Column(name = "n_songs")
//	private Integer n_songs;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	
//
//	public Integer getId_artist() {
//		return id_artist;
//	}
//
//	public void setId_artist(Integer id_artist) {
//		this.id_artist = id_artist;
//	}
//	
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
//
//	public Date getData() {
//		return data;
//	}
//
//	public void setData(Date data) {
//		this.data = data;
//	}
//	
//
//	public String getGenre() {
//		return genre;
//	}
//
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//	
//
//	public Integer getN_songs() {
//		return n_songs;
//	}
//
//	public void setN_songs(Integer n_songs) {
//		this.n_songs = n_songs;
//	}
//	
//	
//	
//}