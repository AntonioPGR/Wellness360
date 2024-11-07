import { DefaultTheme } from "styled-components";

export const getColor = (color:color_options, theme:DefaultTheme) => {
  switch(color){
    case "green": return theme.colors.Green;
    case "white": return theme.colors.White;
    case "gray": return theme.colors.Gray;
    case "yellow": return theme.colors.Dark_Yellow;
    case "black": return theme.colors.Black;
  }
}

export const getAlign = (op:align_options) => {
  switch(op){
    case "center": return "center";
    case "left": return "flex-start";
    case "right": return "flex-end";
  }
}