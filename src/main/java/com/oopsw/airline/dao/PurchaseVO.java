package com.oopsw.airline.dao;

public class PurchaseVO {
	private String purchaseNum;
	private String category;
	private int numAdult;
	private int numChild;
	private int numInfant;
	private int totalPrice;
	private String purchaseDate;
	private String paymentStatus;
	private String paymentInfo;
	private String id;
	
	
	public PurchaseVO() {
	}
	public PurchaseVO(String purchaseNum, String category, int numAdult, int numChild, int numInfant, int totalPrice,
			String purchaseDate, String paymentStatus, String paymentInfo, String id) {
		this.purchaseNum = purchaseNum;
		this.category = category;
		this.numAdult = numAdult;
		this.numChild = numChild;
		this.numInfant = numInfant;
		this.totalPrice = totalPrice;
		this.purchaseDate = purchaseDate;
		this.paymentStatus = paymentStatus;
		this.paymentInfo = paymentInfo;
		this.id = id;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNumAdult() {
		return numAdult;
	}
	public void setNumAdult(int numAdult) {
		this.numAdult = numAdult;
	}
	public int getNumChild() {
		return numChild;
	}
	public void setNumChild(int numChild) {
		this.numChild = numChild;
	}
	public int getNumInfant() {
		return numInfant;
	}
	public void setNumInfant(int numInfant) {
		this.numInfant = numInfant;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numAdult;
		result = prime * result + numChild;
		result = prime * result + numInfant;
		result = prime * result + ((paymentInfo == null) ? 0 : paymentInfo.hashCode());
		result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((purchaseNum == null) ? 0 : purchaseNum.hashCode());
		result = prime * result + totalPrice;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseVO other = (PurchaseVO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numAdult != other.numAdult)
			return false;
		if (numChild != other.numChild)
			return false;
		if (numInfant != other.numInfant)
			return false;
		if (paymentInfo == null) {
			if (other.paymentInfo != null)
				return false;
		} else if (!paymentInfo.equals(other.paymentInfo))
			return false;
		if (paymentStatus == null) {
			if (other.paymentStatus != null)
				return false;
		} else if (!paymentStatus.equals(other.paymentStatus))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchaseNum == null) {
			if (other.purchaseNum != null)
				return false;
		} else if (!purchaseNum.equals(other.purchaseNum))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PurchaseVO [purchaseNum=" + purchaseNum + ", category=" + category + ", numAdult=" + numAdult
				+ ", numChild=" + numChild + ", numInfant=" + numInfant + ", totalPrice=" + totalPrice
				+ ", purchaseDate=" + purchaseDate + ", paymentStatus=" + paymentStatus + ", paymentInfo=" + paymentInfo
				+ ", id=" + id + "]";
	}
	
	
}