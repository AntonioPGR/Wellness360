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

export default function RegisterPage2(){
  return <Form
    title="Welcome!"
    description={<StyledDescription>Register or <Link to={RoutesEnum.LOGIN}>click here</Link> to login into your account</StyledDescription>}
    inputs={[
      {
        type: "number",
        label: "height"
      },
      {
        type: "select",
        label: "gender"
      },
      {
        type: "text",
        label: "work as"
      },
      {
        type: "file",
        label: "banner"
      },
      {
        type: "file",
        label: "profile picture"
      },
    ]}
    buttons={[
      {
        label: "Register",
        onClick: () => {}
      }
    ]}
  />
}

