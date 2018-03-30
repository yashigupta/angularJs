package com.citib.arbitrage.model;

import java.io.Serializable;

public class SavedStock implements Serializable{

	private static final long serialVersionUID = 1L;

	private String stockName;

	private String date;

	private String time;

	private String userId;

	private double nsePrice;

	private double bsePrice;

	private double profit;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getNsePrice() {
		return nsePrice;
	}

	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}

	public double getBsePrice() {
		return bsePrice;
	}

	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SavedStock [stockName=" + stockName + ", date=" + date + ", time=" + time + ", userId=" + userId
				+ ", nsePrice=" + nsePrice + ", bsePrice=" + bsePrice + ", profit=" + profit + "]";
	}

}
