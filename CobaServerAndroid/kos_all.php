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
$query = "select * from kos";
$q = $pdo->prepare($query);
$q->execute();
$data['kos'] = $q->fetchAll(PDO::FETCH_ASSOC);
Database::disconnect();

echo json_encode($data);
?>