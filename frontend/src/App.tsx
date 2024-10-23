import Header from "components/Header";
import Hero from "pages/home/Hero";

export default function App() {
  return <div className="App">
    <Header />
    <main>
      <Hero />
      <HeroSection />
    </main>
  </div>
}

