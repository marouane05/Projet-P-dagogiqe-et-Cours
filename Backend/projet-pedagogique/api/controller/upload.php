<?php

header("Access-Control-Allow-Origin: *");
header("Content-type: application/json");

$res["reponse"] = array();
 $targetfolder = "testupload/";

 $targetfolder = $targetfolder . basename( $_FILES['file']['name']) ;

 $ok=1;

$file_type=$_FILES['file']['type'];

if ($file_type=="application/pdf" || $file_type=="image/gif" || $file_type=="image/jpeg") {

 if(move_uploaded_file($_FILES['file']['tmp_name'], $targetfolder))

 {

$exec= "The file ". basename( $_FILES['file']['name']). " is uploaded";

 array_push($res["reponse"],["succed"=>true,"loggedin"=>$exec]);
 echo json_encode($res);
 }

 else {

    $exec=  "Problem uploading file";
    array_push($res["reponse"],["succed"=>true,"loggedin"=>$exec]);
    echo json_encode($res);
 }

}

else {

    $exec= "You may only upload PDFs, JPEGs or GIF files.<br>";
    array_push($res["reponse"],["succed"=>true,"loggedin"=>$exec]);
    echo json_encode($res);
}

?>