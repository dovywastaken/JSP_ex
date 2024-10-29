package dto;

import java.io.Serializable;

public class Book   implements Serializable
{
	
	private static final long serialVersionUID = -4274700572038677000L;
	
	
	//변수 설정
	private String bookId;
	private String bookname;
	private int unitPrice;
	private String author;
	private String bookdescription;
	private String publisher;
	private String category;
	private long unitsInStock;
	private String releaseDate;
	private String bookcondition;
	private String filename;
	private int quantity; //13장에서 추가됨
	
	//생성자

	public Book() 
	{
		super();
	}
	
	public Book(String bookId, String bookname, int unitPrice) 
	{
		this.bookId = bookId;
		this.bookname = bookname;
		this.unitPrice = unitPrice;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookdescription() {
		return bookdescription;
	}

	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getBookcondition() {
		return bookcondition;
	}

	public void setBookcondition(String bookcondition) {
		this.bookcondition = bookcondition;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//getter setter 함수들
	//getter는 return타입 존재, setter는 void 처리가 기본적인 세팅
	
	
}
