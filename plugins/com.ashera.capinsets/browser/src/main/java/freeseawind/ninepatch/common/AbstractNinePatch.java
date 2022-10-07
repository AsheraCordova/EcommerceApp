package freeseawind.ninepatch.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import freeseawind.ninepatch.common.Row.Type;

/**
 * @author freeseawind@github
 *
 */
public abstract class AbstractNinePatch<T, E>
{
    /**
     * Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã¯Â¼Å’Ã¥Æ’ï¿½Ã§Â´Â Ã¥â‚¬Â¼Ã¥Â¿â€¦Ã©Â¡Â»Ã¤Â¸ÂºÃ©Â»â€˜Ã¨â€°Â² 0xFF000000
     */
    public static final int PATCH_PIXES = 0xFF000000;
    private int lastWidth;
    private int lastHeight;
    private int patchWidth;
    private int patchHeight;
    private int horizontalPatchNum;
    private int verticalPatchNum;
    private List<List<Row>> columns;
    private Padding padding;
    private T image;
    private RepeatType repeatType;
    private int imageTrim = 1; 

    public AbstractNinePatch(T image)
    {
        this(image, null);
    }
    
    public AbstractNinePatch(T image, RepeatType repeatType)
    {
        image = toCompatibleImage(image);
        
        countPatch(image);
        
        this.image = image;
        
        this.repeatType = repeatType;
    }
    
    public AbstractNinePatch(T image, RepeatType repeatType, CapInsets capInsets)
    {
    	imageTrim = 0;
        image = toCompatibleImage(image);
        
        
        int width = getImageWidth(image);

        // Ã¥â€ºÂ¾Ã§â€°â€¡Ã¥Â®Å¾Ã©â„¢â€¦Ã©Â«ËœÃ¥ÂºÂ¦, Ã¤Â¸ï¿½Ã¥Å’â€¦Ã¥ï¿½Â«Ã¤Â¸Å Ã¤Â¸â€¹Ã¦Å½Â§Ã¥Ë†Â¶Ã¥Å’ÂºÃ¥Å¸Å¸
        int height = getImageHeight(image);

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â·Â¦Ã¤Â¾Â§Ã¥Å¾â€šÃ§â€ºÂ´Ã¥Ë†â€�?
        NinePatchRegion left = new NinePatchRegion(Arrays.asList(new Region(0, capInsets.getStretchTop()), new Region(height - capInsets.getStretchBottom(), height)),
        		Arrays.asList(new Region(capInsets.getStretchTop(), height - capInsets.getStretchBottom())));

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã©Â¡Â¶Ã©Æ’Â¨Ã¦Â°Â´Ã¥Â¹Â³Ã¨Â¡Å’
        NinePatchRegion top = new NinePatchRegion( 
        		Arrays.asList(new Region(0, capInsets.getStretchLeft()), new Region(width - capInsets.getStretchRight(), width)),
        		Arrays.asList(new Region(capInsets.getStretchLeft(), width - capInsets.getStretchRight())));

        // Ã¦Â°Â´Ã¥Â¹Â³Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã§Â´Â Ã¦â€¢Â°Ã©â€¡ï¿½
        this.horizontalPatchNum = top.getPatchRegions().size();

        // Ã¥Å¾â€šÃ§â€ºÂ´Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã¦â€¢Â°Ã©â€¡ï¿½
        this.verticalPatchNum = left.getPatchRegions().size();

        this.columns = countColumn(top, left);

        NinePatchRegion bottom =  new NinePatchRegion(Arrays.asList(new Region(0, 0)), Arrays.asList(new Region(0, 0)));

        NinePatchRegion right =  new NinePatchRegion(Arrays.asList(new Region(0, 0)), Arrays.asList(new Region(0, 0)));

        this.padding = getPadding(width, height, bottom.getPatchRegions(), right.getPatchRegions());

        
        
        this.image = image;
        
        this.repeatType = repeatType;
    }
    

    /**
     *
     * @param g2d
     * @param x
     * @param y
     * @param scaledWidth
     * @param scaledHeight
     */
	public void drawNinePatch(E g2d, int x, int y, int scaledWidth, int scaledHeight)
	{
		// Ã¤Â¿Â®Ã¥Â¤ï¿½BUGÃ©ËœÂ²Ã¦Â­Â¢Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Â¤Â§Ã¥Â°ï¿½Ã¥Â°ï¿½Ã¤ÂºÅ½Ã§Â­â€°Ã¤ÂºÅ½Ã¥Å½Å¸Ã¥â€ºÂ¾Ã¥Â¤Â§Ã¥Â°ï¿½
        if (scaledWidth <= 1 || scaledHeight <= 1)
        {
            return;
        }

        try
        {
            if(lastWidth != scaledWidth || lastHeight != scaledHeight)
            {
                lastWidth = scaledWidth;

                lastHeight = scaledHeight;

                resetData(scaledWidth, scaledHeight);
            }

            if(patchWidth == scaledWidth && patchHeight == scaledHeight)
            {
                drawImage(g2d, image, x, y, scaledWidth, scaledHeight);

                return;
            }

            translate(g2d, x, y);

            int startX = 0;
            int startY = 0;
            int minWidth = patchWidth;
            int minHeight = patchHeight;

            if(horizontalPatchNum > 1)
            {
                minWidth = (patchWidth / horizontalPatchNum);
            }

            if(verticalPatchNum > 1)
            {
                minHeight = (patchHeight / verticalPatchNum);
            }

            int columnCount = 0;

            // Ã©â‚¬ï¿½Ã¨Â¡Å’Ã§Â»ËœÃ¥Ë†Â¶
            for(List<Row> rows : columns)
            {
                int rowCount = 0;

                int height = patchHeight;

                boolean isFirst = true;

                int preRowHeight = 0;
                
                // Ã©ËœÂ²Ã¦Â­Â¢Ã¥â€ºÂ¾Ã§â€°â€¡Ã¦â€¹â€°Ã¤Â¼Â¸Ã©Â«ËœÃ¥ÂºÂ¦Ã¥Â¤Â§Ã¤ÂºÅ½Ã¥Â®Å¾Ã©â„¢â€¦Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¦â€¹â€°Ã¤Â¼Â¸Ã©Â«ËœÃ¥ÂºÂ¦
                if(startY >= scaledHeight)
                {
                    break;
                }

                for(Row row : rows)
                {
                    Rectangle rect = row.getRectangle();

                    int width = rect.width;
                    
                    // Ã©ËœÂ²Ã¦Â­Â¢Ã¥â€ºÂ¾Ã§â€°â€¡Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Â®Â½Ã¥ÂºÂ¦Ã¥Â¤Â§Ã¤ÂºÅ½Ã¥Â®Å¾Ã©â„¢â€¦Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Â®Â½Ã¥ÂºÂ¦
                    if(startX >= scaledWidth)
                    {
                        break;
                    }

                    if(Type.HORIZONTALPATCH == row.getType() || Type.TILEPATCH == row.getType())
                    {
                        // Ã¨Â®Â¡Ã§Â®â€�?Ã¦â€¹â€°Ã¤Â¼Â¸Ã§Å¡â€žÃ¥Â®Â½Ã¥ÂºÂ¦
                        width = (patchWidth - minWidth * (rowCount + 1));

                        if(width < minWidth)
                        {
                            width = patchWidth - (minWidth * rowCount);
                        }
                        else
                        {
                            width = minWidth;
                        }

                        rowCount++;
                    }
                    else if(Type.HORIZONTALPATCH == row.getType())
                    {
                        // Ã¨Â®Â¡Ã§Â®â€�?Ã¦â€¹â€°Ã¤Â¼Â¸Ã§Å¡â€žÃ©Â«ËœÃ¥ÂºÂ¦
                        if(isFirst)
                        {
                            height = (patchHeight - minHeight * (columnCount + 1));

                            if(height < minHeight)
                            {
                                height = patchHeight - (minHeight * columnCount);
                            }
                            else
                            {
                                height = minHeight;
                            }

                            columnCount++;

                            isFirst = false;
                        }
                    }

                    // Ã§Â»ËœÃ¥Ë†Â¶Ã¥â€ºÂºÃ¥Â®Å¡Ã¥Å’ÂºÃ¥Å¸Å¸
                    if(Type.FIX == row.getType())
                    {
                        drawImage(g2d, image, rect.x, rect.y, rect.width, rect.height, startX, startY, rect.width, rect.height);

                        startX += rect.width;

                        preRowHeight = rect.height;
                    }
                    else if(Type.HORIZONTALPATCH == row.getType())
                    {
                        // Ã§Â»ËœÃ¥Ë†Â¶Ã¦Â°Â´Ã¥Â¹Â³Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸
                        drawImage(g2d, image, rect.x, rect.y, rect.width, rect.height, startX, startY, width, rect.height);

                        startX += width;

                        preRowHeight = rect.height;
                    }
                    else if(Type.VERTICALPATCH == row.getType())
                    {
                        // Ã¥Å¾â€šÃ§â€ºÂ´Ã¦â€¹â€°Ã¤Â¼Â¸
                        drawImage(g2d, image, rect.x, rect.y, rect.width, rect.height, startX, startY, rect.width, height);

                        startX += rect.width;

                        preRowHeight = height;
                    }
                    else if(Type.TILEPATCH == row.getType())
                    {
                        // Ã¥Â¹Â³Ã©â€œÂº
                        if(repeatType != null)
                        {
                            repeatImage(g2d, image, rect.x, rect.y, rect.width, rect.height, startX, startY, width, height);
                        }
                        else
                        {
                            drawImage(g2d, image, rect.x, rect.y, rect.width, rect.height, startX, startY, width, height);
                        }

                        startX += width;

                        preRowHeight = height;
                    }
                }

                startX = 0;
                startY += preRowHeight;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            translate(g2d, -x, -y);
        }
    }

    public List<List<Row>> countColumn(NinePatchRegion xRegions, NinePatchRegion yRegions)
    {
        boolean isPatchY = false; // Ã¥Â½â€œÃ¥â€°ï¿½Ã¦ËœÂ¯Ã¥ï¿½Â¦Ã¥Â¤â€žÃ¤ÂºÅ½Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸
        int i = 0; // Ã¥â€ºÂºÃ¥Â®Å¡Ã¥Å’ÂºÃ¥Å¸Å¸Ã¨ÂµÂ·Ã¥Â§â€¹Ã§Â´Â¢Ã¥Â¼â€¢
        int j = 0;// Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã¨ÂµÂ·Ã¥Â§â€¹Ã§Â´Â¢Ã¥Â¼â€¢
        int patchNum = yRegions.getPatchRegions().size();
        int fixNum = yRegions.getFixRegions().size();

        Region yRegion = null; // Ã¥Â¾ÂªÃ§Å½Â¯Ã¥â€¡ÂºÃ¥ï¿½Â£Ã¦ï¿½Â¡Ã¤Â»Â¶

        List<List<Row>> columns = new LinkedList<List<Row>>();// Ã¤Â¹ï¿½Ã¥Â®Â«Ã¦Â Â¼Ã¨Â¡Å’Ã©â€ºâ€ Ã¥ï¿½Ë†

        do
        {
            yRegion = null;

            if (isPatchY && patchNum >= j + 1)
            {
                yRegion = yRegions.getPatchRegions().get(j++);
            }

            if (!isPatchY && fixNum >= i + 1)
            {
                yRegion = yRegions.getFixRegions().get(i++);
            }

            if(yRegion != null)
            {
                columns.add(countRow(yRegion, xRegions, isPatchY));
            }

            isPatchY = !isPatchY;
        }
        while (yRegion != null);

        return columns;
    }

    /**
     * Ã¨Â®Â¡Ã§Â®â€�?Ã§â€šÂ¹Ã¤Â¹ï¿½Ã¥â€ºÂ¾Ã§Å¡â€žÃ¦Â¯ï¿½Ã¤Â¸â‚¬Ã¥Ë†â€�?Ã¥Å’ÂºÃ¥Å¸Å¸
     * @param yRegion
     * @param xRegions
     * @param isPatchY
     * @return Ã¨Â¿â€�Ã¥â€ºÅ¾Ã¥Â½â€œÃ¥â€°ï¿½Ã¨Â¡Å’
     */
    public List<Row> countRow(Region yRegion, NinePatchRegion xRegions, boolean isPatchY)
    {
        boolean isPatchX = false;
        int i = 0;
        int j = 0;
        int patchNum = xRegions.getPatchRegions().size();
        int fixNum = xRegions.getFixRegions().size();

        Region xRegion = null;

        List<Row> column = new LinkedList<Row>();

        do
        {
            xRegion = null;

            if (isPatchX && patchNum >= j + 1)
            {
                xRegion = xRegions.getPatchRegions().get(j++);
            }

            if (!isPatchX && fixNum >= i + 1)
            {
                xRegion = xRegions.getFixRegions().get(i++);
            }

            if(xRegion != null)
            {
                Row.Type rowType = getRowType(isPatchX, isPatchY);

                int height = yRegion.getEnd() - yRegion.getStart();

                int width = xRegion.getEnd() - xRegion.getStart();

                Rectangle rect = new Rectangle(xRegion.getStart() + imageTrim, yRegion.getStart() + imageTrim, width, height);

                Row row = new Row(rect, rowType);

                column.add(row);
            }

            isPatchX = !isPatchX;
        }
        while (xRegion != null);

        Collections.sort(column);

        return column;
    }



    /**
     * Ã¨Å½Â·Ã¥ï¿½â€“Ã¥â€ â€¦Ã¥Â®Â¹Ã¦ËœÂ¾Ã§Â¤ÂºÃ¥Å’ÂºÃ¥Å¸Å¸Ã§Å¡â€žÃ©â€�?Â´Ã¨Â·ï¿½
     * @param w Ã¥â€ â€¦Ã¥Â®Â¹Ã©ï¿½Â¢Ã¦ï¿½Â¿Ã§Å¡â€žÃ¥Â®Â½Ã¥ÂºÂ¦
     * @param h Ã¥â€ â€¦Ã¥Â®Â¹Ã©ï¿½Â¢Ã¦ï¿½Â¿Ã§Å¡â€žÃ©Â«ËœÃ¥ÂºÂ¦
     * @param xRegions xÃ¥ï¿½ï¿½Ã¦Â â€¡Ã©â€ºâ€ Ã¥ï¿½Ë†
     * @param yRegions yÃ¥ï¿½ï¿½Ã¦Â â€¡Ã©â€ºâ€ Ã¥ï¿½Ë†
     * @return
     */
    public Padding getPadding(int w, int h, List<Region> xRegions, List<Region> yRegions)
    {
        Region xRegion = xRegions.get(0);
        Region yRegion = yRegions.get(0);

        int left = xRegion.getStart();
        int top = yRegion.getStart();
        int right = w - xRegion.getEnd();
        int bottom = h - yRegion.getEnd();

        return new Padding(left, top, right, bottom);
    }

    /**
     * Ã¦Â Â¹Ã¦ï¿½Â®Ã¥Æ’ï¿½Ã§Â´Â Ã¥â‚¬Â¼Ã©â€ºâ€ Ã¥ï¿½Ë†Ã¨Â®Â¡Ã§Â®â€�?Ã¥Â½â€œÃ¥â€°ï¿½Ã¥Æ’ï¿½Ã§Â´Â Ã¥Å’ÂºÃ¥Å¸Å¸Ã¤Â¸Â­Ã§Å¡â€žÃ¥â€ºÂºÃ¥Â®Å¡Ã¥Å’ÂºÃ¥Å¸Å¸Ã¥â€™Å’Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸
     * @param pixels Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¦Å¸Â¥Ã¦â€°Â¾Ã§Å¡â€žÃ¥Æ’ï¿½Ã§Â´Â Ã©â€ºâ€ Ã¥ï¿½Ë†
     * @return
     */
    public NinePatchRegion getPatches(int[] pixels)
    {
        int start = 0;

        int lastPixel = pixels[0];

        List<Region> fixArea = new LinkedList<Region>();

        List<Region> patchArea = new LinkedList<Region>();

        for(int i = 1; i <= pixels.length; i++)
        {
            if(i < pixels.length && lastPixel == pixels[i])
            {
                continue;
            }

            // Ã¥Å’ÂºÃ©â€�?Â´Ã¥Â¯Â¹Ã¨Â±Â¡
            Region region = new Region(start, i);

            if (PATCH_PIXES == lastPixel)
            {
                patchArea.add(region);
            }
            else
            {
                fixArea.add(region);
            }

            start = i;

            if(i < pixels.length)
            {
                lastPixel = pixels[i];
            }
        }

        // Ã¥Æ’ï¿½Ã§Â´Â Ã©â€ºâ€ Ã¥ï¿½Ë†Ã¤Â¸Â­Ã¦Â²Â¡Ã¦Å“â€°Ã¦â€°Â¾Ã¥Ë†Â°Ã§â€°Â¹Ã¦Â®Å Ã¥Æ’ï¿½Ã§Â´Â 
        if(start == 0)
        {
            Region region = new Region(start, pixels.length);

            if (PATCH_PIXES == lastPixel)
            {
                patchArea.add(region);
            }
            else
            {
                fixArea.add(region);
            }
        }

        return new NinePatchRegion(fixArea, patchArea);
    }
    
    /**
     * Ã¥Â¹Â³Ã©â€œÂºÃ¥â€ºÂ¾Ã§â€°â€¡
     * @param g2d
     * @param image
     * @param x
     * @param y
     * @param sw
     * @param sh
     * @param dx
     * @param dy
     * @param dw
     * @param dh
     */
    public void repeatImage(E g2d,
                            T image,
                            int x,
                            int y,
                            int sw,
                            int sh,
                            int dx,
                            int dy,
                            int dw,
                            int dh)
    {
        if (repeatType == null)
        {
            return;
        }

        if (repeatType == RepeatType.HORIZONTAL)
        {
            int hornaizeW = dw;

            // 
            do
            {
                if (hornaizeW - sw < 0)
                {
                    sw = hornaizeW;
                }

                hornaizeW -= sw;

                drawImage(g2d, image, x, y, sw, sh, dx, dy, sw, dh);

                dx += sw;

            }
            while (hornaizeW > 0);
        }
        else if (repeatType == RepeatType.VERTICAL)
        {
            int verticalH = dh;

            // Ãƒâ€¹Ã‚Â®Ãƒâ€ Ã‚Â½Ãƒâ‚¬Ã‚Â­Ãƒâ€°ÃƒÂ¬
            do
            {
                if (verticalH - sh < 0)
                {
                    sh = verticalH;
                }

                verticalH -= sh;

                drawImage(g2d, image, x, y, sw, sh, dx, dy, dw, sh);

                dy += sh;

            }
            while (verticalH > 0);
        }
    }
    
    /**
     * Ã¨Â®Â¡Ã§Â®â€�?Ã§â€šÂ¹Ã¤Â¹ï¿½Ã¥â€ºÂ¾Ã§â€°â€¡Ã¤Â¿Â¡Ã¦ï¿½Â¯
     * <p>|1|   2  |3|</p>
     * <p>|4|   5  |6|</p>
     * <p>|7|   8  |9|</p>
     *  Ã¨Â®Â¡Ã§Â®â€�?Ã¥â€ºÂ¾Ã§â€°â€¡Ã¤Â¸Â­Ã¦Â¯ï¿½Ã¤Â¸â‚¬Ã¨Â¡Å’Ã©â€¡Å’Ã§Å¡â€žÃ¥â€ºÂºÃ¥Â®Å¡Ã¥Å’ÂºÃ¥Å¸Å¸Ã£â‚¬ï¿½Ã¥Å¾â€šÃ§â€ºÂ´Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ£â‚¬ï¿½Ã¦Â°Â´Ã¥Â¹Â³Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥â€™Å’Ã¥Â¹Â³Ã©â€œÂºÃ¥Å’ÂºÃ¥Å¸Å¸Ã¤Â»Â¥Ã¥ï¿½Å Ã¥â€ â€¦Ã¥Â®Â¹Ã¦ËœÂ¾Ã§Â¤ÂºÃ©â€�?Â´Ã¨Â·ï¿½
     * @param image
     */
    protected void countPatch(T image)
    {
        // Ã¥â€ºÂ¾Ã§â€°â€¡Ã¥Â®Å¾Ã©â„¢â€¦Ã¥Â®Â½Ã¥ÂºÂ¦, Ã¤Â¸ï¿½Ã¥Å’â€¦Ã¥ï¿½Â«Ã¥Â·Â¦Ã¥ï¿½Â³Ã¦Å½Â§Ã¥Ë†Â¶Ã¥Å’ÂºÃ¥Å¸Å¸
        int width = getImageWidth(image) - 2;

        // Ã¥â€ºÂ¾Ã§â€°â€¡Ã¥Â®Å¾Ã©â„¢â€¦Ã©Â«ËœÃ¥ÂºÂ¦, Ã¤Â¸ï¿½Ã¥Å’â€¦Ã¥ï¿½Â«Ã¤Â¸Å Ã¤Â¸â€¹Ã¦Å½Â§Ã¥Ë†Â¶Ã¥Å’ÂºÃ¥Å¸Å¸
        int height = getImageHeight(image) - 2;

        // Ã¨Â¡Å’
        int[] row = null;

        // Ã¥Ë†â€�?
        int[] column = null;

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â·Â¦Ã¤Â¾Â§Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã§Å¡â€žÃ¥Æ’ï¿½Ã§Â´Â 
        column = getPixels(image, 0, 1, 1, height);

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â·Â¦Ã¤Â¾Â§Ã¥Å¾â€šÃ§â€ºÂ´Ã¥Ë†â€�?
        NinePatchRegion left = getPatches(column);

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã©Â¡Â¶Ã©Æ’Â¨Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã§Å¡â€žÃ¥Æ’ï¿½Ã§Â´Â Ã¥â‚¬Â¼, Ã¤Â¸ï¿½Ã¥Å’â€¦Ã¥ï¿½Â«Ã¥Â·Â¦Ã¥ï¿½Â³Ã¦Å½Â§Ã¥Ë†Â¶Ã¥Å’ÂºÃ¥Å¸Å¸Ã¯Â¼Å’Ã¦â€°â‚¬Ã¤Â»Â¥Ã¥ï¿½â€˜Ã¥ï¿½Â³Ã¥ï¿½ï¿½Ã§Â§Â»Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¥Æ’ï¿½Ã§Â´Â 
        row = getPixels(image, 1, 0, width, 1);

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã©Â¡Â¶Ã©Æ’Â¨Ã¦Â°Â´Ã¥Â¹Â³Ã¨Â¡Å’
        NinePatchRegion top = getPatches(row);

        // Ã¦Â°Â´Ã¥Â¹Â³Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã§Â´Â Ã¦â€¢Â°Ã©â€¡ï¿½
        this.horizontalPatchNum = top.getPatchRegions().size();

        // Ã¥Å¾â€šÃ§â€ºÂ´Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã¦â€¢Â°Ã©â€¡ï¿½
        this.verticalPatchNum = left.getPatchRegions().size();

        this.columns = countColumn(top, left);

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Âºâ€¢Ã©Æ’Â¨Ã¦Â°Â´Ã¥Â¹Â³Ã¥â€ â€¦Ã¥Â®Â¹Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã¥Æ’ï¿½Ã§Â´Â Ã©â€ºâ€ Ã¥ï¿½Ë†
        row = getPixels(image, 1, height + 1, width, 1);

        // Ã¨Å½Â·Ã¥ï¿½â€“Ã¥ï¿½Â³Ã¤Â¾Â§Ã¥Å¾â€šÃ§â€ºÂ´Ã¥â€ â€¦Ã¥Â®Â¹Ã¦â€¹â€°Ã¤Â¼Â¸Ã¥Å’ÂºÃ¥Å¸Å¸Ã¥Æ’ï¿½Ã§Â´Â Ã©â€ºâ€ Ã¥ï¿½Ë†
        column = getPixels(image, width + 1, 1, 1, height);

        NinePatchRegion bottom = getPatches(row);

        NinePatchRegion right = getPatches(column);

        this.padding = getPadding(width, height, bottom.getPatchRegions(), right.getPatchRegions());
    }
    
    protected T toCompatibleImage(T image)
    {
    	return image;
    }

    /**
     * Ã¤Â»Å½Ã¦Å’â€¡Ã¥Â®Å¡Ã§Å¡â€žÃ§Å¸Â©Ã¥Â½Â¢Ã¥Å’ÂºÃ¥Å¸Å¸Ã¤Â¸Â­Ã¨Â¯Â»Ã¥ï¿½â€“Ã¥Æ’ï¿½Ã§Â´Â Ã¦â€¢Â°Ã¦ï¿½Â®
     * @param img
     * @param x Ã¨ÂµÂ·Ã¥Â§â€¹xÃ¥ï¿½ï¿½Ã¦Â â€¡
     * @param y Ã¨ÂµÂ·Ã¥Â§â€¹yÃ¥ï¿½ï¿½Ã¦Â â€¡
     * @param w Ã§Å¸Â©Ã¥Â½Â¢Ã§Å¡â€žÃ¥Â®Â½Ã¥ÂºÂ¦
     * @param h Ã§Å¸Â©Ã¥Â½Â¢Ã§Å¡â€žÃ©Â«ËœÃ¥ÂºÂ¦
     * @return Ã¦Å’â€¡Ã¥Â®Å¡Ã§Å¸Â©Ã¥Â½Â¢Ã¥Å’ÂºÃ¥Å¸Å¸Ã¥Æ’ï¿½Ã§Â´Â Ã¦â€¢Â°Ã¦ï¿½Â®Ã¦â€¢Â´Ã¥Å¾â€¹Ã¦â€¢Â°Ã§Â»â€ž
     */
    public abstract int[] getPixels(T img, int x, int y, int w, int h);

    /**
     * Ã¨Å½Â·Ã¥ï¿½â€“Ã¥â€ºÂ¾Ã§â€°â€¡Ã¥Â®Â½Ã¥ÂºÂ¦
     * @param img
     * @return
     */
    public abstract int getImageWidth(T img);

    /**
     * Ã¨Å½Â·Ã¥ï¿½â€“Ã¥â€ºÂ¾Ã§â€°â€¡Ã©Â«ËœÃ¥ÂºÂ¦
     * @param img
     * @return
     */
    public abstract int getImageHeight(T img);

    /**
     *
     * @param g2d
     * @param x
     * @param y
     */
    public abstract void translate(E g2d, int x, int y);

    /**
     *
     * @param g2d
     * @param image
     * @param x
     * @param y
     * @param scaledWidth
     * @param scaledHeight
     */
    public abstract void drawImage(E g2d,
                                   T image,
                                   int x,
                                   int y,
                                   int scaledWidth,
                                   int scaledHeight);

    /**
     *
     * @param g2d
     * @param image
     * @param sx
     * @param sy
     * @param sw
     * @param sh
     * @param dx
     * @param dy
     * @param dw
     * @param dh
     */
    public abstract void drawImage(E g2d,
                                   T image,
                                   int sx,
                                   int sy,
                                   int sw,
                                   int sh,
                                   int dx,
                                   int dy,
                                   int dw,
                                   int dh);

    /**
     *
     * @param scaleWidth
     * @param scaleHeight
     */
    private void resetData(int scaleWidth, int scaleHeight)
    {
        this.patchWidth = scaleWidth;
        this.patchHeight = scaleHeight;
        boolean isFirst = true;
        boolean isNewColumn = true;

        for(List<Row> rows : columns)
        {
            for(Row row : rows)
            {
                if(Type.FIX == row.getType() && isFirst)
                {
                    patchWidth -= row.getRectangle().width;
                }

                //BUG FIX: Ã¤Â¿Â®Ã¥Â¤ï¿½Ã¦ËœÂ¾Ã§Â¤ÂºÃ¥Å’ÂºÃ¥Å¸Å¸Ã¨Â®Â¡Ã§Â®â€�?Ã©â€�?Â®Ã©Â¢Ëœ
                if(Type.FIX == row.getType() && isNewColumn)
                {
                    patchHeight -= row.getRectangle().height;

                    isNewColumn = false;
                }
            }

            isNewColumn = true;

            isFirst = false;
        }
    }

    private Type getRowType(boolean isPatchX, boolean isPatchY)
    {
        if (!isPatchX && !isPatchY)
        {
            return Type.FIX;
        }

        if (!isPatchX && isPatchY)
        {
            return Type.VERTICALPATCH;
        }

        if (isPatchX && !isPatchY)
        {
            return Type.HORIZONTALPATCH;
        }

        return Type.TILEPATCH;
    }

    public Padding getPadding()
    {
        return padding;
    }
}
