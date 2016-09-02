/**
 * 
 */
package app04a.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * @author J Bruen
 *
 */
@Entity
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	  public Phone(int start, int middle, int end) {
		  this.areaCode = start;
		  this.prefix = middle;
		  this.number = end;
	  }
	  
	  public Phone () {
		  
	  }

	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    long id;
	
	@Column(name = "AREA_CODE")
	private Integer areaCode;
	@Column(name = "P_NUMBER")
  	private Integer number;
  	private Integer prefix;
	
  	// Does EXTRA  [N+1] select if bidirectional on fetch...
  	// Could make lazy on product.java
	@OneToOne(mappedBy="hotLine" , cascade = CascadeType.ALL)
	Product product;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
 
	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer area) {
		this.areaCode = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
 }
