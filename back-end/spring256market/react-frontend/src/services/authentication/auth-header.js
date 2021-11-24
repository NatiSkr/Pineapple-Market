export default function authHeader() {
    const user = JSON.parse(localStorage.getItem("user"));
  
    if (user && user.accessToken) {
      console.log(user.accessToken);
      return {
        "tokenType": "Bearer",
        "accessToken": user.accessToken,
        "Access-Control-Allow-Origin": "*"
      };
    } else {
      return {};
    }
  }