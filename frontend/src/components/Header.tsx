import LOGO from "images/logo_short.svg"
import MENU from "images/menu_icon.svg"
import styled from "styled-components"

const StyledHeader = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px 32px;

  img{
    width: 50px;
  }
`

export default function Header(){
  return <StyledHeader>
    <img src={LOGO} alt="Logo of three stylized wheat stalks with yellow-green leaves outlined in black"/>
    <img src={MENU}  alt="Icon of a hamburger menu with three horizontal black lines, used to open a navigation menu."/>
  </StyledHeader>
} 