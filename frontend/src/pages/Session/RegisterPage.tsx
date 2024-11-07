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

export default function RegisterPage(){
  return <Form 
    title="Welcome!"
    description={<StyledDescription>Register or <Link to={RoutesEnum.LOGIN}>click here</Link> to login into your account</StyledDescription>}
    inputs={[
      {
        type: "text",
        label: "name",
      },
      {
        type: "text",
        label: "username",
      },
      {
        type: "email",
        label: "email",
      },
      {
        type: "password",
        label: "password",
      },
      {
        type: "date",
        label: "Birth date",
      },
    ]}
    buttons={[
      {
        label: "Next",
        onClick: () => {}
      }
    ]}
  />
}