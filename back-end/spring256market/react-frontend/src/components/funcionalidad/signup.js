import React, { useState, useEffect } from 'react';
import { Button, Container} from 'react-bootstrap';
import authService from '../../services/authentication/auth.service'
import { SessionContext } from "../context";
import { useNavigate } from "react-router-dom";
const PASSWORD_MIN_LENGTH = 8;

export default function Signup() {
    const authContext = React.useContext(SessionContext);
    const [username, setUsername] = useState("");
    const [role, setRole] = useState("");
    const [password, setPassword] = useState("");
    const [repeatPassword, setRepeatPassword] = useState("");
    const [passwordsMatch, setPasswordsMatch] = useState(true)
    const [validPassword, setValidPassword] = useState(false)
    
    let navigate = useNavigate();
    
    const submit = event => {
        event.preventDefault();
        // connect to /signup api
        authService.register(username, [role], password)
        .then((response) => {
          if (response.id) {
            authContext.login();
          }
        })
        .then(()=>{
            navigate("/login");
        })
        .catch((e) => {
          console.log(e);
        });
    }

    useEffect(() => {
        setValidPassword(password.length >= PASSWORD_MIN_LENGTH);
    }, [password])

    useEffect(() => {
        setPasswordsMatch(password === repeatPassword);
    }, [password, repeatPassword])

    return (
        <Container>
            <div>
                <h3>Registro</h3>
                <form onSubmit={submit}>
                    
                    <div className="form-group">
                        <label htmlFor="floatingInput">Nombre de usuario</label>
                        <input 
                            className="form-control" 
                            id="floatingInput" 
                            placeholder="usuario@ejemplo.com"
                            type="text" 
                            onChange={e => setUsername(e.target.value)} 
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="floatingRole">Rol del nuevo usuario</label>
                        <input 
                            className="form-control" 
                            id="floatingRole" 
                            placeholder="ADMIN o USER"
                            type="text" 
                            onChange={e => setRole(e.target.value)} 
                        />
                        <small>Para empleados de la tienda, otorgue el rol USER de sólo lectura. Para supervisores o encargados de tienda, otorgue el rol ADMIN</small>
                    </div>

                    <div className="form-group">
                        <label htmlFor="floatingPassword">Contraseña</label>
                        <input 
                            type="password" 
                            className="form-control" 
                            id="floatingPassword" 
                            placeholder="Contraseña"
                            onChange={e => setPassword(e.target.value)}
                        />
                        <small>Debe contener al menos {PASSWORD_MIN_LENGTH} caracteres. Recomendamos combinar mayusculas, minusculas y números.</small>
                    </div>
                    <div className="form-item">
                        <label>Repetir contraseña</label>
                        <input 
                            type="password" 
                            onChange={e => setRepeatPassword(e.target.value)}
                        />
                        {!passwordsMatch && <small className="error-text">Las contraseñas no coinciden</small>}
                    </div>
                    
                    <Button 
                        type="submit"
                        variant="primary" 
                        disabled={username.length === 0 || !validPassword || !passwordsMatch}
                    >
                        Crear
                    </Button>
                </form>
            </div>
        </Container>
    )
}