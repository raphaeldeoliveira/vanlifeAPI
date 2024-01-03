package br.com.teste.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vanslist")
public class Van implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vanname", nullable = false, length = 30)
	private String vanName;
	
	@Column(name = "vanprice", nullable = false)
	private float vanPrice;
	
	@Column(name = "typelocation", length = 20)
	private String typeLocation;
	
	@Column(name = "vancategory", length = 20)
	private String vanCategory;
	
	@Column(name = "imageurl", nullable = false, length = 255)
	private String urlImage;
	
	@Column(name = "description", nullable = false, length = 500)
	private String description;
	
	public Van() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVanName() {
		return vanName;
	}

	public void setVanName(String vanName) {
		this.vanName = vanName;
	}

	public float getVanPrice() {
		return vanPrice;
	}

	public void setVanPrice(float vanPrice) {
		this.vanPrice = vanPrice;
	}

	public String getTypeLocation() {
		return typeLocation;
	}

	public void setTypeLocation(String typeLocation) {
		this.typeLocation = typeLocation;
	}

	public String getVanCategory() {
		return vanCategory;
	}

	public void setVanCategory(String vanCategory) {
		this.vanCategory = vanCategory;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, typeLocation, urlImage, vanCategory, vanName, vanPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Van other = (Van) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(typeLocation, other.typeLocation) && Objects.equals(urlImage, other.urlImage)
				&& Objects.equals(vanCategory, other.vanCategory) && Objects.equals(vanName, other.vanName)
				&& Float.floatToIntBits(vanPrice) == Float.floatToIntBits(other.vanPrice);
	}

}
