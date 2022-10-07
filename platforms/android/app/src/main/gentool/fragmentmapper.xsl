<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <xsl:template match="/">
import Index from './Index';
import ErrorFragment from './ErrorFragment';
import ErrorDetailFragment from './ErrorDetailFragment';
//start - import
<xsl:for-each select="/Files/File">
import <xsl:value-of select="@name" /> from './<xsl:value-of select="@name" />';
</xsl:for-each>
//end - import

export const fragmentMapper : any = {
    'layout/error.xml': ErrorFragment,
    'layout/error_detail.xml': ErrorDetailFragment,
    'layout/index.xml': Index,
    //start - body
    <xsl:for-each select="/Files/File">
     'layout/<xsl:value-of select="@path" />': <xsl:value-of select="@name" />,
    </xsl:for-each>
     //end - body
};
    </xsl:template>
</xsl:stylesheet>