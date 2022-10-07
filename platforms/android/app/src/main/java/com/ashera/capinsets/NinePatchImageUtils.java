package com.ashera.capinsets;

public class NinePatchImageUtils {
    public static final int NO_COLOR = 0x00000001;
    public static final int TRANSPARENT_COLOR = 0x00000000;


    private static java.util.ArrayList<NinePatchImageUtils.Div> getRegions(java.util.ArrayList<NinePatchImageUtils.Div> divs, int max) {
        java.util.ArrayList<NinePatchImageUtils.Div> out = new java.util.ArrayList<NinePatchImageUtils.Div>();
        if (divs == null || divs.size() == 0) {
            return out;
        }
        for (int i = 0; i < divs.size(); i++) {
            NinePatchImageUtils.Div div = divs.get(i);
            if (i == 0 && div.start != 0) {
                out.add(new NinePatchImageUtils.Div(0, div.start - 1));
            }
            if (i > 0) {
                out.add(new NinePatchImageUtils.Div(divs.get(i - 1).stop, div.start - 1));
            }
            out.add(new NinePatchImageUtils.Div(div.start, div.stop - 1));
            if (i == divs.size() - 1 && div.stop < max) {
                out.add(new NinePatchImageUtils.Div(div.stop, max - 1));
            }
        }
        return out;
    }

    private static void setupColors(android.graphics.Bitmap bitmap, NinePatchImageUtils.NinePatchHolder out) {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        java.util.ArrayList<NinePatchImageUtils.Div> xRegions = getRegions(out.xDivs, bitmapWidth);
        java.util.ArrayList<NinePatchImageUtils.Div> yRegions = getRegions(out.yDivs, bitmapHeight);
        out.colors = new int[xRegions.size() * yRegions.size()];

        int colorIndex = 0;
        for (NinePatchImageUtils.Div yDiv : yRegions) {
            for (NinePatchImageUtils.Div xDiv : xRegions) {
                int startX = xDiv.start;
                int startY = yDiv.start;
                if (hasSameColor(bitmap, startX, xDiv.stop, startY, yDiv.stop)) {
                    int pixel = bitmap.getPixel(startX, startY);
                    if (isTransparent(pixel)) {
                        pixel = TRANSPARENT_COLOR;
                    }
                    out.colors[colorIndex] = pixel;
                } else {
                    out.colors[colorIndex] = NO_COLOR;
                }
                colorIndex++;
            }
        }
    }

    private static boolean isTransparent(int color) {
        return android.graphics.Color.alpha(color) == android.graphics.Color.TRANSPARENT;
    }

    private static boolean hasSameColor(android.graphics.Bitmap bitmap, int startX, int stopX, int startY, int stopY) {
        int color = bitmap.getPixel(startX, startY);
        for (int x = startX; x <= stopX; x++) {
            for (int y = startY; y <= stopY; y++) {
                if (color != bitmap.getPixel(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte[] toBytes(NinePatchImageUtils.NinePatchHolder chunk) {
        int xsize = chunk.xDivs.size();
        int ysize = chunk.yDivs.size();
        int clength = chunk.colors.length;
        int capacity = 4 + (7 * 4) + xsize * 2 * 4 + ysize * 2 * 4 + clength * 4;
        java.nio.ByteBuffer byteBuffer = java.nio.ByteBuffer.allocate(capacity).order(java.nio.ByteOrder.nativeOrder());
        byteBuffer.put(Integer.valueOf(1).byteValue());
        byteBuffer.put(Integer.valueOf(xsize * 2).byteValue());
        byteBuffer.put(Integer.valueOf(ysize * 2).byteValue());
        byteBuffer.put(Integer.valueOf(clength).byteValue());
        // Skip
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);

        if (chunk.padding == null) {
            chunk.padding = new android.graphics.Rect();
        }
        byteBuffer.putInt(chunk.padding.left);
        byteBuffer.putInt(chunk.padding.right);
        byteBuffer.putInt(chunk.padding.top);
        byteBuffer.putInt(chunk.padding.bottom);

        // Skip
        byteBuffer.putInt(0);

        for (NinePatchImageUtils.Div div : chunk.xDivs) {
            byteBuffer.putInt(div.start);
            byteBuffer.putInt(div.stop);
        }
        for (NinePatchImageUtils.Div div : chunk.yDivs) {
            byteBuffer.putInt(div.start);
            byteBuffer.putInt(div.stop);
        }

        for (int color : chunk.colors) {
            byteBuffer.putInt(color);
        }

        return byteBuffer.array();

    }

    public static NinePatchImageUtils.NinePatchHolder createChunkFromRawBitmap(android.graphics.Bitmap bm, NinePatchImageUtils.CapInsets capInsets) {
        NinePatchImageUtils.NinePatchHolder out = new NinePatchImageUtils.NinePatchHolder();
        int maxXPixels = bm.getWidth();
        int maxYPixels = bm.getHeight();
        out.colors = new int[0];
        out.padding = new android.graphics.Rect();
        out.padding.left = capInsets.getPadLeft();
        out.padding.right = capInsets.getPadRight();
        out.padding.top = capInsets.getPadTop();
        out.padding.bottom = capInsets.getPadBottom();
        java.util.ArrayList<NinePatchImageUtils.Div> xDivList = new java.util.ArrayList<NinePatchImageUtils.Div>();
        NinePatchImageUtils.Div xdiv = new NinePatchImageUtils.Div();
        xdiv.start = capInsets.getStretchLeft();
        xdiv.stop = maxXPixels - capInsets.getStretchRight();
        xDivList.add(xdiv);
        out.xDivs = xDivList;
        java.util.ArrayList<NinePatchImageUtils.Div> yDivList = new java.util.ArrayList<NinePatchImageUtils.Div>();
        NinePatchImageUtils.Div ydiv = new NinePatchImageUtils.Div();
        ydiv.start = capInsets.getStretchTop();
        ydiv.stop = maxYPixels - capInsets.getStretchBottom();
        yDivList.add(ydiv);
        out.yDivs = yDivList;
        setupColors(bm, out);
        return out;
    }

    public static android.graphics.Bitmap modifyBitmap(android.content.res.Resources resources, android.graphics.Bitmap bitmap, NinePatchImageUtils.NinePatchHolder chunk) {
        int targetDensity = resources.getDisplayMetrics().densityDpi;
        float densityChange = (float) targetDensity / bitmap.getDensity();
        if (densityChange != 1f) {
            int dstWidth = Math.round(bitmap.getWidth() * densityChange);
            int dstHeight = Math.round(bitmap.getHeight() * densityChange);
            bitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, dstWidth, dstHeight, true);
            bitmap.setDensity(targetDensity);
            chunk.padding = new android.graphics.Rect(Math.round(chunk.padding.left * densityChange), Math.round(chunk.padding.top
                    * densityChange), Math.round(chunk.padding.right * densityChange),
                    Math.round(chunk.padding.bottom * densityChange));

            recalculateDivs(densityChange, chunk.xDivs);
            recalculateDivs(densityChange, chunk.yDivs);
        }

        return bitmap;
    }


    private static void recalculateDivs(float densityChange, java.util.ArrayList<NinePatchImageUtils.Div> divs) {
        for (NinePatchImageUtils.Div div : divs) {
            div.start = Math.round(div.start * densityChange);
            div.stop = Math.round(div.stop * densityChange);
        }
    }


    public static android.graphics.drawable.Drawable createDrawable(android.graphics.Bitmap bitMap, String resourceName,
                                                                    NinePatchImageUtils.CapInsets capInsets, android.content.Context context) {
        NinePatchImageUtils.NinePatchHolder chunk = createChunkFromRawBitmap(bitMap, capInsets);
        android.graphics.Bitmap bm = modifyBitmap(context.getResources(), bitMap, chunk);

        byte[] bytes = NinePatchImageUtils.toBytes(chunk);
        return new android.graphics.drawable.NinePatchDrawable(context.getResources(), bm, bytes, chunk.padding, resourceName);
    }


    static class NinePatchHolder {
        public java.util.ArrayList<NinePatchImageUtils.Div> xDivs;
        public java.util.ArrayList<NinePatchImageUtils.Div> yDivs;
        public android.graphics.Rect padding = new android.graphics.Rect();
        public int colors[];
    }
    
    static class Div implements java.io.Externalizable {
        public int start;
        public int stop;
        public Div() {
        }


        public Div(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }


        @Override
        public void readExternal(java.io.ObjectInput input) throws java.io.IOException, ClassNotFoundException {
            start = input.readByte();
            stop = input.readByte();
        }


        @Override
        public void writeExternal(java.io.ObjectOutput output) throws java.io.IOException {
            output.writeByte(start);
            output.writeByte(stop);
        }
    }
    
    public static class CapInsets {
        private int padLeft;
		private int padRight;
        private int padTop;
        private int padBottom;
        private int stretchLeft;
        private int stretchRight;
        private int stretchTop;
        private int stretchBottom;

        public int getPadLeft() {
			return padLeft;
		}


		public void setPadLeft(int padLeft) {
			this.padLeft = padLeft;
		}


		public int getPadRight() {
			return padRight;
		}


		public void setPadRight(int padRight) {
			this.padRight = padRight;
		}


		public int getPadTop() {
			return padTop;
		}


		public void setPadTop(int padTop) {
			this.padTop = padTop;
		}


		public int getPadBottom() {
			return padBottom;
		}


		public void setPadBottom(int padBottom) {
			this.padBottom = padBottom;
		}




        public int getStretchLeft() {
            return stretchLeft;
        }


        public void setStretchLeft(int stretchLeft) {
            this.stretchLeft = stretchLeft;
        }


        public int getStretchRight() {
            return stretchRight;
        }


        public void setStretchRight(int stretchRight) {
            this.stretchRight = stretchRight;
        }


        public int getStretchTop() {
            return stretchTop;
        }


        public void setStretchTop(int stretchTop) {
            this.stretchTop = stretchTop;
        }


        public int getStretchBottom() {
            return stretchBottom;
        }


        public void setStretchBottom(int stretchBottom) {
            this.stretchBottom = stretchBottom;
        }
    }

}
