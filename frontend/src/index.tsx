import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import "styles/reset.css"
import { ThemeProvider } from 'styled-components';
import { default_theme } from 'styles/default_theme';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import LandingPage from 'pages/Landing/Index';
import LoginPage from 'pages/Session/LoginPage';
import RegisterPage from 'pages/Session/RegisterPage';
import RegisterPage2 from 'pages/Session/RegisterPage2';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "",
        element: <LandingPage />
      },
      {
        path: "/login",
        element: <LoginPage />
      },
      {
        path: "/register",
        element: <RegisterPage />
      },
      {
        path: "/register2",
        element: <RegisterPage2 />
      }
    ]
  }
])

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <ThemeProvider theme={default_theme}>
      <RouterProvider router={router} />
    </ThemeProvider>
  </React.StrictMode>
);

