import React, { useState } from 'react';
import { Button, Container} from 'react-bootstrap';
import authService from '../../services/authentication/auth.service'
import { SessionContext } from "../context";

import { useNavigate } from "react-router-dom";

export default function Login() {
    let navigate = useNavigate();
    const authContext = React.useContext(SessionContext);
    
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const submit = event => {
        event.preventDefault();
        // connect to /login api
        authService.signIn(username, password)
        .then((response) => {
          if (response.id) {
            authContext.login();
            navigate("/Productoservice");
          }
        })
        .catch((e) => {
          console.log(e);
        });
    }

    return (
        <Container>
            <div>
            <h3>Login</h3>
            <form onSubmit={submit}>
                <div className="form-group">
                    <label>Nombre de usuario</label>
                    <input 
                        type="text" 
                        onChange={e => setUsername(e.target.value)} 
                    />
                </div>

                <div className="form-group">
                    <label>Contraseña</label>
                    <input 
                        type="password" 
                        onChange={e => setPassword(e.target.value)}
                    />
                </div>
                <Button 
                    type="submit"
                    variant="primary"
                    disabled={username.length === 0 || password.length === 0}
                >
                    Login
                </Button>
            </form>
            </div>
        </Container>
    )
}