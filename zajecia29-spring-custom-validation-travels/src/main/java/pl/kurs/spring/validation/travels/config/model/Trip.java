package pl.kurs.spring.validation.travels.config.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import pl.kurs.spring.validation.travels.config.valid.DictionaryValue;
import pl.kurs.spring.validation.travels.config.valid.ValidateDates;

@ValidateDates(message = "Data wyjazdu nie moze byc pozniejsza niz data powrotu", errorProperty = "departmentDate")
public class Trip implements DateFromDateTo {

	@NotEmpty(message = "Kraj nie moze byc pusty")
	@DictionaryValue(dictionaryName = "countries")
	private String country;
	@NotEmpty(message = "Miejsce docelowe nie moze byc puste")
	private String destination;
	@NotNull(message = "Data wylotu nie moze byc pusta")
	private Date departureDate;
	@NotNull(message = "Data przylotu nie moze byc pusta")
	private Date returnDate;
	@NotNull(message = "Region nie moze byc pusty")
	@DictionaryValue(dictionaryName = "regions")
	private String region;
	@NotNull(message = "Cena nie mzoe byc puta")
	private BigDecimal price;

	public Trip() {
	}

	public Trip(String country, String destination, Date departureDate, Date returnDate, String region, BigDecimal price) {
		this.country = country;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.region = region;
		this.price = price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Trip [country=" + country + ", destination=" + destination + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", region=" + region + ", price=" + price + "]";
	}

	@Override
	public Date dateFrom() {
		return departureDate;
	}

	@Override
	public Date dateTo() {
		return returnDate;
	}

}
