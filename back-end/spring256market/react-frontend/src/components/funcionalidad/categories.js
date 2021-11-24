import React,{useEffect} from "react";

function Categories(){

    //  Life cycle
    useEffect(()=>{
        console.log("Hello from Categories.js");

        fetch('/api/categories/all')
        .then(response=>{
            return response.json();
        })
        .then(data=>{console.log(data);
        })
    },[]) //-> executed at component start up

    return(
        <div>
            <h3>Categorias</h3>
        </div>
    );
}

export default Categories;