import Button from "components/Button"
import styled from "styled-components"

const StyledSection = styled.section`
  padding: 64px 32px;
  max-width: 66rem;
  display: flex;
  flex-direction: column;
  gap: 6rem;
`

const StyledTitle = styled.div`
  display: flex;
  flex-direction: column;
  gap: 2rem;
  h1{
    font-family: ${p => p.theme.fonts.default};
    font-size: 6rem;
    font-weight: bold;
    .first{
      color: ${p => p.theme.colors.Green};
    }
    .second{
      color: ${p => p.theme.colors.Dark_Yellow};
    }
  }
  p{
    font-family: ${p => p.theme.fonts.default};
    font-size: 1.8rem;
    font-weight: normal;
  }
`

const StyledTags = styled.div`
  display: flex;
  flex-direction: row;
  gap: .5rem;
  div{
    border: 1px solid ${p => p.theme.colors.Black};
    padding: 1rem;
    border-radius: 2rem;
    font-family: ${p => p.theme.fonts.default};
    font-size: 1.2rem;
    font-weight: normal;
  }
`

export default function Hero(){
  return <StyledSection>

    <StyledTitle>
      <h1>
        Take care <br/> 
        about <span className="first">your health</span> <br/> 
        Into <span className="second">your hand</span>
      </h1>
      <p> Empower your journey to better health with tailored nutrition and fitness guidance. Take control of your well-being, one step at a time, all at your fingertips. </p>
      <Button label="Get Started" onClick={() => console.log("opa")} />
    </StyledTitle>

    <StyledTags>
      <div>Nutrition</div>
      <div>Exercises</div>
      <div>Community</div>
      <div>Recipes</div>
    </StyledTags>

  </StyledSection>
}