<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <xsl:template match="/">
        <xsl:if test="count(//*[@fragment != '']) > 0">
//start - import
import { Fragment, Inject } from './app/Fragment';
import { NavController, InjectController } from './navigation/NavController';
import { ScopedObject } from './app/ScopedObject';
<xsl:for-each select="//*[@autoInject != 'noimport']">
<xsl:variable name="name"><xsl:call-template name="substring-after-last"><xsl:with-param name="input" select="name(.)"/><xsl:with-param name="substr" select="'.'"/></xsl:call-template></xsl:variable>
import { <xsl:value-of select="$name" /> } from './android/widget/<xsl:value-of select="$name" />Impl';
</xsl:for-each>
//end - import
//start - className
export default class <xsl:value-of select="//*[@fragment != '']/@fragment" /> extends Fragment
//end - className
{
        //start - body
        @InjectController({})
        navController!: NavController;
        <xsl:for-each select="//*[@autoInject != '']">
        	<xsl:variable name="name"><xsl:call-template name="substring-after-last"><xsl:with-param name="input" select="name(.)"/><xsl:with-param name="substr" select="'.'"/></xsl:call-template></xsl:variable>
        	
            <xsl:variable name="id" select="substring(@android:id, 6)"/>
            <xsl:text>@Inject({ id: "</xsl:text><xsl:value-of select="@android:id" /><xsl:text>" })</xsl:text>&#xa;
        <xsl:text>private </xsl:text><xsl:value-of select="$id" /><xsl:text>!:</xsl:text><xsl:value-of select="$name" /><xsl:text>;&#xa;</xsl:text>
        </xsl:for-each>

        async goToPreviousScreen() {
            await this.navController.reset().popBackStack().executeCommand();
        }        
        //end - body

}
        </xsl:if>
    </xsl:template>
    
    <xsl:template name="substring-after-last">
		<xsl:param name="input"/>
		<xsl:param name="substr"/>
		   
		<!-- Extract the string which comes after the first occurence -->
		<xsl:variable name="temp" select="substring-after($input,$substr)"/>
		   
		<xsl:choose>
		     <!-- If it still contains the search string the recursively process -->
		     <xsl:when test="$substr and contains($temp,$substr)">
		          <xsl:call-template name="substring-after-last">
		               <xsl:with-param name="input" select="$temp"/>
		               <xsl:with-param name="substr" select="$substr"/>
		          </xsl:call-template>
		     </xsl:when>
		     <xsl:when test="$temp = ''">
				    <xsl:value-of select="$input" />
			 </xsl:when>
		     <xsl:otherwise>		     
		          <xsl:value-of select="$temp"/>
		     </xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>