import axios from 'axios';
export class Productoservice{
    //base url
    baseUrl= "http://localhost:8080/api"
    //metodo que trae los datos.(habia salido mal por que puse getALL)
    
    listProducts(){
     return axios.get(this.baseUrl+ "/products/all").then(res => res.data)
    }
}