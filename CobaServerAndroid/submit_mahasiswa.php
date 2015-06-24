<?php
/**
 * Created by PhpStorm.
 * User: hermawan
 * Date: 12/06/2015
 * Time: 14:05
 */
//jika id=0, maka akan dilakukan insert, jika tidak update berdasarkan id
include('connection.php');

$id = (int)$_POST['id'];
$namaPemilik = $_POST['namaPemilik'];
$alamat = $_POST['alamat'];
$harga = $_POST['harga'];
$noHP = $_POST['noHP'];
$latitude = $_POST['latitude'];
$longitude = $_POST['longitude'];
$fasilitas = $_POST['fasilitas'];

var_dump($query);
$pdo = Database::connect();
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$query = 'insert into kos(namaPemilik, alamat, harga, noHP, latitude, longitude, fasilitas) values(?, ?, ?, ?, ?, ?, ?)';

if($id>0){
    $query = 'update mahasiswa set namaPemilik = "'.$namaPemilik.'", alamat = "'.$alamat.'", harga = "'.$harga.'", noHP = "'.$noHP.'", latitude = "'.$latitude.'", longitude = "'.$longitude.'", fasilitas = "'.$fasilitas.'" where id = '.$id;
}
$q = $pdo->prepare($query);
$q->execute(array($namaPemilik, $alamat, $harga, $noHP, $latitude, $longitude, $fasilitas));
Database::disconnect();

?>