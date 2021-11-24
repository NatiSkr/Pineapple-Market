import React, { useContext } from "react";
import { SessionContext } from "../context";
import authService from "../../services/authentication/auth.service";
import { Navbar, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom'

function Navigation(){
    const  {signout, isAuth} = useContext(SessionContext);

	const logout = () => {
		authService.signOut();
		signout()
	}
	
	console.log("From loading navigation, auth status is "+isAuth.toString());
	
    if(isAuth){
		console.log("From navigation: user is authenticated")
		return(
			<div>
			<Navbar bg="dark" variant="dark">
			<Navbar.Brand href="/cover">KOTA</Navbar.Brand>
			<Nav style={{width: '85%'}}>
				<Link to="/login" className="nav-link">Login</Link>
                <Link to="/Productoservice" className="nav-link">Productos</Link>
                <Link to="/users" className="nav-link">Usuarios</Link>
				{isAuth ? (
					<div className="btn btn-primary" onClick={logout.bind(this)} style={{marginLeft: 'auto'}}>
						Logout
					</div>
				):
				(
					<div>
					
					</div>
				)}
			</Nav>
		</Navbar>
		<p>Sesión abierta</p>
		</div>
		)
	}else{
		console.log("From navigation: user is not authenticated");
		return(
			<div>
			<Navbar bg="dark" variant="dark">
			<Navbar.Brand href="/cover">KOTA</Navbar.Brand>
			<Nav style={{width: '85%'}}>
				<Link to="/login" className="nav-link">Login</Link>
				<Link to="/Productoservice" className="nav-link">Productos</Link>
                <Link to="/users" className="nav-link">Usuarios</Link>
				<Link to="/signup" className="nav-link">Registrarse</Link>

				{isAuth ? (
					<div className="btn btn-primary" onClick={logout.bind(this)} style={{marginLeft: 'auto'}}>
						Logout
					</div>
				):
				(
					<div>
					
					</div>
				)}
			</Nav>
		</Navbar>
		<p>No se ha iniciado sesión</p>
		</div>
		)
	}
}

export default Navigation;