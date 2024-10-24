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
  font-size: 2rem;
  font-weight: ${p => p.theme.text_style.semibold};
  color: ${p => getColor(p.text, p.theme)};
  border: 4px solid ${p => getColor(p.bg, p.theme)};
  border-radius: 1.6rem;
  cursor: pointer;
  transition-duration: 250ms;

  &:hover{
    background-color: ${p => getColor(p.text, p.theme)};
    color: ${p => getColor(p.bg, p.theme)};
    border: 4px solid ${p => getColor(p.bg, p.theme)};
  }
`

export default function Button(p:IButtonProps){
  return <div>
    <StyledButton onClick={p.onClick} bg={p.bg || "green"} text={p.text || "white"}>{p.label}</StyledButton>
  </div>
}