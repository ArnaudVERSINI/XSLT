<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" indent="yes" />
	<xsl:param name="idArtiste" />
	<xsl:template match="Albums">
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../../images/ihm1.css" />
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<title>Album par artiste</title>
			</head>
			<body>
				<div  id="top_bar" class="titre">
					<a href="Artiste-{$idArtiste}.html" style="text-decoration:none;">
						<xsl:value-of
							select="document('../xml/Artistes.xml')//Artiste[@id=$idArtiste]/Prenom" />
						<xsl:text> </xsl:text>
						<xsl:value-of
							select="document('../xml/Artistes.xml')//Artiste[@id=$idArtiste]/Nom" />
					</a>
					</div>
					 <xsl:apply-templates select="Album" />
				
			</body>

		</html>
	</xsl:template>

	<xsl:template match="Album">
		<xsl:if test="$idArtiste=Artiste/@ref">
		<div id="column_left" class="photo">
			<a href="Album-{@id}.html" style="text-decoration:none;">
				<img src="{Couverture/@fichier}" />
			</a>
			</div>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>