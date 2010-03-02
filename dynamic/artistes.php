<?php

$doc = new DOMDocument();
$xsl = new XSLTProcessor();

$doc->load("xslt/TousLesArtistes.xsl");
$xsl->importStyleSheet($doc);

$doc->load("xml/Artistes.xml");
echo $xsl->transformToXML($doc);

?>

