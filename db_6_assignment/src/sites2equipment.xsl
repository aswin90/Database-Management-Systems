<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />
	<xsl:template match="/">
	<html>
	<head>
	</head>
	<body>
			<ol>
			<xsl:for-each select="Sites/Site/Tower/Equipment">
				<li>
						<xsl:text>EquipmentId:</xsl:text>
						<xsl:value-of select="@id"/>
						<xsl:text>, brand:</xsl:text>
						<xsl:value-of select="@brand"/>
						<xsl:text>, description:</xsl:text>
						<xsl:value-of select="@description"/>
						<xsl:text>, name:</xsl:text>
						<xsl:value-of select="@name"/>
						<xsl:text>, price:</xsl:text>
						<xsl:value-of select="@price"/>
				</li>
			</xsl:for-each>
			</ol>
	</body>
	</html>
		
	</xsl:template>
</xsl:stylesheet>