import styled from "styled-components"
import MENU from "images/menu_closed_icon.svg"
import { Link } from "react-router-dom"
import { RoutesEnum } from "configs/Routes"

interface NavProps{
  is_open: boolean,
  setIsOpen: (value:boolean) => void
}

const NavStyled = styled.nav<{is_open:boolean}>`
  display: ${p => p.is_open? "flex" : "none"};
  justify-content: end;
  height: 100vh;
  width: 100%;
  position: fixed;
  right: 0;
  top: 0;
  background-color: rgba(0, 0, 0, .2);

  .menu{
    padding: 2rem 0;
    cursor: pointer;
    img{
      width: 50px;
    }
  }

  .links{
    display: flex;
    flex-flow: column;
    gap: 1rem;
    padding: 0 2rem;
    text-align: right;
    width: 100%;
    max-width: 600px;
    background-color: ${p => p.theme.colors.White};

    a{
      text-decoration: none;
      color: ${p => p.theme.colors.Black};
      font-size: 3rem;
      text-transform: uppercase;

      &:hover{
        text-decoration: underline;
      }
    }
  }
`

export default function NavMenu({is_open, setIsOpen}:NavProps){
  return <NavStyled is_open={is_open}>
    <div className="links">
      <div className="menu" onClick={() => setIsOpen(!is_open)}>
        <img src={MENU}  alt="Icon of a hamburger menu with three horizontal black lines, used to open a navigation menu."/>
      </div>
      <Link to={RoutesEnum.LOGIN}>Login</Link>
      <Link to={RoutesEnum.REGISTER}>Sing Up</Link>
    </div>
  </NavStyled>
}
