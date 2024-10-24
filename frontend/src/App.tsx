import Footer from "components/Footer";
import Header from "components/Header";
import { Outlet } from "react-router-dom";
import styled from "styled-components";

const StyledDiv = styled.div`
  min-height: 100vh;
  display: flex;
  flex-direction: column;

  main{
    display: flex;
    flex-direction: column;
    flex: 1;
  }
`

export default function App() {
  return <StyledDiv className="App">
    <Header />
    <main>
      <Outlet />
    </main>
    <Footer />
  </StyledDiv>
}

