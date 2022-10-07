package freeseawind.ninepatch.web;

import org.teavm.jso.JSObject;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLImageElement;

import freeseawind.ninepatch.common.CapInsets;

public class WebNinePatch extends freeseawind.ninepatch.common.AbstractNinePatch<ImageHolder, org.teavm.jso.dom.html.HTMLCanvasElement>{

	public WebNinePatch(ImageHolder image, CapInsets capInsets) {
		super(image, null, capInsets);
	}

	@Override
	public int[] getPixels(ImageHolder img, int x, int y, int w, int h) {
		return new int[] {};
	}

	@Override
	public int getImageWidth(ImageHolder img) {
		return img.getImageWidth();
	}

	@Override
	public int getImageHeight(ImageHolder img) {
		return img.getImageHeight();
	}

	@org.teavm.jso.JSBody(params = {"ctx", "x", "y"}, script = "ctx.translate(x, y);")
    private static native void translate(JSObject ctx, int x, int y);
	@Override
	public void translate(HTMLCanvasElement g2d, int x, int y) {
		JSObject ctx = g2d.getContext("2d");
		translate(ctx, x, y);
	}

	@Override
	public void drawImage(HTMLCanvasElement g2d, ImageHolder image, int x, int y, int scaledWidth, int scaledHeight) {
		 JSObject ctx = g2d.getContext("2d");
		 drawImage(ctx, image.getImage(), x, y, image.getImageWidth(), image.getImageHeight(), scaledWidth * x/image.getImageWidth(), 
	                scaledHeight * y/image.getImageHeight(), scaledWidth, scaledHeight);
	}

	@org.teavm.jso.JSBody(params = {"ctx", "image", "sx", "sy", "sWidth", "sHeight", "dx", "dy", "dWidth", "dHeight"}, script = "ctx.drawImage(image, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight);")
	private static native void drawImage(JSObject ctx, HTMLImageElement image, int sx, int sy, int sWidth, int sHeight, int dx, int dy,
			int dWidth, int dHeight);

	@Override
	public void drawImage(HTMLCanvasElement g2d, ImageHolder image, int sx, int sy, int sw, int sh, int dx, int dy,
			int dw, int dh) {
		System.out.println("ctx.drawImage(img, " + sx + "," + sy + "," + sw + "," + sh + "," + dx + "," + dy + "," + dw + "," + dh + ");");
		JSObject ctx = g2d.getContext("2d");
		drawImage(ctx, image.getImage(), sx, sy, sw, sh, dx, dy, dw, dh);
	}

}
