<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" indent="yes" />
	<xsl:template match="Artistes">
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../images/ihm1.css" />
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<title>Tous les artistes</title>
				<body>
					<div class="titre">
						<h1>Liste des articles par genre</h1>
					</div>
					<div class="type_affichage">
						<h2>Types d'artistes</h2>
					</div>
					<xsl:apply-templates select="Type" mode="typeArtistes" />

					<xsl:apply-templates select="Type" mode="artistesParType" />

				</body>
			</head>
		</html>
	</xsl:template>

	<xsl:template match="Type" mode="artistesParType">
		<xsl:variable name="type_id" select="@id" />
		<div class="{.}">
			<a name="{.}">
				<h2>
					<xsl:value-of select="." />
				</h2>
			</a>
			<xsl:for-each select="../Artiste[@type=$type_id]">
				<li>
					<a href="artiste.php?id={@id}">
						<xsl:value-of select="Prenom" />
						<xsl:text> </xsl:text>
						<xsl:value-of select="Nom" />
					</a>
				</li>
			</xsl:for-each>
		</div>
	</xsl:template>

	<xsl:template match="Type" mode="typeArtistes">
		<div class="{.}">
			<li>
				<a href="#{.}">
					<xsl:apply-templates />
				</a>
			</li>
		</div>
	</xsl:template>
</xsl:stylesheet>
