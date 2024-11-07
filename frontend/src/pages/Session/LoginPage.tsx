import Form from "components/Form";
import { RoutesEnum } from "configs/Routes";
import { Link } from "react-router-dom";
import styled from "styled-components";

const StyledDescription = styled.p`
  .link{
    color: ${p => p.theme.colors.Dark_Yellow};
    text-decoration: none;

    &:hover{
      text-decoration: underline;
    }
  }
`

export default function LoginPage(){
  return <Form
    title="Welcome back!"
    description={<StyledDescription>Login or <Link className="link" to={RoutesEnum.REGISTER}>click here</Link> to register a new account</StyledDescription>}
    inputs={[
      {
        type: "email",
        label: "email",
        placeholder: "exemplo@exemplo.com"
      },
      {
        type: "password",
        label: "password",
        placeholder: "123@Exemplo"
      }
    ]}
    buttons={[
      {
        label: "Login",
        onClick: () => {}
      }
    ]}
  />
}