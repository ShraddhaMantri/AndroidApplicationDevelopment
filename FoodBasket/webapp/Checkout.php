<?php
 require "connect.php";  
$name = $_POST["login_name"];  
 $user_pass =  $_POST["login_pass"];
 $sql_query = "select address from user_info where user_name like '$name' and Password like '$user_pass';";  
 $result = mysqli_query($con,$sql_query); 
 if(mysqli_num_rows($result) >0 )  
 {  
  $row = mysqli_fetch_assoc($result);  
 $name =$row["address"];  
 echo "$name";
 }  
?>