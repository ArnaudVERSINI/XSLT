<?php

$id = (int) $_GET['id'];
$doc = new DOMDocument();
$xsl = new XSLTProcessor();

$doc->load("xslt/Artiste.xsl");
$xsl->importStyleSheet($doc);
$xsl->setParameter('', 'idArtiste', $id);

$doc->load("xml/Artistes.xml");
echo $xsl->transformToXML($doc);

?>

