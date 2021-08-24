package com.yahoo.stock.api;

import java.io.IOException;

import com.yahoo.stock.api.dto.StockDto;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockService {
	
	
	public StockDto getStock(String stockName) throws IOException {
		StockDto dto = null;
		Stock stock = YahooFinance.get(stockName);
		dto = new StockDto(stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChange(),
				stock.getCurrency(), stock.getQuote().getBid());
		return dto;
	}
	

	public static void main(String[] args) throws IOException{
		
		StockService yahooStockAPI = new StockService();
		System.out.println(yahooStockAPI.getStock("GOOG"));

	}
	

}
