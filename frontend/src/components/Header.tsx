import LOGO from "images/logo_short.svg"
import MENU from "images/menu_icon.svg"
import styled from "styled-components"
import { useState } from "react"
import NavMenu from "./NavMenu"

const StyledHeader = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1.5rem 2rem;

  .menu{
    cursor: pointer;
    img{
      width: 50px;
    }
  }
`

export default function Header(){

  const [is_open, setIsOpen] = useState(false);

  return <StyledHeader >
    <img src={LOGO} alt="Logo of three stylized wheat stalks with yellow-green leaves outlined in black"/>
    <div className="menu" onClick={() => setIsOpen(!is_open)}>
      <img src={MENU}  alt="Icon of a hamburger menu with three horizontal black lines, used to open a navigation menu."/>
    </div>
    <NavMenu is_open={is_open} setIsOpen={(value:boolean) => setIsOpen(value)} />
  </StyledHeader>
}