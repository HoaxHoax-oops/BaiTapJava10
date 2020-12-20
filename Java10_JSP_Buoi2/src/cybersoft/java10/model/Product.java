package cybersoft.java10.model;

public class Product {
	/* properties */
	private int id;
	private String name;
	private String code;
	private String description;
	private float price;

	/* constructors */
	public Product(int id, String name, String code, String description, float price) {
		this.id 			= id;
		this.name 			= name;
		this.code 			= code;
		this.description	= description;
		this.price 			= price;
	}
	
	public Product() {
		this.id 			= 0;
		this.name 			= "";
		this.code 			= "";
		this.description	= "";
		this.price 			= 0f;
	}
	
	/* getters/setters */
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
