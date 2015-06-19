<?php
/**
 * Created by PhpStorm.
 * User: hermawan
 * Date: 12/06/2015
 * Time: 14:01
 */
//reply data from JSON
include('connection.php');
$pdo = Database::connect();
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$query = "select * from mahasiswa";
$q = $pdo->prepare($query);

$q->execute();
$data = $q->fetch(PDO::FETCH_ASSOC);
Database::disconnect();

var_dump($data);
//
//$result = mysql_query($query) or die(mysql_error());
//$row=mysql_fetch_object($result)
//$data = array();
//while($data = $q->fetch(PDO::FETCH_ASSOC)){
//    //$row=mysql_fetch_object($result)
//    $data['mahasiswa'][]=$row;
//}
echo json_encode($data);
?>