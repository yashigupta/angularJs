package com.citib.arbitrage.model;

import java.io.Serializable;

public class CurrentStock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stockName;

	private String recommendation;

	private double bsePrice;

	private double nsePrice;

	private double profit;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public double getBsePrice() {
		return bsePrice;
	}

	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}

	public double getNsePrice() {
		return nsePrice;
	}

	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "CurrentStock [stockName=" + stockName + ", recommendation=" + recommendation + ", bsePrice=" + bsePrice
				+ ", nsePrice=" + nsePrice + ", profit=" + profit + "]";
	}

}
