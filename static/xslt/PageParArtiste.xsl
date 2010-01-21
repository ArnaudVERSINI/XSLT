<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="Albums">
		<project name="albums" default="fichier_par_album" basedir=".">
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
			<target name="fichier_par_album" depends="vars">
				<xsl:apply-templates select="Album" />
			</target>
		</project>
	</xsl:template>
	<xsl:template match="Album">
		<xsl:element name="xslt">
			<xsl:attribute name="style">${xslt}/Album.xsl</xsl:attribute>
			<xsl:attribute name="in">${xml}/Albums.xml</xsl:attribute>
			<xsl:attribute name="out">${output}/Album-<xsl:value-of
				select="@id" />.html</xsl:attribute>
			<xsl:element name="param">
				<xsl:attribute name="name">idAlbum</xsl:attribute>
				<xsl:attribute name="expression"><xsl:value-of select="@id" /></xsl:attribute>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>