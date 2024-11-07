import Button, { IButtonProps } from "components/Button";
import Input, { InputProps } from "components/Input";
import { isValidElement } from "react";
import styled from "styled-components";

const StyledSection = styled.section`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  width: 100%;
  padding: 2rem 0;

  form{
    height: max-content;
    display: flex;
    flex-direction: column;
    gap: 3rem;
    width: 40%;

    .title{
      display: flex;
      flex-direction: column;
      gap: .8rem;
      h1{
        font-size: 4.5rem;
      }
      p{
        font-size: 2rem;
        a{
          color: ${p => p.theme.colors.Dark_Yellow};
        }
      }
    }

    .forms{
      display: flex;
      flex-direction: column;
      gap: 1rem;
    }
  }
`

interface FormProps{
  inputs: InputProps[],
  title: string,
  description: string | JSX.Element,
  buttons: IButtonProps[]
}

export default function Form({buttons, description, inputs, title}:FormProps){
  return <StyledSection>
    <form>
      <div className="title">
        <h1>{title}</h1>
        {isValidElement(description)? description : <p>{description}</p>}
      </div>
      <div className="forms">
        {
          inputs.map((i, index) => <Input key={i.label || index} type={i.type} placeholder={i.placeholder} label={i.label} />)
        }
        {
          buttons.map((b) => <Button key={b.label} text={b.text} onClick={b.onClick} bg={b.bg} label={b.label} />)
        }
      </div>
    </form>
  </StyledSection>
}