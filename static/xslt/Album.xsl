<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" indent="yes" />
	<xsl:param name="idAlbum" />
	<xsl:template match="Albums">
		<html>
			<head>
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<title>Album</title>
			</head>
			<body>
				<div class="titre">
					<h1>Album</h1>
				</div>
				<div class="album">
					<xsl:apply-templates select="Album[@id=$idAlbum]">

					</xsl:apply-templates>
				</div>
			</body>

		</html>
	</xsl:template>

	<xsl:template match="Album">
		<p>
			<div class="titre">
				<xsl:value-of select="Titre"/>
			</div>
			<div class="annee">
				<xsl:text>Année </xsl:text> <xsl:value-of select="Annee"/>
			</div>
			<div class="pochette">
				<img src="../../images/{Couverture/@fichier}"/>				
			</div>
		</p>
	</xsl:template>
</xsl:stylesheet>