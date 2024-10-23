import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import "styles/reset.css"
import { ThemeProvider } from 'styled-components';
import { default_theme } from 'styles/default_theme';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <ThemeProvider theme={default_theme}>
      <App />
    </ThemeProvider>
  </React.StrictMode>
);

