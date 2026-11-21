import solarLogo from '../assets/solar-energy-logo.png';

export default function SolarLogo({ size = 180 }) {
  return (
    <img 
      src={solarLogo}
      alt="Solar Energy Management"
      style={{ width: size, height: 'auto' }}
    />
  );
}
