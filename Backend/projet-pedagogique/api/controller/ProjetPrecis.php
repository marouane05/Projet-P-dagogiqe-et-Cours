<?php
require_once("../models/Projet.php");
header("Access-Control-Allow-Origin:*");
        header("Content-type: application/json");
 
        $id = $_POST['id'];
        $projet = new Projet();
        $J=[];
        $J["data"]=array();

    
        $BFetch=$projet->DetailProjetById($id);
       
        while($Fetch=$BFetch->fetch(PDO::FETCH_ASSOC)){
          
     extract($Fetch);
                $I=array(
                   "id_projet"=>$Fetch['id'],
                "nom_projet"=>$Fetch['nom_projet'],
                "description"=>$Fetch['description'],
                "admission"=>$Fetch['admission'],
             "debouche"=>$Fetch['debouche'],
            "cout"=>$Fetch['cout'],
            "date_demande"=>$Fetch['date_demande'],
                "nom"=>$Fetch['nom'],
                "prenom"=>$Fetch['prenom'],
             "email"=>$Fetch['email'],
             "nombre_semestre"=>$Fetch['nbr_semestre'],
    
            "nom_cycle"=>$Fetch['nom_cycle']
         
       );
               array_push($J["data"],$I);
              
             
        } ;

       
        echo json_encode($J);
    

?>       