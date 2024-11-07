import { HTMLInputTypeAttribute } from "react"
import styled from "styled-components"

export interface InputProps{
  type: HTMLInputTypeAttribute,
  placeholder?: string,
  label?: string
}

const StyledDiv = styled.div`
  display: flex;
  flex-direction: column;
  gap: .5rem;

  label{
    font-size: 1.4rem;
    font-weight: ${p=>p.theme.text_style.semibold};
  }

  input{
    background-color: ${p => p.theme.colors.Gray};
    border: 2px solid ${p => p.theme.colors.Black};
    border-radius: 1rem;
    padding: 1.5rem;
    font-size: 1.5rem;
  }
`

export default function Input({type, label, placeholder}:InputProps){
  return <StyledDiv>
    {label && <label htmlFor={label}>{label[0].toUpperCase() + label.slice(1) + ":"}</label>}
    <input type={type} placeholder={placeholder} name={label} />
  </StyledDiv>
}