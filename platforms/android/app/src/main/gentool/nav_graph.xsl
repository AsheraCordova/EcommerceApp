<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <xsl:template match="/">
        <xsl:for-each select="//action">
            <xsl:variable name="actionid" select="substring(@android:id, 6)"/>
            <xsl:variable name="destination" select="concat('@+id/', substring(@app:destination, 5))"/>
            <xsl:text>export const </xsl:text><xsl:value-of select="$actionid" /><xsl:text>:string = </xsl:text>'<xsl:value-of select="$actionid" />#<xsl:value-of select="//fragment[@android:id=$destination]/@tools:layout" /><xsl:text>';&#xa;</xsl:text>
        </xsl:for-each>
        <xsl:for-each select="//fragment">
            <xsl:variable name="id" select="substring(@android:id, 6)"/>
            <xsl:text>export const </xsl:text><xsl:value-of select="$id" /><xsl:text>:string = </xsl:text>'fragment#<xsl:value-of select="$id" />#<xsl:value-of select="substring(@tools:layout, 2)" />.xml<xsl:text>';&#xa;</xsl:text>
        </xsl:for-each>
        <xsl:for-each select="//dialog">
            <xsl:variable name="id" select="substring(@android:id, 6)"/>
            <xsl:text>export const </xsl:text><xsl:value-of select="$id" /><xsl:text>:string = </xsl:text>'dialog#<xsl:value-of select="$id" />#<xsl:value-of select="substring(@tools:layout, 2)" />.xml#<xsl:value-of select="@android:layout_width" />#<xsl:value-of select="@android:layout_height" />#<xsl:value-of select="@style" /><xsl:text>';&#xa;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>