import React from 'react';
import ReactDOM from 'react-dom/client';
import { ThemeProvider } from 'styled-components';
import { default_theme } from 'styles/default_theme';
import { RouterProvider } from 'react-router-dom';
import GlobalStyle from 'styles/GlobalStyle';
import router from 'configs/Routes';



const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <ThemeProvider theme={default_theme}>
      <GlobalStyle />
      <RouterProvider router={router} />
    </ThemeProvider>
  </React.StrictMode>
);

