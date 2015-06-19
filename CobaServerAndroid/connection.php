<?php
/**
 * Created by PhpStorm.
 * User: hermawan
 * Date: 12/06/2015
 * Time: 13:58
 */
/*menyesuaikan dengan konfigurasi server sendiri*/
//$conn = mysqli_connect('localhost','root','','latihan_android') or die(mysqli_error(''););
//$db = mysqli_select_db('latihan_android') or die(mysql_error());
class Database
{
    private static $dbName = 'u141379420_00000' ;
    private static $dbHost = 'mysql.idhostinger.com' ;
    private static $dbUsername = 'u141379420_root';
    private static $dbUserPassword = 'Ckud0SaZxbR';

    private static $cont  = null;

    public function __construct() {
        exit('Init function is not allowed');
    }

    public static function connect()
    {
        // One connection through whole application
        if ( null == self::$cont )
        {
            try
            {
                self::$cont =  new PDO( "mysql:host=".self::$dbHost.";"."dbname=".self::$dbName, self::$dbUsername, self::$dbUserPassword);
            }
            catch(PDOException $e)
            {
                die($e->getMessage());
            }
        }
        return self::$cont;
    }

    public static function disconnect()
    {
        self::$cont = null;
    }
}


?>
