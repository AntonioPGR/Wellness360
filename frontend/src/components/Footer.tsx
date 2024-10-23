import LOGO from "images/logo_full.svg"
import styled from "styled-components"

const StyledFooter = styled.footer`
  padding: 3rem 1.5rem;
  background-color: ${p => p.theme.colors.Black};
  display: flex;
  align-items: center;
  justify-content: space-between;

  p{
    color: ${p => p.theme.colors.White};
    font-size: 1rem;
    font-family: ${p => p.theme.fonts.default};
  }
`

export default function Footer(){
  return <StyledFooter>
    <img src={LOGO} />
    <p>Developed by Antonio PGR</p>
  </StyledFooter>
}