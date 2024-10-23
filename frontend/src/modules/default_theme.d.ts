import 'styled-components';

interface IFonts{
  default: string,
  quotes: string
}

interface IColors {
  White: string,
  Black: string,
  Gray: string,
  Yellow: string,
  Green: string,
  Dark_Yellow: string,
}

declare module 'styled-components' {
  export interface DefaultTheme {
    colors: IColors,
    fonts: IFonts
  }
}