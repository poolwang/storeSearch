package cn.wl.pojo;

public class Product {

		private String pid;
		private String name;
		private String catalogName;
		private double price;
		private String description;
		private String picture;
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCatalogName() {
			return catalogName;
		}
		public void setCatalogName(String catalogName) {
			this.catalogName = catalogName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Product(String pid, String name, String catalogName, double price, String description, String picture) {
			super();
			this.pid = pid;
			this.name = name;
			this.catalogName = catalogName;
			this.price = price;
			this.description = description;
			this.picture = picture;
		}
		@Override
		public String toString() {
			return "Product [pid=" + pid + ", name=" + name + ", catalogName=" + catalogName + ", price=" + price
					+ ", description=" + description + ", picture=" + picture + "]";
		}
		
}
