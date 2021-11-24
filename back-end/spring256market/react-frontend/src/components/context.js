import React, { useState, useEffect } from 'react';

//Create context
export const SessionContext = React.createContext({
  isAuth: false,
  login: () => {},
});

//Create "class" context con sus funciones y variables a compartir
const SessionContextProvider = props => {
    
    const [isAuthenticated, setIsAuthenticated] = useState(
      localStorage.getItem("userAuth") || false
    );

    const [user, setUser] = useState(
        localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : null
      );
    

    //Login Context
    const loginHandler = () => {
        setIsAuthenticated(true);
        setUser(JSON.parse(localStorage.getItem("user")));
    };
    
    useEffect(() => {
        setIsAuthenticated(localStorage.getItem("userAuth"));
      }, [isAuthenticated]);
  
    useEffect(() => {
        setUser(JSON.parse(localStorage.getItem("user")));
    }, [user]);
  
    const signoutHandler = () => {
    setIsAuthenticated(false);
    };

    return (
        <SessionContext.Provider
          value={
            {
              //Login Variables
              login: loginHandler,
              signout: signoutHandler,
              isAuth: isAuthenticated,
              user,
            }
          }
        >
          {props.children}
        </SessionContext.Provider>
      );
};

export default SessionContextProvider;