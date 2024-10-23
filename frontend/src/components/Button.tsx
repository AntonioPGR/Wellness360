import styled from "styled-components";

interface ButtonProps{
  label: string,
  onClick: () => void;
}

const StyledButton = styled.button`
  padding: 1.8rem 2.2rem;
  background-color: ${p => p.theme.colors.Green};
  font-family: ${p => p.theme.fonts.default};
  font-size: 2rem;
  font-weight: 500;
  color: ${p => p.theme.colors.White};
  border-radius: 1.6rem;
`

export default function Button(props:ButtonProps){
  return <div>
    <StyledButton onClick={props.onClick}>{props.label}</StyledButton>
  </div>
}