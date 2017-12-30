<?php  
 require "connect.php";  
 $name = $_POST["user_name"];  
 $password = $_POST["user_pass"];  
 $email = $_POST["user_email"];
$address=$_POST["user_address"];
$user_type=$_POST["user_type"];
  
 $sql_query = "insert into user_info values('$name','$password','$email','$address','$user_type');"; 
if(mysqli_query($con,$sql_query))
{
echo "Registration Success";
}
else
{
echo "Registration not Successfull";
}
 
?>                                                                                                                                                                                                                                                                                                                                       