import Hero from "./Hero";
import LandingSect from "./LandingSect";

export default function LandingPage(){
  return <>
    <Hero />
    <LandingSect
      title="Fuel Your Body, Transform Your Life"
      description="Discover a personalized approach to nutrition that empowers you to make smarter choices every day. From balanced meal plans to nutrient tracking, we provide the tools to fuel your body with the energy it needs to thrive. Start your journey toward a healthier, more vibrant you—because the right nutrition changes everything."
      bg_color="yellow"
      button_label="Start Today"
    />
    <LandingSect 
      title="Your Fitness, Your Way"
      subtitle="Custom Exercises to Power Your Day"
      description="Take control of your fitness journey with workouts designed just for you. Whether you're a beginner or a pro, our customized exercise plans fit your lifestyle, goals, and schedule. Get stronger, move better, and feel your best—your fitness, your pace, your way"
      button_label="Let’s Do It"
      bg_color="green"
      align="right"
    />
    <LandingSect 
      title="Stay in the Know"
      subtitle="Health Tips Delivered to You"
      description="Never miss out on the latest in nutrition, fitness, and wellness. Subscribe to our newsletter and receive expert tips, personalized advice, and inspiring content—straight to your inbox. Stay informed, stay motivated, and take your health to the next level"
      button_label="Subscribe"
      bg_color="white"
      align="center"
      input
    />
  </>
}