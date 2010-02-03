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
			<xsl:apply-templates />
		</p>
	</xsl:template>
</xsl:stylesheet>