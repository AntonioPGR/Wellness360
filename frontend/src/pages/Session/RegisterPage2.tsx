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
    width: 100%;

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

    .line{
      display: flex;
      flex-direction: row;
      justify-content: space-between;
    }
  }
`

export default function RegisterPage2(){
  return <StyledSection>
    <form>
      <div className="title">
        <h1>Welcome</h1>
        <p>Create your account or <a>click here</a> to login into one</p>
      </div>
      <div className="forms">
        <div className="line">
          <Input type="number"label="Height: (cm)" />
          <Input type=""label="Gender:" />
        </div>
        <Input type="text" label="Work as:" />
        <Input type="file" label="Banner:" />
        <Input type="file" label="Profile picture:" />
        <Button label="Register" onClick={() => []}/>
      </div>
    </form>
  </StyledSection>
}