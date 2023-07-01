<?php
include "connect.php";
require_once "validate.php";
$name = validate($_POST['name']);
$email = validate($_POST['email']);
$password = validate($_POST['password']);
$sql = "INSERT INTO users(id,name,email,password) VALUES(null,'$name','$email',$password)";
if($conn->query($sql)== true){
    echo "success";
}else{
    echo "failer";
}

?>