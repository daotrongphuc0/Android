<?php
include "connect.php";
$id = $_POST['id'];
$query = "DELETE FROM donhang WHERE id ='$id'";
if($conn->query($query)== true){
    echo "success";
}else{
    echo "fail";
}
?>