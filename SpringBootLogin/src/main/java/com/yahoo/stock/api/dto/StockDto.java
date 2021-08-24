package com.yahoo.stock.api.dto;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
	private String name;
	private BigDecimal price;
	private BigDecimal change;
	private String currency;
	private BigDecimal bid;

	
	public StockDto(String name, BigDecimal price, BigDecimal change, String currency, BigDecimal bid) {
		
		this.name = name;
		this.price = price;
		this.change = change;
		this.currency = currency;
		this.bid = bid;
	}


	@Override
	public String toString() {
		return "StockDto [name=" + name + ", price=" + price + ", change=" + change + ", currency=" + currency
				+ ", bid=" + bid + "]";
	}
	

}
