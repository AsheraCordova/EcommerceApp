<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <xsl:template match="/">
        <xsl:for-each select="//*[@android:id != '']">
            <xsl:variable name="id" select="substring(@android:id, 6)"/>
            <xsl:text>export const </xsl:text><xsl:value-of select="$id" /><xsl:text>:string = </xsl:text>'<xsl:value-of select="@android:id" /><xsl:text>';&#xa;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>