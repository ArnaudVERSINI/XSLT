<?php

$id = (int) $_GET['id'];
$doc = new DOMDocument();
$xsl = new XSLTProcessor();

$doc->load("xslt/Album.xsl");
$xsl->importStyleSheet($doc);
$xsl->setParameter('', 'idAlbum', $id);

$doc->load("xml/Albums.xml");
echo $xsl->transformToXML($doc);

?>

