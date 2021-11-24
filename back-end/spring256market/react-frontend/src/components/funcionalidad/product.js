import React,{useEffect} from "react";

function Products(){

    //  Life cycle
    useEffect(()=>{
        console.log("Hello from Products.js");

        fetch('/api/products/all')
        .then(response=>{
            return response.json();
        })
        .then(data=>{console.log(data);
        })
    },[]) //-> executed at component start up

    return(
        <div>
            <h3>Products</h3>
        </div>
    );
}

export default Products;