package freeseawind.ninepatch.web;

import org.teavm.jso.dom.html.HTMLImageElement;

public class ImageHolder {
	private int imageWidth;
	private int imageHeight;
	private org.teavm.jso.dom.html.HTMLImageElement image;

	public ImageHolder(int imageWidth, int imageHeight, HTMLImageElement image) {
		super();
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.image = image;
	}
	public org.teavm.jso.dom.html.HTMLImageElement getImage() {
		return image;
	}
	public void setImage(org.teavm.jso.dom.html.HTMLImageElement image) {
		this.image = image;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
}
