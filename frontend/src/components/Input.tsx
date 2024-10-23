import styled from "styled-components"

const StyledInput = styled.input`
  background-color: ${p => p.theme.colors.Gray};
  border: 2px solid ${p => p.theme.colors.Black};
  border-radius: 1rem;
  padding: 1.5rem;
  font-size: 1.5rem;
`

export default function Input(){
  return <StyledInput type="email" placeholder="Insira seu email aqui..." />
}