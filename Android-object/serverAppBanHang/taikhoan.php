<?php
include "connect.php";
if(isset($_POST['email'])&& isset($_POST['password'])){
    require_once "validate.php";
    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
    $sql = "SELECT * FROM users WHERE email = '$email' AND password = '$password'";
    $result = $conn->query($sql);
    if($result->num_rows > 0){
        echo "1";
    }else{
        echo "fail";
    }
}
?>