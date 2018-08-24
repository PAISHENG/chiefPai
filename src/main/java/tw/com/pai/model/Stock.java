package tw.com.pai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "pai", uniqueConstraints = { @UniqueConstraint(columnNames = "stock_name"),
		@UniqueConstraint(columnNames = "stock_code") })
public class Stock implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2251059705832112084L;
	
	private Integer   stockId;
	private String    stockCode;
	private String    stockName;
	
	private static final String STOCK_ID = "stock_id";
	private static final String STOCK_NAME = "stock_name";
	private static final String STOCK_CODE = "stock_name";
	
	
	public Stock() {
	}


	public Stock(String stockCode, String stockName) {
		super();
		this.stockCode = stockCode;
		this.stockName = stockName;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "stock_id", unique = true, nullable = false)
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	
	@Column(name = "stock_code", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	@Column(name = "stock_name", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
}
