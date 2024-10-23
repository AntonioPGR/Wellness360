import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import "styles/reset.css"
import { ThemeProvider } from 'styled-components';
import { default_theme } from 'styles/default_theme';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import PublishPage from 'pages/Publish/Index';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "",
        element: <PublishPage />
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

