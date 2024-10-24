import Button from "components/Button";
import Input from "components/Input";
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

export default function LoginPage(){
  return <StyledSection>
    <form>
      <div className="title">
        <h1>Welcome back!</h1>
        <p>Login into your account or <a>click here</a> to create a new one</p>
      </div>
      <div className="forms">
        <Input type="email" label="Email:" />
        <Input type="password"label="Password:" />
        <Button label="Login" onClick={() => []}/>
      </div>
    </form>
  </StyledSection>
}