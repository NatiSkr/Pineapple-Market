import React,{Component} from 'react';
//import logo from './logo.svg';
import './App.css';
import { Productoservice } from './services/Productoservice';
//creamos la clase APP
export default class App extends Component{ 
constructor(){
  super();
  this.state = {}
  this.Productoservice = new Productoservice();
}
componentDidMount(){
  this.Productoservice.listProducts().then(data=>{
    console.log(data);
  })
}
render(){
  return(
    <h1>hola Mundo</h1>
  );
}
}


