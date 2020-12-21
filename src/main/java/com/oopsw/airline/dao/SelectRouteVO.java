package com.oopsw.airline.dao;

public class SelectRouteVO {
	private int routeInfoNum;
	private String routeCode;
	private String purchaseNum;
	
	public SelectRouteVO() {
	}
	public SelectRouteVO(int routeInfoNum, String routeCode, String purchaseNum) {
		this.routeInfoNum = routeInfoNum;
		this.routeCode = routeCode;
		this.purchaseNum = purchaseNum;
	}
	public int getRouteInfoNum() {
		return routeInfoNum;
	}
	public void setRouteInfoNum(int routeInfoNum) {
		this.routeInfoNum = routeInfoNum;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purchaseNum == null) ? 0 : purchaseNum.hashCode());
		result = prime * result + ((routeCode == null) ? 0 : routeCode.hashCode());
		result = prime * result + routeInfoNum;
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
		SelectRouteVO other = (SelectRouteVO) obj;
		if (purchaseNum == null) {
			if (other.purchaseNum != null)
				return false;
		} else if (!purchaseNum.equals(other.purchaseNum))
			return false;
		if (routeCode == null) {
			if (other.routeCode != null)
				return false;
		} else if (!routeCode.equals(other.routeCode))
			return false;
		if (routeInfoNum != other.routeInfoNum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SelectRouteVO [routeInfoNum=" + routeInfoNum + ", routeCode=" + routeCode + ", purchaseNum="
				+ purchaseNum + "]";
	}
	
	
}
