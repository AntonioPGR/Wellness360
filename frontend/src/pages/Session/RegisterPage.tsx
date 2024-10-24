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

export default function RegisterPage(){
  return <StyledSection>
    <form>
      <div className="title">
        <h1>Welcome</h1>
        <p>Create your account or <a>click here</a> to login into one</p>
      </div>
      <div className="forms">
        <Input type="text"label="Full name:" />
        <Input type="text"label="Username:" />
        <Input type="email" label="Email:" />
        <Input type="password"label="Password:" />
        <Input type="date"label="Birth date:" />
        <Button label="Register" onClick={() => []}/>
      </div>
    </form>
  </StyledSection>
}