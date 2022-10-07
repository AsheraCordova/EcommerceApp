<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <xsl:for-each select="resources/style">
            .<xsl:value-of select="@name" /> {
					<xsl:apply-templates select="." />
                 }
        </xsl:for-each>
    </xsl:template>

	<xsl:template match="style">
		<xsl:if test="@parent">
			<xsl:variable name="myparent" select="@parent"></xsl:variable>
			<xsl:apply-templates select="//style[@name=$myparent]" />
		</xsl:if>
		<xsl:for-each select="item">
			<xsl:if test="contains(./@name, ':')">
				<xsl:value-of select="substring-after(./@name, ':')" />:"<xsl:value-of select="./text()" />";
			</xsl:if>
			<xsl:if test="not(contains(./@name, ':'))">
				<xsl:value-of select="./@name" />:"<xsl:value-of select="./text()" />";
			</xsl:if>
		</xsl:for-each>
		<xsl:if test="@attrs">
			<xsl:call-template name="tokenize">
				<xsl:with-param name="text" select="@attrs"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>


	<xsl:template name="tokenize">
		<xsl:param name="text" />
		<xsl:param name="sep" select="';'" />
		<xsl:choose>
			<xsl:when test="contains($text, $sep)">
				<xsl:value-of select="substring-before(substring-before($text, $sep), ':')" />:"<xsl:value-of select="substring-after(substring-before($text, $sep), ':')" />";
				<!-- recursive call -->
				<xsl:call-template name="tokenize">
					<xsl:with-param name="text"
						select="substring-after($text, $sep)" />
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:if test="$text != ''">
					<xsl:value-of select="substring-before($text, ':')" />:"<xsl:value-of select="substring-after($text, ':')" />";
				</xsl:if>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>