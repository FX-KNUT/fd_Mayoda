import './App.css';
import Header from './components/header/header';
import Main from './components/main/main';
import Toggle from './components/themetoggle';
import { useRecoilValue } from 'recoil';
import { themeState } from './recoil/atom';

function App() {
  const theme = useRecoilValue(themeState);
  return (
    <div className={theme}>
      <Header />
      <Toggle />
      <Main />
    </div>
  );
}

export default App;
