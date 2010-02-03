<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="Artistes">
		<project name="artistes" default="fichier_par_artiste" basedir=".">
			<target name="vars">
				<xsl:element name="property">
					<xsl:attribute name="name">xml</xsl:attribute>
					<xsl:attribute name="value">${basedir}/xml</xsl:attribute>
				</xsl:element>
				<xsl:element name="property">
					<xsl:attribute name="name">xslt</xsl:attribute>
					<xsl:attribute name="value">${basedir}/xslt</xsl:attribute>
				</xsl:element>
				<xsl:element name="property">
					<xsl:attribute name="name">output</xsl:attribute>
					<xsl:attribute name="value">${basedir}/output</xsl:attribute>
				</xsl:element>
			</target>
			<target name="fichier_par_artiste" depends="vars">
				<xsl:apply-templates select="Artiste" />
			</target>
		</project>
	</xsl:template>
	<xsl:template match="Artiste">
		<xsl:element name="xslt">
			<xsl:attribute name="style">${xslt}/Artiste.xsl</xsl:attribute>
			<xsl:attribute name="in">${xml}/Artistes.xml</xsl:attribute>
			<xsl:attribute name="out">${output}/Artiste-<xsl:value-of
				select="@id" />.html</xsl:attribute>
			<xsl:element name="param">
				<xsl:attribute name="name">idArtiste</xsl:attribute>
				<xsl:attribute name="expression"><xsl:value-of select="@id" /></xsl:attribute>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>