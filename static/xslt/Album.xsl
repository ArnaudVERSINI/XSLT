<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" indent="yes" />
	<xsl:param name="idAlbum" />
	<xsl:template match="Albums">
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../../images/ihm1.css" />
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<title>Album</title>
			</head>
			<body>
				<div class="album">
					<xsl:apply-templates select="Album[@id=$idAlbum]">

					</xsl:apply-templates>
				</div>
			</body>

		</html>
	</xsl:template>

	<xsl:template match="Album">
		<p>
			<div id="topbar" class="titre">
				<xsl:value-of select="Titre" />
				<xsl:text> (</xsl:text>
				<xsl:value-of select="Annee" />
				<xsl:text> )</xsl:text>
			</div>

			<div id="column_right" class="pochette">
				<img src="{Couverture/@fichier}" />
			</div>

		<table id="column_left">
			<xsl:for-each select="Pistes/Piste">
				<tr>
					<td>
						<xsl:value-of select="No" />
					</td>					
						
					<td>
						<xsl:value-of select="Titre" />
					</td>
					
					<td>
						<xsl:value-of select="Duree" />
					</td>
					
				</tr>
			</xsl:for-each>
	</table>
		</p>
	</xsl:template>
</xsl:stylesheet>