import Button from "components/Button"
import Input from "components/Input";
import styled from "styled-components"
import { getAlign, getColor } from "styles/style_functions"

interface IPublishSectionProps{
  title: string,
  description: string,
  button_label: string,
  subtitle?: string,
  bg_color?: color_options,
  align?: align_options,
  input?:boolean,
}

const StyledSection = styled.section<{
  bg_color: color_options,
  align: align_options,
}>`
  padding: 2.5rem;
  background-color: ${p => getColor(p.bg_color, p.theme)};
  display: flex;
  flex-direction: row;
  justify-content: ${p => getAlign(p.align)};

  .sect_text{
    display: flex;
    flex-direction: column;
    gap: 1.5rem;
    max-width: 57rem;
    font-family: ${p => p.theme.fonts.default};
    color: ${p => p.bg_color === "white"? p.theme.colors.Black : p.theme.colors.White};
    h2{
      font-size: 3rem;
      font-weight: ${p => p.theme.text_style.semibold};
    }
    h3{
      font-size: 2rem;
      font-weight: ${p => p.theme.text_style.semibold};
    }
    p{
      font-size: 1.5rem;
      font-weight: normal;
      text-align: justify;
    }
    
  }
`;

export default function PublishSection(p:IPublishSectionProps){
  return <StyledSection bg_color={p.bg_color || "green"} align={p.align || "left"}>
    <div className="sect_text">
      <h2>{p.title}</h2>
      {p.subtitle && <h3>{p.subtitle}</h3>}
      <p>{p.description}</p>
      {p.input && <Input /> }
      <Button label={p.button_label} bg={p.bg_color === "white"? "black" : "white"} text={p.bg_color} onClick={() => []} />
    </div>
  </StyledSection>
}