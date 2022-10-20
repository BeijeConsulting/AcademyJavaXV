//package it.beije.magazzino.model;
//
//import com.fasterxml.jackson.annotation.JsonGetter;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonSetter;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
///*
//CREATE TABLE `hopper`.`users` (
//  `id` INT NOT NULL AUTO_INCREMENT,
//  `email` VARCHAR(100) NOT NULL,
//  `password` VARCHAR(45) NOT NULL,
//  `name` VARCHAR(45) NULL,
//  `surname` VARCHAR(45) NULL,
//  PRIMARY KEY (`id`),
//  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
// */
//
//@Entity
//@Table(name = "users")
//@JsonInclude(Include.NON_NULL)
//public class User {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//
//	@Column(name = "email")
//	private String email;
//
//	@Column(name = "password")
//	private String password;
//
//	@Column(name = "surname")
//	private String lastName;
//
//	@Column(name = "name")
//	private String firstName;
//
//	@Transient
//	private LocalDateTime datetime;
//
//	public LocalDateTime getDatetime() {
//		return datetime;
//	}
//
//	@JsonGetter(value = "datetime")
//	public String getDatetimeAsString() {
//		return datetime == null ? null : datetime.format(DateTimeFormatter.BASIC_ISO_DATE);
//	}
//
//	public void setDatetime(LocalDateTime datetime) {
//		this.datetime = datetime;
//	}
//
//	@JsonSetter(value = "datetime")
//	public void setDatetime(String datetime) {
//		System.out.println("datetime pre: " + datetime);
//		this.datetime = LocalDateTime.of(LocalDate.parse(datetime, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0, 0));
//		System.out.println("datetime post: " + datetime);
//	}
//
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
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String toString() {
//		StringBuilder builder = new StringBuilder()
//				.append("{ id : ").append(this.id)
//				.append(", email : ").append(this.email)
//				.append(", firstName : ").append(this.firstName)
//				.append(", lastName : ").append(this.lastName)
//				.append(", password : ").append(this.password)
//				.append(" }");
//
//		return builder.toString();
//	}
//}
