<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <xsl:template match="/">
        <xsl:for-each select="/resources/style[@name='AppTheme']/item">
            <xsl:value-of select="@name" />=<xsl:value-of select="." /><xsl:text>&#xa;</xsl:text>
        </xsl:for-each>
        
        <xsl:for-each select="/resources/style[@name!='AppTheme']">
        	<xsl:if test="@constructor_attrs">
         		<xsl:value-of select="@name" /><xsl:text>_constructor=</xsl:text><xsl:value-of select="@constructor_attrs" /><xsl:text>&#xa;</xsl:text>
         	</xsl:if>
        
         	<xsl:value-of select="@name" /><xsl:text>=</xsl:text>
         	<xsl:if test="@attrs">
         		<xsl:value-of select="@attrs" /><xsl:text>;</xsl:text>
         	</xsl:if>
        	<xsl:for-each select="item">
				<xsl:if test="@android!='true' or not(@android)">
					<xsl:if test="substring-after(@name, ':') != ''">
        				<xsl:value-of select="substring-after(@name, ':')" /><xsl:text>:</xsl:text><xsl:value-of select="." />
        			</xsl:if>
        			<xsl:if test="substring-after(@name, ':') = ''">
        				<xsl:value-of select="@name" /><xsl:text>:</xsl:text><xsl:value-of select="." />
        			</xsl:if>
	                <xsl:if test="position() != last()">
        				<xsl:text>;</xsl:text>
    				</xsl:if>
    			</xsl:if>
        	</xsl:for-each>
        	<xsl:text>&#xa;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>