<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ihm/XSLT/images/ihm1.css">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Accueil-Site statique</title>
  <style type="text/css">
  
  </style>
  </head>
  <body>
 
    <div id="sommaire">
	<h3>Accueil</h3>
     <a href="index.php?page=1">Tous les artistes</a><br/>
	<a href="index.php?page=2">Tous les albums</a><br/>
    </div>
 
    <div id="page">
        <?php
        if (isset($_GET['page'])) $numero=$_GET['page']; else $numero='1';
        require '/dynamic/artistes.php';
        ?>
    </div>
 
  </body>
</html>




