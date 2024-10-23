import styled from "styled-components";
import { getColor } from "styles/style_functions";

interface IButtonProps{
  label: string,
  onClick: () => void,
  bg?: color_options,
  text?: color_options,
}

interface IStyledProps{
  bg: color_options,
  text: color_options,
}

const StyledButton = styled.button<IStyledProps>`
  padding: 1.8rem 2.2rem;
  background-color: ${p => getColor(p.bg, p.theme)};
  font-family: ${p => p.theme.fonts.default};
  font-size: 2rem;
  font-weight: ${p => p.theme.text_style.semibold};
  color: ${p => getColor(p.text, p.theme)};
  border-radius: 1.6rem;
`

export default function Button(props:IButtonProps){
  return <div>
    <StyledButton onClick={props.onClick} bg={props.bg || "green"} text={props.text || "white"}>{props.label}</StyledButton>
  </div>
}