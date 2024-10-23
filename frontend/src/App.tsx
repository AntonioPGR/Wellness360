import Footer from "components/Footer";
import Header from "components/Header";
import { Outlet } from "react-router-dom";

export default function App() {
  return <div className="App">
    <Header />
    <main>
      <Outlet />
    </main>
    <Footer />
  </div>
}

