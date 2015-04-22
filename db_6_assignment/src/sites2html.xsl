<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/">
	<html>
	<head>
	</head>
	<body>
			<ol>
			<xsl:for-each select="Sites/Site">
				<li>
						<xsl:text>SiteId:</xsl:text>
						<xsl:value-of select="@id"/>
						<xsl:text>, latitude:</xsl:text>
						<xsl:value-of select="@latitude"/>
						<xsl:text>, longitude:</xsl:text>
						<xsl:value-of select="@longitude"/>
						<xsl:text>, name:</xsl:text>
						<xsl:value-of select="@name"/>
					
						<xsl:for-each select="Tower">
						<ul>
								<xsl:text>TowerId:</xsl:text>
								<xsl:value-of select="@id"/>
								<xsl:text>, height:</xsl:text>
								<xsl:value-of select="@height"/>
								<xsl:text>, name:</xsl:text>
								<xsl:value-of select="@name"/>
								<xsl:text>, slides:</xsl:text>
								<xsl:value-of select="@slides"/>
						</ul>
						</xsl:for-each>
						
				</li>
			</xsl:for-each>
			</ol>
	</body>
	</html>
	</xsl:template>
</xsl:stylesheet>