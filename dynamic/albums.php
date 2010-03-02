<?php

$doc = new DOMDocument();
$xsl = new XSLTProcessor();

$doc->load("xslt/TousLesAlbums.xsl");
$xsl->importStyleSheet($doc);

$doc->load("xml/Albums.xml");
echo $xsl->transformToXML($doc);

?>

