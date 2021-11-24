import { useState, useEffect } from 'react';
import React from 'react'
import authHeader from '../../services/authentication/auth-header';

function ProductosList(){
    const [products, setProducts] = useState(false);
    
    let getObj = {
        method: 'GET',
        headers: authHeader
    }

    useEffect((async) => {
        fetch(`/api/products/all`,getObj )
        .then(response => {
            return response.json();
        })
        .then(data =>{
            setProducts(data)
        })
    }, [])

    return (
        <div className="products-list">
            <h3>Productos</h3>
            
        </div>
    )
}
export default ProductosList;