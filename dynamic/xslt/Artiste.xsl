<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" indent="yes" />
	<xsl:param name="idArtiste" />
	<xsl:template match="Artistes">
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../images/ihm1.css" />
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<title>Artiste</title>
			</head>
			<body>
				<div class="artiste">
					<xsl:apply-templates select="Artiste[@id=$idArtiste]">

					</xsl:apply-templates>
				</div>
			</body>

		</html>
	</xsl:template>

	<xsl:template match="Artiste">
		<p>
			<div id="top_bar" class="titre">
				<xsl:value-of select="Prenom" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="Nom" />
			</div>
			
						
			<div id="column_left" class="photo">
				<img src="{Photo/@fichier}" />
			</div>
			
			<div id="column_left" class="date_naissance">
				<xsl:text>Date de naissance  </xsl:text>
				<xsl:value-of select="Date-naissance" />
				<xsl:text> à  </xsl:text>
				<xsl:value-of select="Lieu-naissance" />
			</div>
			
			<div id="column_left" class="titre-info-graphie">
				<xsl:text>Biographie :  </xsl:text>
			</div>
			
			<div id="column_left" class="info-graphie">
				<xsl:value-of select="Info_Biographie" />
			</div>


			
			
		</p>
	</xsl:template>
</xsl:stylesheet>
