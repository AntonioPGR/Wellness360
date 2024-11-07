import App from "App";
import LandingPage from "pages/Landing/Index";
import LoginPage from "pages/Session/LoginPage";
import RegisterPage from "pages/Session/RegisterPage";
import { createBrowserRouter } from "react-router-dom";

enum RoutesEnum{
  HOME = "",
  LOGIN = "/login",
  REGISTER = "/register",
  LANDING = "/landing",
}

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: RoutesEnum.LANDING,
        element: <LandingPage />
      },
      {
        path: RoutesEnum.LOGIN,
        element: <LoginPage />
      },
      {
        path: RoutesEnum.REGISTER,
        element: <RegisterPage />
      },
    ]
  }
])

export default router;
export {RoutesEnum};