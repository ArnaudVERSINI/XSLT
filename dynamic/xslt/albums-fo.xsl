<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:xlink="http://www.w3.org/1999/xlink" exclude-result-prefixes="xlink">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<!--  Page de garde -->
				<fo:simple-page-master master-name="pageGarde"
					page-height="29.7cm" page-width="21cm" margin-top="0cm"
					margin-bottom="0cm" margin-left="0cm" margin-right="0cm">
					<fo:region-body margin-top="0cm" />
					<fo:region-before extent="0cm" />
					<fo:region-after extent="0cm" />
				</fo:simple-page-master>

				<!--  Liste des Albums -->
				<fo:simple-page-master master-name="listeAlbums"
					page-width="210mm" page-height="297mm" margin-top="0.5in"
					margin-bottom="0.5in" margin-left="0.5in" margin-right="0.5in">

					<fo:region-body margin-top="1.0in" />


				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="pageGarde">
				<fo:flow flow-name="xsl-region-body">
					<fo:block background-image="url('../images/wallpaper1_a4.jpg')"
						background-position="left center" padding="14.2cm" text-align="center">
						<fo:inline font-size="36pt" background-color="transparent"
							color="white">
							<xsl:text>Liste des albums</xsl:text>
						</fo:inline>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>

			<fo:page-sequence master-reference="listeAlbums">

				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="Albums" />
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="Albums">
		<xsl:apply-templates select="Albums" />
		<xsl:apply-templates select="Album" />
		<xsl:apply-templates select="Titre" />
		<xsl:apply-templates select="Annee" />
		<xsl:apply-templates select="Pistes" />
	</xsl:template>

	<xsl:template match="Albums">
		<fo:block>
			<fo:inline font-size="22pt" background-color="#EEEEEE">
				<xsl:text>Liste des albums</xsl:text>
			</fo:inline>
		</fo:block>
		<fo:table border-collapse="collapse" font-size="12pt"
			font-family="Arial" font-style="italic">
			<fo:table-column column-width="20%" background-color="rgb(255,246,206)" />
			<fo:table-column column-width="30%" />
			<fo:table-column column-width="30%" />
			<fo:table-header color="rgb(255,255,255)"
				background-color="rgb(125,73,2)" font-weight="bold">
				<fo:table-row>
					<fo:table-cell padding="2pt" border="1pt solid black">
						<fo:block>Titre</fo:block>
					</fo:table-cell>
					<fo:table-cell padding="2pt" border="1pt solid black">
						<fo:block>Année</fo:block>
					</fo:table-cell>
					<fo:table-cell padding="2pt" border="1pt solid black">
						<fo:block>Nombre de piste</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:apply-templates />
			</fo:table-body>
		</fo:table>

	</xsl:template>
	<xsl:template match="Album">
		<fo:table-row>
			<xsl:apply-templates />
		</fo:table-row>
	</xsl:template>

	<xsl:template match="Titre">
		<fo:table-cell padding="2pt" border="1pt solid black">
			<fo:block>
				<xsl:value-of select="." />
			</fo:block>
		</fo:table-cell>
	</xsl:template>

	<xsl:template match="Annee">
		<fo:table-cell padding="2pt" border="1pt solid black">
			<fo:block>
				<xsl:value-of select="." />
			</fo:block>
		</fo:table-cell>
	</xsl:template>

	<xsl:template match="Pistes">
		<fo:table-cell padding="2pt" border="1pt solid black">
			<fo:block>
				<xsl:value-of select="count(Piste)" />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
</xsl:stylesheet>

