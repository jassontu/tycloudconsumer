package ty.cloud.mq.consumer.service.dao.wl.entity;

import java.io.Serializable;
import java.util.Date;

public class Station  implements Serializable{
	
	
	private static final long serialVersionUID = -1222905711648329938L;
	private String stationID;
	private String stationCode;
	private String stationName;
	private String stationKey;
	private String domain;
	private String endDate;
	private String shopUrl;
	private String province;
	private String city;
	private String lat;
	private String lon;
	private String useDeliverySystem;
	private String info;
	private String address;
	private String linkPhone;
	private String linkMan;
	private String photo;
	
	public String getStationID() {
		return stationID;
	}
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationKey() {
		return stationKey;
	}
	public void setStationKey(String stationKey) {
		this.stationKey = stationKey;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getUseDeliverySystem() {
		return useDeliverySystem;
	}
	public void setUseDeliverySystem(String useDeliverySystem) {
		this.useDeliverySystem = useDeliverySystem;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}