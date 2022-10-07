<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <xsl:for-each select="resources/string">
      		<xsl:variable name="value">
			    <xsl:call-template name="string-replace-all">
			        <xsl:with-param name="text" select="." />
			        <xsl:with-param name="replace" select="'&#10;'" />
			        <xsl:with-param name="by" select="'\&#xa;'" />
			    </xsl:call-template>
			</xsl:variable>
            <xsl:value-of select="@name" />=<xsl:value-of select="$value" /><xsl:text>&#xa;</xsl:text>
        </xsl:for-each>
        <xsl:for-each select="resources/array">
        	<xsl:if test="@separator">
        		<xsl:value-of select="@name" />.separator=<xsl:value-of select="@separator" /><xsl:text>&#xa;</xsl:text>
        	</xsl:if>
        </xsl:for-each>
        <xsl:for-each select="resources/array">
         	<xsl:value-of select="@name" /><xsl:text>=</xsl:text>
         	<xsl:variable name="separator" select="@separator"></xsl:variable>
        	<xsl:for-each select="item">
	        	<xsl:variable name="value">
				    <xsl:call-template name="string-replace-all">
				        <xsl:with-param name="text" select="." />
				        <xsl:with-param name="replace" select="'&#10;'" />
				        <xsl:with-param name="by" select="'\&#xa;'" />
				    </xsl:call-template>
				</xsl:variable>
       			<xsl:value-of select="$value" />
                <xsl:if test="position() != last()">
       				<xsl:choose>
					   <xsl:when test="$separator">
					     <xsl:value-of select="$separator" />
					   </xsl:when>
					   <xsl:otherwise>
					     <xsl:text>,</xsl:text>
					   </xsl:otherwise>
					</xsl:choose> 
   				</xsl:if>
        	</xsl:for-each>
        	<xsl:text>&#xa;</xsl:text>
        </xsl:for-each>
    </xsl:template>
    
    <xsl:template name="string-replace-all">
	    <xsl:param name="text" />
	    <xsl:param name="replace" />
	    <xsl:param name="by" />
	    <xsl:choose>
	        <xsl:when test="$text = '' or $replace = ''or not($replace)" >
	            <!-- Prevent this routine from hanging -->
	            <xsl:value-of select="$text" />
	        </xsl:when>
	        <xsl:when test="contains($text, $replace)">
	            <xsl:value-of select="substring-before($text,$replace)" />
	            <xsl:value-of select="$by" />
	            <xsl:call-template name="string-replace-all">
	                <xsl:with-param name="text" select="substring-after($text,$replace)" />
	                <xsl:with-param name="replace" select="$replace" />
	                <xsl:with-param name="by" select="$by" />
	            </xsl:call-template>
	        </xsl:when>
	        <xsl:otherwise>
	            <xsl:value-of select="$text" />
	        </xsl:otherwise>
	    </xsl:choose>
	</xsl:template>
</xsl:stylesheet>