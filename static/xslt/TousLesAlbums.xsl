<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" indent="yes"/>	
	<xsl:template match="Albums">
    <html>
    <head>
      <meta http-equiv="content-type" content="text/html; charset=utf-8" />
       <title>Tous les albums</title>
        <body>
          <div class="titre">
            <h1>Liste des albums</h1>
          </div>
          <div class="album">
            <xsl:apply-templates select="Album">             
	    		  	  <xsl:sort select="Titre"/>
	    		  </xsl:apply-templates>
          </div>
        </body>      
    </head>
    </html>
	</xsl:template>

  <xsl:template  match="Album">
    <p>
      <xsl:apply-templates/>
    </p>
  </xsl:template>	
</xsl:stylesheet>