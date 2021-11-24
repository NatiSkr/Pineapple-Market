import './App.css';
import React from 'react';
import { Routes, Route, BrowserRouter} from "react-router-dom";
import { SessionContext } from './components/context';
import Cover from './components/funcionalidad/cover';
import Signup from './components/funcionalidad/signup';
import Login from './components/funcionalidad/login';
import Navigation from './components/layout/Navigation';
import Categories from './components/funcionalidad/categories';
import ProductosList from './components/funcionalidad/Productoservice.js';
//creamos la clase APP

function App(){
  const context = React.useContext(SessionContext);
	
	//Routes if not logged in
	let routes = (
		<Routes>
			<Route path="/cover" element={<Cover/>} />
			<Route path="/signup" element={<Signup/>} />
			<Route path="/login" element={<Login/>} />
			<Route path="/Productoservice" element={<ProductosList/>} />
			<Route path="/categories" element={<Cover/>} />
			<Route path="/users" element={<Cover/>} />
		</Routes>
	);
	
	//Routes if authenticated
	if (context.isAuth) {
		routes = (
			<Routes>
				<Route path="/signup" element={<Signup/>} />
        		<Route path="/Productoservice" element={<ProductosList/>} />
				<Route path="/categories" element={<Categories/>} />
				<Route path="/users" element={<Cover/>} />
				<Route path="/cover" element={<Cover/>} />
			</Routes>
		);
	}

	return (
		<BrowserRouter>
		<Navigation/>
		{routes}
		</BrowserRouter>
		);
}

export default App;
