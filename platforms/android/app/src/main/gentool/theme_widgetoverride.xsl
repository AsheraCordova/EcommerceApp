<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <xsl:template match="/">
        <xsl:for-each select="/resources/style">
			<xsl:if test="@widget-override!='' or not(@widget-override)">
            	<xsl:value-of select="@name" />=<xsl:value-of select="@widget-override" /><xsl:text>&#xa;</xsl:text>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>