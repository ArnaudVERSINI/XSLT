<?xml version='1.0'?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" indent="yes"/>
  <xsl:param name="idArtiste" />
	<xsl:template match="Artistes">
    <html>
    <head>
      <meta http-equiv="content-type" content="text/html; charset=utf-8" />
       <title>Artiste</title>
       </head>
        <body>
          <div class="titre">
            <h1>Artiste</h1>
          </div>
          <div class="artiste">
            <xsl:apply-templates select="Artiste[@id=$idArtiste]">         
	    		  	 
	    	</xsl:apply-templates>
          </div>
        </body>      
    
    </html>
	</xsl:template>

  <xsl:template  match="Artiste">
    <p>
      <xsl:apply-templates/>
    </p>
  </xsl:template>	
</xsl:stylesheet>