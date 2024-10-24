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
    font-size: 1.5rem;

    a{
      color: ${p => p.theme.colors.White};
    }
  }
`

export default function Footer(){
  return <StyledFooter>
    <img src={LOGO} alt="Logo of three stylized wheat stalks with yellow-green leaves outlined in white with Wellness360 written by it's side"/>
    <p>Developed by <a href="https://linkedin.com/in/AntonioPGR" target="_blank"  rel="noreferrer">Antonio PGR</a></p>
  </StyledFooter>
}