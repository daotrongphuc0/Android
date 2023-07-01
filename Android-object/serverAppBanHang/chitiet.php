<?php
include "connect.php";
$query = "SELECT * FROM donhangchitiet ";
$mangchitiet = array();
$data = mysqli_query($conn,$query);
while($row = mysqli_fetch_assoc($data)){
    array_push($mangchitiet,new donhangchitiet(
        $row['id'],
        $row['madonhang'],
        $row['masanpham'],
        $row['tensanpham'],
        $row['giasanpham'],
        $row['soluongsanpham']
    ));
}
echo json_encode($mangchitiet);
class donhangchitiet{
    function donhangchitiet ($id,$madonhang,$masanpham,$tensanpham,$giasanpham,$soluongsanpham){
$this->id= $id;
$this->madonhang= $madonhang;
$this->masanpham= $masanpham;
$this->tensanpham= $tensanpham;
$this->giasanpham= $giasanpham;
$this->soluongsanpham= $soluongsanpham;

    }
}
?>