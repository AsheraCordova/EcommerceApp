<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:android="http://schemas.android.com/apk/res/android">
    <xsl:template match="/">
        <xsl:for-each select="font-family/font">
            <xsl:value-of select="@android:fontStyle" />_<xsl:value-of select="@android:fontWeight" />=<xsl:value-of select="@name" /><xsl:text>&#xa;</xsl:text>
            <xsl:if test="@name-ios != ''">
            	<xsl:value-of select="@android:fontStyle" />_<xsl:value-of select="@android:fontWeight" />_ios=<xsl:value-of select="@name-ios" /><xsl:text>&#xa;</xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>