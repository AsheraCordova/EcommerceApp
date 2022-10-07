<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:android="http://schemas.android.com/apk/res/android">
    <xsl:template match="/">
        <xsl:for-each select="font-family/font">
            @font-face {
  				font-family: '<xsl:value-of select="@name" />';
  				font-style: <xsl:value-of select="@android:fontStyle" />;
  				font-weight: <xsl:value-of select="@android:fontWeight" />;
  				src: url(/res/font/<xsl:value-of select="@filename" />)
			}
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>