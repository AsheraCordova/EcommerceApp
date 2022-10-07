package freeseawind.ninepatch.common;



/**
 * ä¹�å®«æ ¼çš„æ¯�ä¸€åˆ—
 * @author freeseawind@github
 *
 */
public class Row implements Comparable<Row>
{
    private Rectangle rect;
    private Type type;

    public Row(Rectangle rect, Type type)
    {
        super();
        this.rect = rect;
        this.type = type;
    }

    public Rectangle getRectangle()
    {
        return rect;
    }

    public Type getType()
    {
        return type;
    }

    public int compareTo(Row o)
    {
        return Integer.compare(getRectangle().x, o.getRectangle().x);
    }

    @Override
    public String toString()
    {
        return "Row [row=" + rect + ", type=" + type + "]";
    }

    static enum Type
    {
        FIX, // å›ºå®šç±»åž‹
        HORIZONTALPATCH, // æ°´å¹³æ‹‰ä¼¸ç±»åž‹
        VERTICALPATCH, // åž‚ç›´æ‹‰ä¼¸ç±»åž‹
        TILEPATCH // å¹³é“ºç±»åž‹
    }


}
